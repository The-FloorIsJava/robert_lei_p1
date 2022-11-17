package net.revature.project1.robert.ticket;

import net.revature.project1.robert.account.Account;

import java.io.File;

public class Ticket {
    int ticketId;
    String ticketName;
    String ticketType;
    String ticketDescription;
    double amount;
    String status;
    File supportingImage;
    Account submitterUser;

    public Ticket(){

    }
    public Ticket(int ticketId, String ticketDescription,double amount, Account submitter){
        this.ticketId=ticketId;
        this.ticketDescription=ticketDescription;
        this.amount=amount;
        this.submitterUser = submitter;
    }
}
