package com.FebrianaJmartKD;


/**
 * class Shipment
 *
 * @author Febriana Pasonang Sidauruk
 * @version 27 September 2021
 *
 * flags dalam pemrograman untuk memberi informasi ekspedisi
 */

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Shipment
{
    public String address;
    public int shipmentCost;
    public byte plan;
    public String receipt;
    public static final Plan INSTANT = new Plan((byte)(1<<0));
    public static final Plan SAME_DAY = new Plan((byte)(1<<1));
    public static final Plan NEXT_DAY = new Plan((byte)(1<<2));
    public static final Plan REGULER = new Plan((byte)(1<<3));
    public static final Plan KARGO = new Plan((byte)(1<<4));
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");


    static class Plan
    {
        public final byte bit;
        private Plan(byte bit)
        {
            this.bit = bit;
        }
    }
    
    public Shipment(String address, int shipmentCost, byte plan, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.plan = plan;
        this.receipt = receipt;
    }
    
    /*@Override
    public boolean read(String content){
        return false;
    }*/
        
    public String getEstimatedArrival(Date reference){
        if((plan & INSTANT.bit) != 0 || (plan & SAME_DAY.bit) != 0){
            return ESTIMATION_FORMAT.format(reference);
        }else if((plan & NEXT_DAY.bit) != 0){
            return ESTIMATION_FORMAT.format(reference.getDay() + 1);
        }else if((plan & REGULER.bit) != 0){
            return ESTIMATION_FORMAT.format(reference.getDay() + 2);
        }else {
            return ESTIMATION_FORMAT.format(reference.getDay() + 5); //KARGO
        }
    }

    public boolean isDuration(Plan reference)
    {
        if((plan & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuration(byte object, Plan reference)
    {
        if((object & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
}

