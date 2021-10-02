package FebrianaJmartKD;


/**
 * class Store
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber){
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber){
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "address: " + this.address + "\n" +
            "phoneNumber: " + this.phoneNumber + "\n"
        );
    }
}
