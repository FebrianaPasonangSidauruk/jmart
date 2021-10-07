package FebrianaJmartKD;


/**
 * class Recognizable
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public class Recognizable
{
    public final int id;
    
    protected Recognizable (int id){
    
        this.id = id;
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
}
