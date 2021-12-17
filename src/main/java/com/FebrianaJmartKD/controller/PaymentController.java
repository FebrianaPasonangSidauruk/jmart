package com.FebrianaJmartKD.controller;

/**
 * class PaymentController
 *
 * mengontrol pembelian dan disini juga ditampilkan pesan apakah dalam progress, dibatalkan, menunggu konfirmasi, ataupun on delivery
 *
 * @author Febriana Pasonang Sidauruk
 *
 */

import com.FebrianaJmartKD.ObjectPoolThread;
import com.FebrianaJmartKD.Payment;
import com.FebrianaJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import com.FebrianaJmartKD.dbjson.JsonAutowired;
import com.FebrianaJmartKD.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>  {
    public static final long DELIVERED_LIMIT_MS =2000;
    public static final long ON_DELIVERY_LIMIT_MS = 2000;
    public static final long ON_PROGRESS_LIMIT_MS = 2000;
    public static final long WAITING_CONF_LIMIT_MS = 2000;
    public static @JsonAutowired(value = Payment.class, filepath = "C:/Users/Febriana/jmart/jmart/src/main/java/com/Json/payment.json")
    JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread", PaymentController::timekeeper);

    //Mendapatkan invoice dari penjual produk
    @GetMapping("/{id}/page")
    @ResponseBody List<Payment> getInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Payment> paymentList = new ArrayList<>();
        Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
        if(accountTarget != null){
            for(Payment payment : paymentTable){
                for(Product product : ProductController.productTable){
                    if(payment.productId == product.id && product.accountId == accountTarget.id){
                        paymentList.add(payment);
                    }
                }
            }
        }
        return Algorithm.paginate(paymentList, page, pageSize, e->true);
    }

    //Mendapatkan invoice dari purchase
    @GetMapping("/{id}/purchases/page")
    @ResponseBody List<Payment> getMyInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        return Algorithm.<Payment>paginate(getJsonTable(), page, pageSize, p -> p.buyerId == id);
    }


    @PostMapping("/{id}/accept")
    boolean accept(@RequestParam int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "ON_PROGRESS"));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "CANCELLED"));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/create")
    Payment create(@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
        for(Account account : AccountController.accountTable){
            if(account.id == buyerId){
                for(Product product : ProductController.productTable){
                    System.out.println("Check 1");
                    if(product.id == productId){
                        System.out.println("Check 2");
                        Payment newPayment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                        System.out.println("Check 3");
                        double totalPay = newPayment.getTotalPay(product);
                        System.out.println(totalPay);
                        System.out.println("Check 4");
                        if(account.balance >= totalPay){
                            System.out.println("Check 5");
                            account.balance -= totalPay;
                            newPayment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING_CONFIRMATION"));
                            paymentTable.add(newPayment);
                            poolThread.add(newPayment);
                            return newPayment;
                        }
                    }
                }
            }
        }
        return null;
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, String receipt) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.ON_PROGRESS){
                    if(!receipt.isBlank()){
                        payment.shipment.receipt = receipt;
                        payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Boolean timekeeper(Payment payment) {
        if (payment.history.isEmpty()) {
            return false;
        } else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();
            if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.DELIVERED;
                return true;
            } else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
                record.status = Invoice.Status.FINISHED;
                return true;
            } else {
                return false;
            }
        }
    }
}
