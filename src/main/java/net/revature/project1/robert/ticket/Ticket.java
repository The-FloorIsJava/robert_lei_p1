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

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public File getSupportingImage() {
        return supportingImage;
    }

    public void setSupportingImage(File supportingImage) {
        this.supportingImage = supportingImage;
    }

    public Account getSubmitterUser() {
        return submitterUser;
    }

    public void setSubmitterUser(Account submitterUser) {
        this.submitterUser = submitterUser;
    }

    public Ticket(){

    }
    public Ticket(int ticketId, String ticketDescription,double amount, Account submitter){
        this.ticketId=ticketId;
        this.ticketDescription=ticketDescription;
        this.amount=amount;
        this.submitterUser = submitter;
    }
}
