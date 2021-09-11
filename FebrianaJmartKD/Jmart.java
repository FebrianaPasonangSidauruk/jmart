package FebrianaJmartKD;


/**
 * class Jmart
 *
 * @Febriana Pasonang Sidauruk (1906300725)
 * @11 September 2021
 */
public class Jmart
{
    
    
    public static int getPromo()
    {
       return 0;
    }
    
    public static String getCustomer()
    {
       return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after)
    {
       if(before<after){
        return 0.0f;
        }
        else{
        float diskon = ((before - after)/before)*100;
        return diskon;
    }
    }

   
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
       if(discountPercentage > 100.0) {
        discountPercentage = 100;
        }
        float total = price - (price*(discountPercentage/100));
        return (int) total;
    }
    
    public static int OriginalPrice(int discountedPrice, float discountPercentage)
    {
       int original = discountedPrice + (int) discountPercentage;
       return original;
    }
    
    public static float CommissionMultiplier()
    {
       return 0.05f;
    }
    
    public static int getAdjustedPrice(int price)
    {
       int adjustedPrice = price + (int) CommissionMultiplier();
       return adjustedPrice;
    }
    
    public static int getAdminFee(int price)
    {
       int fee = price/2;
       return fee;
    }
    
    public static void main(String[] args)
    {
       
    }
}
