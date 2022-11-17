package net.revature.project1.robert.account;

import java.io.File;

public class Account {
    String username;
    String passcode;
    String firstName;
    String lastName;
    String address;
    File profilePicture;
    String accountType;
    public Account(){
    }
    public Account(String user, String pass){
        username = user;
        passcode = pass;
        accountType = "employee";
    }
    public Account(String user, String pass, String type){
        username = user;
        passcode = pass;
        accountType = type;
    }
}
