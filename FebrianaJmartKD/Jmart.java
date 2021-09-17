package FebrianaJmartKD;


/**
 * class Jmart
 *
 * @author Febriana Pasonang Sidauruk (1906300725)
 * @version 11 September 2021
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
        return (float) (before - after)/before * 100;
    }
    }

   
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
       if(discountPercentage > 100.0f) {
        return 0;
        }
        else{
        float total = price - (price*(discountPercentage/100));
        return (int) total;
    }
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
       return (int) (discountedPrice * 100.0f / (100.0f - discountPercentage));
   }
    
    public static float getCommissionMultiplier()
    {
       return 0.05f;
    }
    
    public static int getAdjustedPrice(int price)
    {
       float adjustedPrice = price + getCommissionMultiplier() * price;
       return (int) adjustedPrice;
    }
    
    public static int getAdminFee(int price)
    {
       float fee = price * getCommissionMultiplier();
       return (int) fee;
    }
    
    public static void main(String[] args)
    {
       
    }
}
