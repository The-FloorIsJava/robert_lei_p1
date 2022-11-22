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
    String submitterUser;

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

    public void setSupportingImage(byte[] supportingImage) {
        //TODO convert byte array to file
    }

    public String getSubmitterUser() {
        return submitterUser;
    }

    public void setSubmitterUser(String submitterUser) {
        this.submitterUser = submitterUser;
    }

    public Ticket(){

    }
    public Ticket(int ticketId, String ticketDescription,double amount, String submitter){
        this.ticketId=ticketId;
        this.ticketDescription=ticketDescription;
        this.amount=amount;
        this.submitterUser = submitter;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", ticketName='" + ticketName + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", ticketDescription='" + ticketDescription + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", supportingImage=" + supportingImage +
                ", submitterUser='" + submitterUser + '\'' +
                '}';
    }
}
