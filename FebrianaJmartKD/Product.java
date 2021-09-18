package FebrianaJmartKD;


/**
 * class Product
 *
 * @author Febriana Pasonang Sidauruk
 * @version 18 September 2021
 */
public class Product
{
    private static int idCounter = 0;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
    this.name = name;
    this.weight = weight;
    this.conditionUsed = conditionUsed;
    this.priceTag = priceTag;
    this.category = category;
    this.rating = new ProductRating();
    idCounter++;
    id = idCounter;
    }
}
