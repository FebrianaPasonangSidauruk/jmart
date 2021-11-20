package com.FebrianaJmartKD;


/**
 * class Jmart
 *
 * @author Febriana Pasonang Sidauruk (1906300725)
 * @version 11 September 2021
 */

import com.FebrianaJmartKD.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.FebrianaJmartKD.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

@SpringBootApplication

public class Jmart {

    public static long DELIVERED_LIMIT_MS ;
    public static long ON_DELIVERY_LIMIT_MS ;
    public static long ON_PROGRESS_LIMIT_MS ;
    public static long WAITING_CONF_LIMIT_MS ;

    public static void main (String[] args){
        //SpringApplication.run(Jmart.class, args);

        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() ->JsonDBEngine.join()));

        /*try
        {
            // sesuaikan argument dibawah dengan lokasi resource file yang Anda unduh di EMAS!
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "C:/Users/FEBRIANA/jmart/jmart/src/randomPaymentList.json");
            // membuat thread untuk payment pool
            ObjectPoolThread<Payment>paymentPool =new ObjectPoolThread<Payment>("Thread-pp", Jmart::paymentTimekeeper);
            // menjalankan thread (ingat menggunakan start bukan run), run melakukan instruksi dalam current thread
            paymentPool.start();
            //tambahkan seluruh payment hasil baca ke dalam pool
            table.forEach(payment ->paymentPool.add(payment));
            // berikan sinyal untuk keluar dari routine apabila seluruh objek telah di proses
            while (paymentPool.size() != 0);
            paymentPool.exit();
            // tunggu hingga thread selesai di eksekusi
            while (paymentPool.isAlive());
            // thread telah berhasil di selesaikan
            System.out.println("Thread exited successfully");
            // cek hasil output
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment.history);
                System.out.println(history);
            });
        }
        catch (Throwable t) {
            t.printStackTrace();
        }*/

    }

    /*public static boolean paymentTimekeeper(Payment payment) {
        if(payment.history.size() == 0){
            return true;
        }
        else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();

            if (record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Waiting"));
                return true;
            } else if (record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Progress"));
                return true;
            } else if (record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "Delivery"));
                return true;
            } else if (record.status == Invoice.Status.DELIVERED && elapsed > DELIVERED_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Finish"));
                return true;
            }
            else {
                return false;
            }
        }
    }*/

    /*public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        if(minPrice <= 0){
            list.removeIf(product -> product.price > maxPrice);
        }else if(maxPrice <= 0){
            list.removeIf(product -> product.price < minPrice);
        }else{
            list.removeIf(product -> (product.price < minPrice) || (product.price > maxPrice));
        }
        return list;
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize){
        Predicate<Product> pred= n -> (n.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, pred);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
        Predicate<Product> pred= n -> (n.accountId == accountId);
        return paginate(list, page, pageSize, pred);
    }




    /*private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred){
        try{
            List<Product> filteredList = list.stream().filter(p -> pred.predicate(p)).collect(Collectors.toList());
            int endIndex = (page * pageSize) + pageSize;
            if(endIndex > filteredList.size()){
                endIndex = filteredList.size();
            }
            return filteredList.subList((page * pageSize), endIndex);
        }catch (Exception e){
            return list.subList(0 ,0);
        }
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }*/

}
