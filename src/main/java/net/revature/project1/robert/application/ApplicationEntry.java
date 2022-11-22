package net.revature.project1.robert.application;

import io.javalin.Javalin;
import net.revature.project1.robert.account.AccountController;
import net.revature.project1.robert.connections.ConnectionFactory;
import net.revature.project1.robert.ticket.TicketController;

import java.sql.Connection;

public class ApplicationEntry{
    public static void main(String[] args){
        //Connection connect = ConnectionFactory.getConnectionFactory().getConnection();
        Javalin app = Javalin.create().start(8008);
        AccountController accountController = new AccountController(app);
        TicketController ticketController = new TicketController(app);
    }
}