package net.revature.project1.robert.ticket;

import java.util.List;

public class TicketService {
    TicketDAO ticketDBAccess = new TicketDAO();
    public TicketService(){

    }
    public List<Ticket> listPendingTickets(){

        return null;
    }
    public List<Ticket> listPreviousTickets(String user){

        return null;
    }
    public boolean addTicket(Ticket newTicket){

        return false;
    }
    public boolean processTicket(int ticketID){

        return false;
    }
}
