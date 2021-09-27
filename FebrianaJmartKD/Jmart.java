package FebrianaJmartKD;


/**
 * class Jmart
 *
 * @author Febriana Pasonang Sidauruk (1906300725)
 * @version 11 September 2021
 */
public class Jmart
{
    
    public static void main(String[] args)
    {
        
    }
    
    public static Product createProduct(){
        PriceTag priceTag = new PriceTag(10000);
        //Product product = new Product("PULPEN",3,false,priceTag, ProductCategory.STATIONERY);
        //return product;
        return null;
    }
    
    public static Coupon createCoupon(){
        Coupon coupon = new Coupon("Hari Merdeka",1, Coupon.Type.DISCOUNT, 17, 8000);
       return coupon;
    }
    
    public static Duration createDuration(){
        //return new ShipmentDuration(ShipmentDuration.REGULER, ShipmentDuration.KARGO);
        return null;
   }
}
