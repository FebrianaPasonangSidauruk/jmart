package FebrianaJmartKD;


/**
 * class Payment
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public class Payment extends Invoice implements Transactor 
{
    public int productCount;
    public Shipment shipment;
    
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    public double getTotalPay(){
        return 0.0;
    }

    public boolean validate(){
        return false;
    }
    
    public Invoice perform(){
        return null;
    }
    
    
}
