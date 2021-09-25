package FebrianaJmartKD;


/**
 * class Product
 *
 * @author Febriana Pasonang Sidauruk
 * @version 18 September 2021
 */
public class Product extends Recognizable
{
    private static int idCounter = 0;
    public int storeId;
    public Store store;
    public int id = 0;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
    super(id);
    this.storeId = storeId;
    this.name = name;
    this.weight = weight;
    this.conditionUsed = conditionUsed;
    this.priceTag = priceTag;
    this.category = category;
    this.rating = new ProductRating();
    id = idCounter++;
    }
    
    public Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category){
    super(id);
    this.name = name;
    this.weight = weight;
    this.conditionUsed = conditionUsed;
    this.priceTag = priceTag;
    this.category = category;
    this.rating = rating;
    this.store = store;
    }
}
