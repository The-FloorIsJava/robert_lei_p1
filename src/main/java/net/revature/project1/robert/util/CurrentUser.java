package net.revature.project1.robert.util;

import net.revature.project1.robert.account.Account;

import java.util.Objects;

public class CurrentUser {
    static Account account = null;
    public CurrentUser(){

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
    public boolean isLoggedIn(){
        return (!Objects.isNull(account)); //if exists, returns true
    }
}
