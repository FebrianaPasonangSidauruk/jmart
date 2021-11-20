package com.FebrianaJmartKD;


import com.FebrianaJmartKD.dbjson.Serializable;

/**
 * class Product
 *
 * @author Febriana Pasonang Sidauruk
 * @version 18 September 2021
 */
public class Product extends Serializable
{
    public int accountId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public double discount;
    public ProductCategory category;
    public double price;
    public byte shipmentPlans;
    
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    
    @Override
    public String toString(){
        return "Name: " + name +
                "\nWeight: " + weight +
                "\nconditionUsed: " + conditionUsed +
                "\nprice: " + price +
                "\ncategory: " + category +
                "\ndiscount: " + discount +
                "\naccountId: " + accountId;
    }
    
    /*public boolean read(String content){
        return false;
    }*/
}
