package com.FebrianaJmartKD.controller;

/**
 * class Product Controller
 *
 * @author Febriana Pasonang Sidauruk
 *
 * Mengontrol produk untuk mendapatkan produk yang diinginkan, membuat produk, dan melakukan filter dalam berbagai parameter
 */

import com.FebrianaJmartKD.*;
import com.FebrianaJmartKD.dbjson.JsonAutowired;
import com.FebrianaJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
   @JsonAutowired(value = Product.class, filepath = "C:/Users/Febriana/jmart/jmart/src/main/java/com/Json/randomProductList.json")
   public static JsonTable<Product> productTable;

    //Mendapatkan produk dari penjual
    @GetMapping("/{id}/page")
    @ResponseBody List<Product> getProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Product> productList = new ArrayList<>();
        Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
        if(accountTarget != null){
            for(Product product : ProductController.productTable){
                for(Payment payment : PaymentController.paymentTable){
                    if(payment.productId == product.id && product.accountId == accountTarget.id){
                        productList.add(product);
                    }
                }
            }
        }
        return Algorithm.paginate(productList, page, pageSize, e->true);
    }

    //Mendapatkan produk dari pembelian penjual
    @GetMapping("/{id}/purchases/page")
    @ResponseBody List<Product> getMyProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Product> productList = new ArrayList<>();
        List<Payment> paymentList = Algorithm.<Payment>paginate(PaymentController.paymentTable, page, pageSize, p -> p.buyerId == id);
        for(Product product : getJsonTable()){
            for(Payment payment : paymentList){
                if(payment.productId == product.id){
                    productList.add(product);
                }
            }
        }
        return Algorithm.<Product>paginate(productList, page, pageSize, e -> true);
    }

    @Override
    public JsonTable<Product> getJsonTable() {
        return productTable;
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        Predicate<Product> predicate = obj -> (obj.accountId == id);
        return Algorithm.<Product>paginate(productTable, page, pageSize, obj -> (obj.accountId == id));
    }

    @PostMapping("/create")
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
            )
    {
        for(Account account : AccountController.accountTable){
            if(account.id == accountId && account.store != null){
                Product newProduct = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(newProduct);
                return newProduct;
            }
        }
        return null;
    }

    @GetMapping("/getFiltered")
    List<Product> getProductByStore
            (
                    @RequestParam(defaultValue="0")  int page,
                    @RequestParam(defaultValue="5")  int pageSize,

                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )
    {
        Predicate<Product> predicate = obj -> (
                (obj.name.toLowerCase().contains(search.toLowerCase())) && (obj.price >= minPrice && obj.price <= maxPrice) && (obj.category == category)
        );
        return Algorithm.<Product>paginate(productTable, page, pageSize, predicate);
    }

    @GetMapping("/getSearched")
    List<Product> getProductSearched(@RequestParam String search)
    {
        Predicate<Product> predicate = obj -> (obj.name.toLowerCase().contains(search.toLowerCase()));
        return Algorithm.<Product>collect(getJsonTable(), predicate);
    }
}
