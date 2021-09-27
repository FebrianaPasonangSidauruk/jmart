package FebrianaJmartKD;


/**
 * class Invoice
 *
 * @author Febriana Pasonang Sidauruk
 * @version 27 September 2021
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
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
    FAILED
    }
    
    protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "date";
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    abstract double getTotalPay();
    
}
