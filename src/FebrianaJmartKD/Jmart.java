package FebrianaJmartKD;


/**
 * class Jmart
 *
 * @author Febriana Pasonang Sidauruk (1906300725)
 * @version 11 September 2021
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

public class Jmart
{
    class Country
    {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args)
    {
        String filepath = "C:/Users/FEBRIANA/jmart/jmart/src/city.json";
        Gson gson = new Gson();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states:");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


       /* Complaint complaint = new Complaint (002, "Pengiriman terlalu lama");
        System.out.print(complaint);
        Account account = new Account(11,"sukaBelanja","belanja@gmail.com","AyoBelanja11");
        account.validate();
        System.out.print(account);
       System.out.println(Shipment.Duration.NEXT_DAY.getEstimatedArrival(new Date())); */
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
