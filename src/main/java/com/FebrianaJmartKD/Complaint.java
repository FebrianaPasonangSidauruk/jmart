package com.FebrianaJmartKD;


/**
 * class Complaint
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */

import java.util.Date;
import java.text.SimpleDateFormat;


public class Complaint extends Serializable
{
   public Date date;
   public String desc;

   public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }
   
    @Override
    /*public boolean read(String content){
        return false;
    }*/
    
    public String toString(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormat = SDFormat.format(this.date);
        return ("Complaint{date=" + dateFormat + "desc='" +this.desc+ "'}");
    }
}
