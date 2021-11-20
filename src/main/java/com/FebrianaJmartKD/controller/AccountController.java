package com.FebrianaJmartKD.controller;

import com.FebrianaJmartKD.Account;
import com.FebrianaJmartKD.Store;
import com.FebrianaJmartKD.dbjson.JsonTable;
import com.FebrianaJmartKD.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public abstract class AccountController implements BasicGetController<Account>{
    public static @JsonAutowired(value=Account.class, filepath="src/main") JsonTable<Account> accountTable;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&~]+(?:\\.[a-zA-Z0-9&~]+)@[A-Za-z0-9]{1}[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)$";
    public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }
    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        for(Account account : accountTable){
            if(account.email.equals(email) && account.password.equals(password)){
                return account;
            }
        }
        return null;
    }

    @PostMapping("/register")
    Account register
            (         String name, String email, String password
//                    @RequestParam String name,
//                    @RequestParam String email,
//                    @RequestParam String password
            )
    {
        if((REGEX_PATTERN_EMAIL.matcher(email).find()) && (REGEX_PATTERN_PASSWORD.matcher(password).find()) && !name.isBlank()){
            for(Account account : accountTable){
                if(account.email.equals(email)){
                    return null;
                }
            }
            return new Account(name, email, password, 0);
        }
        return null;
    }

    @PostMapping("/{id}/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber){
        if(accountTable.contains(accountTable.get(id)) && accountTable.get(id).store == null){
            Store newStore = new Store(name, address, phoneNumber, 0);
            accountTable.get(id).store = newStore;
            return newStore;
        }else{
            return null;
        }
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(int id, double balance){
        if(accountTable.contains(accountTable.get(id))){
            accountTable.get(id).balance += balance;
            return true;
        }else{
            return false;
        }

    }

	/*@GetMapping("/{id}")
	String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
	*/
}
