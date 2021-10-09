package FebrianaJmartKD;


/**
 * class Recognizable
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public class Recognizable implements Comparable<Recognizable>
{
    public final int id;
    
    protected Recognizable (int id){
    
        this.id = id;
    }

    @Override
    public int compareTo(Recognizable other){
        return(this.id <other.id) ? -1 :((
                this.id == other.id)?0 : 1);
    }

    public boolean equals(Object obj){
    if(obj instanceof Recognizable){
            Recognizable recognizable = (Recognizable) obj;
            return (recognizable.id == this.id);
        }
    return false;
    }
    
    public boolean equals(Recognizable recognizable){
    if(recognizable.id == this.id){
        return true;
    }
    else{
        return false;
    }
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id){
        return 0;
    }

    public static <T extends Recognizable> int getClosingId(Class<T> clazz){
        return 0;
    }

}
