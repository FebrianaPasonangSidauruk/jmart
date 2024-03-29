package com.FebrianaJmartKD;

/**
 * class Phone Top Up
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */

public class PhoneTopUp extends Invoice
{
    public String phoneNumber;
    public Status status;
    public PhoneTopUp(int buyerId, int productId, String phoneNumber){
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public double getTotalPay(Product product){
        return Treasury.getAdjustedPrice(product.price, product.discount);
    }
}
