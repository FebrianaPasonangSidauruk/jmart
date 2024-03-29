package com.FebrianaJmartKD;


/**
 * class Store
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 *
 * untuk akun store
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store
{
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    public static final String REGEX_PHONE = "^[0-9]{9,12}";
    public static final String REGEX_NAME = "^[A-Z](?!.*([ ])\1).{3,19}$";
    
    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    
    @Override
    /*public boolean read(String content){
        return false;
    }*/

    public String toString(){
        return(
            "name: " + name +"\n" +
            "address: " + address + "\n" +
            "phoneNumber: " + phoneNumber + "\n"
        );
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        return matcher.find() && matcher2.find();
    }
}
