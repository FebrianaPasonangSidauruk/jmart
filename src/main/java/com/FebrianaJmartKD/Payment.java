package com.FebrianaJmartKD;
import java.util.ArrayList;
import java.util.Date;

/**
 * class Payment
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public class Payment extends Invoice
{
    public ArrayList<Record> history = new ArrayList<>();
    public int productCount;
    public Shipment shipment;

    public static class Record{
        public final Date date;
        public String message;
        public Status status;
        public Record(Status status, String message){
            this.date = new Date();
            this.status = status;
            this.message = message;
        }
    }
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    @Override
    public double getTotalPay(Product product){
        return (productCount * Treasury.getAdjustedPrice(product.price, product.discount));
    }
    
    /*@Override
    public boolean validate(){
        return false;
    }
    
    @Override
    public Invoice perform(){
        return null;
    }*/
    
    
}
