package net.revature.project1.robert.account;

import net.revature.project1.robert.connections.ConnectionFactory;
import net.revature.project1.robert.util.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO implements CRUD<Account> {
    public AccountDAO(){

    }

    @Override
    public Account create(Account newObject) {
        return null;
    }

    @Override
    public Account findById(String username) {
        try(Connection connect = ConnectionFactory.getConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM accounts WHERE username = ?";
            PreparedStatement prepStatement= connect.prepareStatement(sql);
            prepStatement.setString(1, username);
            ResultSet results = prepStatement.executeQuery();
            if(!results.next()){
                throw new SQLException("no result found");
            }
            return convertResultsToAccount(results);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Account updated) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
    private Account convertResultsToAccount(ResultSet result) throws SQLException{
        Account acc = new Account();
        acc.setUsername(result.getString("username"));
        acc.setPasscode(result.getString("passcode"));
        acc.setAccountType(result.getString("account_type"));
        acc.setAddress(result.getString("address"));
        acc.setFirstName(result.getString("first_name"));
        acc.setLastName(result.getString("last_name"));
        acc.setProfilePicture(result.getBytes("profile_picture"));
        return acc;
    }
}
