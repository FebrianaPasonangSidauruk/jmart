package FebrianaJmartKD;


/**
 * class ShipmentDuration
 *
 * @author Febriana Pasonang Sidauruk
 * @version 20 September 2021
 */
public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration (1<<0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration (1<<1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration (1<<2);
    public static final ShipmentDuration REGULER = new ShipmentDuration (1<<3);
    public static final ShipmentDuration KARGO = new ShipmentDuration (1<<4);
    private final int bit;
    
    private ShipmentDuration(int bit){
    this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args){
        int var = args[0].bit;
        for (int i = 1; i < args.length; i++){
            var = var | args[i].bit;
        }
        this.bit = var;
    }
    
    public boolean isDuration(ShipmentDuration reference){
        return (this.bit & reference.bit) == reference.bit;
    }
}
