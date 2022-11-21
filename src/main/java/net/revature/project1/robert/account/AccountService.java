package net.revature.project1.robert.account;

import net.revature.project1.robert.util.CurrentUser;

public class AccountService {
    AccountDAO accountDBAccess = new AccountDAO();
    public AccountService(){

    }
    public boolean login(Account acc){ //TODO
        Account loginCheck = accountDBAccess.findById(acc.getUsername());
        return (loginCheck.getPasscode().equals(acc.getPasscode()));
    }
    public void register(Account acc){ //TODO
        Account check = accountDBAccess.findById(acc.getUsername());

    }
}
