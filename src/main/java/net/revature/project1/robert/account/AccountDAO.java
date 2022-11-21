package net.revature.project1.robert.account;

import net.revature.project1.robert.util.CRUD;

public class AccountDAO implements CRUD<Account> {
    public AccountDAO(){

    }

    @Override
    public Account create(Account newObject) {
        return null;
    }

    @Override
    public Account findById(String username) {
        return null;
    }

    @Override
    public boolean update(Account updated) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
