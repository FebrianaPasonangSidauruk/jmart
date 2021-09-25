package FebrianaJmartKD;


/**
 * class Transaction
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
abstract class Transaction extends Recognizable
{
    public String time;
    public int buyerId;
    public int storeId;
    public Rating rating;
    
    public enum Rating{
    NONE,
    BAD,
    NEUTRAL,
    GOOD 
    }
    
    protected Transaction(int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction(int id, Account buyer, Store store){
    super(id);
    }
}
