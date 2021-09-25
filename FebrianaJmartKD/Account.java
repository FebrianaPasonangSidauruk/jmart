package FebrianaJmartKD;


/**
 * class Account
 *
 * @author Febriana Pasonang Sidauruk
 * @version 25 September 2021
 */
public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    

}