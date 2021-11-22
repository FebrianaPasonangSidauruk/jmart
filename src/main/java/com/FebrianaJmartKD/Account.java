package com.FebrianaJmartKD;


/**
 * class Account
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */

import com.FebrianaJmartKD.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?!.* ).{8,}$";
    public String name;
    public String email;
    public String password;
    public double balance;
    public Store store;
    
    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;

    }
    
    /*@Override
    public boolean read(String content){
        return false;
    }*/
    
    
    @Override
    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "email: " + this.email + "\n" +
            "password: " + this.password + "\n"
        );
    }
    
    
     public boolean validate()
    {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        return matcherEmail.find() && matcherPassword.find();
    }

}
