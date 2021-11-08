package FebrianaJmartKD;


/**
 * class Jmart
 *
 * @author Febriana Pasonang Sidauruk (1906300725)
 * @version 11 September 2021
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

public class Jmart {

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(minPrice <= 0.0){
                if(list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            }else if(maxPrice <= 0.0){
                if(list.get(i).price >= minPrice){
                    products.add(list.get(i));
                }
            }else{
                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            }
        }
        return products;
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize){
        Predicate<Product> pred= n -> (n.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, pred);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
        Predicate<Product> pred= n -> (n.accountId == accountId);
        return paginate(list, page, pageSize, pred);
    }

    public static void main(String[] args)
    {
        try{
            // sesuaikan argument method read sesuai dengan lokasi resource
            List<Product> list = read("C:/Users/FEBRIANA/jmart/jmart/src/randomProductList.json");
            //List<Product> filtered = filterByPrice(list, 20000.0, 25000.0);
            //filtered.forEach(product -> System.out.println(product.price));

            List<Product> filteredName = filterByName(list, "at", 1, 2);
            filteredName.forEach(product -> System.out.println(product.name));
            List<Product> filteredAccount = filterByAccountId(list, 1, 0, 5);
            filteredAccount.forEach(product -> System.out.println(product.name));
        }catch (Throwable t)
        {
            t.printStackTrace();
        }

    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred){
        return list.stream().filter(n -> pred.predicate(n)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
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
    }

}
