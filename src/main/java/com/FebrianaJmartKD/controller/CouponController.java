package com.FebrianaJmartKD.controller;

import java.util.List;

import com.FebrianaJmartKD.*;
import com.FebrianaJmartKD.Algorithm;
import com.FebrianaJmartKD.Coupon;
import com.FebrianaJmartKD.Predicate;
import com.FebrianaJmartKD.Product;
import com.FebrianaJmartKD.dbjson.JsonAutowired;
import com.FebrianaJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>{
    public static @JsonAutowired(value= Coupon.class, filepath="C:/Users/Febriana/jmart/jmart/src/main/java/com/Json/coupon.json") JsonTable<Coupon> couponTable;

    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    @GetMapping("/{id}/canApply")
    public boolean canApply(@PathVariable int id, @PathVariable double price, @PathVariable double discount){
        for(Coupon coupon : couponTable){
            if(coupon.id == id){
                return coupon.canApply(price, discount);
            }
        }
        return false;
    }

    @GetMapping("/{id}/isUsed")
    public boolean isUsed(@PathVariable int id){
        for(Coupon coupon : couponTable){
            if(coupon.id == id){
                return coupon.isUsed();
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    public List<Coupon> getAvailable(@RequestParam int page, @RequestParam int pageSize){
        Predicate<Coupon> pred = coupon -> !coupon.isUsed();
        return Algorithm.paginate(couponTable, page, pageSize, pred);
    }

}
