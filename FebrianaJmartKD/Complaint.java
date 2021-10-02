package FebrianaJmartKD;


/**
 * class Complaint
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Recognizable implements FileParser
{
   public Date date;
   public String desc;

   public Complaint(int id, String desc){
       
        super(id);
        this.desc = desc;
        this.date = new Date();
    }
   
    @Override
    public boolean read(String content){
        return false;
    }
    
}
