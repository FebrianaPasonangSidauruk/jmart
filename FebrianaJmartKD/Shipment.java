package FebrianaJmartKD;


/**
 * class Shipment
 *
 * @author Febriana Pasonang Sidauruk
 * @version 27 September 2021
 */

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
  public static class Duration
    {
        public static final Duration INSTANT = new Duration((byte)(1<<0));
        public static final Duration SAME_DAY = new Duration((byte)(1<<1));
        public static final Duration NEXT_DAY = new Duration((byte)(1<<2));
        public static final Duration REGULER = new Duration((byte)(1<<3));
        public static final Duration KARGO = new Duration((byte)(1<<4));
        public final byte bit;
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy"); 
        
        private Duration(byte bit){
            this.bit = bit;
        }
        
        
        public String getEstimatedArrival(Date reference){
             Calendar cal = Calendar.getInstance();
             cal.setTime(reference);
             
               if (bit == Duration.NEXT_DAY.bit){
                cal.add(Calendar.DATE, 1);
            }
            else if (bit == Duration.REGULER.bit){
                cal.add(Calendar.DATE, 2);
            }
            else if (bit == Duration.KARGO.bit){
                cal.add(Calendar.DATE, 5);
            }
            
            return ESTIMATION_FORMAT.format(cal.getTime());
        }
    }
    
    public class MultiDuration{
        public byte bit;
        
        public MultiDuration(Duration... args)
        {
            byte flags = 0;
            for (Duration arg : args) { 
                flags |= arg.bit; 
            }
            this.bit = flags;
        }
        
        public boolean isDuration(Duration reference){
            return(bit & reference.bit)!= 0;
        }
    }

}
