package net.revature.project1.robert.application;

import io.javalin.Javalin;
import net.revature.project1.robert.account.AccountController;
import net.revature.project1.robert.connections.ConnectionFactory;

import java.sql.Connection;

public class ApplicationEntry{
    public static void main(String[] args){
        //Connection connect = ConnectionFactory.getConnectionFactory().getConnection();
        Javalin app = Javalin.create().start(8008);
        AccountController accountController = new AccountController(app);
    }
}