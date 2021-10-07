package FebrianaJmartKD;


/**
 * 
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public interface FileParser
{
    boolean read(String content);
    
    default Object write(){
        return null;
    }
    
    static Object newInstance(String content){
        return null;
    };
}
