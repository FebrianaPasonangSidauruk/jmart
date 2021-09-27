package FebrianaJmartKD;


/**
 * class Complaint
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public class Complaint extends Recognizable implements FileParser
{
   public String date;
   public String desc;

   public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = "monday";
    }
   
    @Override
    public boolean read(String content){
        return false;
    }
    
}
