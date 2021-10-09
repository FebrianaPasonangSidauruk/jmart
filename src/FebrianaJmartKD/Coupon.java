package FebrianaJmartKD;


/**
 * class Coupon
 *
 * @author Febriana Pasonang Sidauruk
 * @version 20 September 2021
 */
public abstract class Coupon extends Recognizable implements FileParser
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public enum Type{
    DISCOUNT,
    REBATE;
    }
    
    public Coupon(int id, String name, int code, Type type, double cut, double minimum){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }
    
    public boolean isUsed(){
    return used;
    }
    
    public boolean canApply(PriceTag priceTag){
    if(priceTag.getAdjustedPrice() >= minimum && used == false){
    return true;
    }
    else{
    return false;
    }
    }
    
    public double apply(PriceTag priceTag){
    used = true;
    
    if(type==Type.DISCOUNT){
         return (100 - cut) / 100 * priceTag.getAdjustedPrice();
    }
    else if(type == Type.REBATE){
        return priceTag.getAdjustedPrice() - cut;
    }
    else {
        return 0.0;
    }
    }
    
    
}

