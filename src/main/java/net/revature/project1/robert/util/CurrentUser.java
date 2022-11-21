package net.revature.project1.robert.util;

import net.revature.project1.robert.account.Account;

public class CurrentUser {
    static Account account;
    public CurrentUser(){
        account = null;
    }
    public void login(Account account){
        this.account = account;
    }
    public String getUserType(){
        return account.getAccountType();
    }
    public String getUserName(){
        return account.getUsername();
    }
    public void logout(){
        account = null;
    }
}
