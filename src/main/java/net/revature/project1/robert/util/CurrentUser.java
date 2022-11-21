package net.revature.project1.robert.util;

import net.revature.project1.robert.account.Account;

import java.util.Objects;

public class CurrentUser {
    static Account account = null;
    public CurrentUser(){

    }
    public static void login(Account acc){
        account = acc;
    }
    public static String getUserType(){
        return account.getAccountType();
    }
    public static String getUserName(){
        return account.getUsername();
    }
    public static void logout(){
        account = null;
    }
    public static boolean isLoggedIn(){
        return (!Objects.isNull(account)); //if exists, returns true
    }
}
