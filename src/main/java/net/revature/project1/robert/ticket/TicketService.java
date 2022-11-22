package net.revature.project1.robert.ticket;

import net.revature.project1.robert.util.CurrentUser;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    TicketDAO ticketDBAccess = new TicketDAO();
    public TicketService(){

    }
    public List<Ticket> listPendingTickets(){
        return ticketDBAccess.findPendingTickets();
    }
    public List<Ticket> listPreviousTickets(String user){
        return ticketDBAccess.findPreviousTickets(user);
    }
    public boolean addTicket(Ticket newTicket){
        if(newTicket.getAmount()==0){
            return false;
        }else if(newTicket.getTicketDescription()==null){
            return false;
        }
        newTicket.setSubmitterUser(CurrentUser.getUserName());
        if(ticketDBAccess.create(newTicket)!=null){
            return true;
        }else {
            return false;
        }
    }
    public boolean processTicket(Ticket processTicket){
        if(processTicket.getStatus().equalsIgnoreCase("approved")
                || processTicket.getStatus().equalsIgnoreCase("denied")) {
            return ticketDBAccess.update(processTicket);
        }
        else {
            return false;
        }
    }
}
