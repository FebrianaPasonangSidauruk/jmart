package FebrianaJmartKD;


/**
 * class ProductRating
 *
 * @author Febriana Pasonang Sidauruk
 * @version 18 September 2021
 */
public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating(){
    long total, count = 0;
    }
    
    public void insert(int rating){
    long insertTotal = total + rating;
    count++;
    }
    
    public double getAverage(){
    return (double) (total/count);
    }
    
    public long getCount(){
    return count;
    }
    
    public long getTotal(){
    return total;
    }
}
