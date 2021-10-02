package FebrianaJmartKD;


/**
 *  class Filter
 *
 * @author Febriana Pasonang Sidauruk
 * @version 2 Oktober 2021
 */

import java.util.ArrayList;

public class Filter
{
    public static ArrayList<PriceTag>filterPriceTag(PriceTag[] list, double value, boolean less){
        ArrayList<PriceTag> priceTags = new ArrayList<>();
            for(PriceTag i : list){
                if(less && i.getAdjustedPrice() < value || !less && i.getAdjustedPrice() >= value){
                priceTags.add(i);
                }
            }
        return priceTags;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
        for (int n = 0; n<list.size(); ++n){
            final ProductRating prodRat = list.get(n);
            if(less && prodRat.getAverage() < value || !less && prodRat.getAverage() >= value)
                list.remove(n);
        }
    }
}
