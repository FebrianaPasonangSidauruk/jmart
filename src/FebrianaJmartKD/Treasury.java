package FebrianaJmartKD;


/**
 * class Treasury
 *
 * @author Febriana Pasonang Sidauruk
 * @version 18 September 2021
 */
public class Treasury
{
    public static final double COMMISSION_MULTIPLIER = 0.05d;
    public static final double BOTTOM_PRICE = 20000.0d;
    public static final double BOTTOM_FEE = 1000.0d;
    
    public static double getAdjustedPrice(double price, double discount){
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }
    
    public static double getAdminFee(double price, double discount){
        double afterDiscount = getDiscountedPrice(price, discount);
        if (afterDiscount < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        else{
            return afterDiscount * COMMISSION_MULTIPLIER;
        }
    }
    
    private static double getDiscountedPrice(double price, double discount){
         if (discount > 100.0){
            discount = 100.0;
        }
        if (discount == 100.0){
            return 0.0;
        }
        else{
            return price * ((100.0 - discount)/100.0);
        }
    }
}
