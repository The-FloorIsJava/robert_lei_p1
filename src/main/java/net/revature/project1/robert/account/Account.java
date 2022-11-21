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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getPasscode() {
        return passcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public File getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {//conversion from byte array to file tbd
        this.profilePicture = null;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
