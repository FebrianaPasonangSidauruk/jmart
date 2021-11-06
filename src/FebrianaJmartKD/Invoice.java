package FebrianaJmartKD;


/**
 * class Invoice
 *
 * @author Febriana Pasonang Sidauruk
 * @version 27 September 2021
 */


import java.util.Date;
import java.util.ArrayList;

public abstract class Invoice extends Serializable
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history= new ArrayList<>();
    
    enum Rating{
    NONE,
    BAD,
    NEUTRAL,
    GOOD
    }
    
    enum Status{
    WAITING_CONFIRMATION,
    CANCELLED,
    ON_PROGRESS,
    ON_DELIVERY,
    COMPLAINT,
    FINISHED,
    FAILED
    }
    
    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
        this.complaintId = -1;

    }

    /*public boolean read(String content){
        return false;
    }*/
    
    public abstract double getTotalPay();
    
    class Record{
        public Status status;
        public Date date;
        public String message;
    }
    
}
