package FebrianaJmartKD;


/**
 * class PriceTag
 *
 * @author Febriana Pasonang Sidauruk
 * @version 18 September 2021
 */
public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05d;
    public static final double BOTTOM_PRICE = 20000.0d;
    public static final double BOTTOM_FEE = 1000.0d;
    public double discount;
    public double price;
    
    public PriceTag(double price){
        this.price = price;
    }
    
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice(){
    return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee(){
    double afterDiscount = getDiscountedPrice();
    if (afterDiscount < BOTTOM_PRICE){
        return BOTTOM_FEE;
    }
    else{
        return afterDiscount - COMMISSION_MULTIPLIER;
    }
    }
    
    private double getDiscountedPrice(){
        if (discount > 100.0){
        return 100.0;
        }
        else if(discount == 100.0){
        return 0.0;
        }
        else{
        return price - (price * (discount/100));
        }
    }
}
