package com.FebrianaJmartKD;


/**
 * class Invoice
 *
 * @author Febriana Pasonang Sidauruk
 * @version 27 September 2021
 */


import com.FebrianaJmartKD.dbjson.Serializable;

import java.util.Date;

public abstract class Invoice extends Serializable
{
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    //public Status status;
    //public ArrayList<Record> history= new ArrayList<>();
    
    public enum Rating{
    NONE,
    BAD,
    NEUTRAL,
    GOOD
    }
    
    public enum Status{
    WAITING_CONFIRMATION,
    CANCELLED,
    ON_PROGRESS,
    ON_DELIVERY,
    COMPLAINT,
    FINISHED,
    FAILED, DELIVERED
    }
    
    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.complaintId = -1;
    }
    
    public abstract double getTotalPay(Product product);
    
    class Record{
        public Status status;
        public Date date;
        public String message;
    }
    
}
