package net.revature.project1.robert.account;

import net.revature.project1.robert.util.CurrentUser;

public class AccountService {
    AccountDAO accountDBAccess = new AccountDAO();
    public AccountService(){

    }
    public boolean login(Account acc){ //TODO
        Account loginCheck = accountDBAccess.findById(acc.getUsername());
        if(loginCheck==null){
            return false;
        }
        boolean userPass = (loginCheck.getPasscode().equals(acc.getPasscode()));
        if(userPass){
            CurrentUser.login(loginCheck);
        }
        return userPass;
    }
    public boolean register(Account acc){ //TODO
        Account check = accountDBAccess.findById(acc.getUsername());
        if(check != null){
            if(check.getUsername().equals(acc.getUsername())){
                return false;
            }
        }
        if(acc.getPasscode()==null){
            return false;
        }
        if(acc.getAccountType()==null){
            acc.setAccountType("employee");
        }
        accountDBAccess.create(acc);
        return true;
    }
}
