package FebrianaJmartKD;


/**
 * class Jmart
 *
 * @author Febriana Pasonang Sidauruk (1906300725)
 * @version 11 September 2021
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jmart
{
    
    public static void main(String[] args)
    {
        Complaint complaint = new Complaint (002, "Pengiriman terlalu lama");
        System.out.print(complaint);
        Account account = new Account(11,"sukaBelanja","belanja@gmail.com","AyoBelanja11");
        account.validate();
        System.out.print(account);
       System.out.println(Shipment.Duration.NEXT_DAY.getEstimatedArrival(new Date())); 
    }
    
    public static Product createProduct(){
        return null;
    }
    
    public static Coupon createCoupon(){
        return null;
    }
    
    public static Shipment.Duration createShipmentDuration(){
        return null;
   }
}
