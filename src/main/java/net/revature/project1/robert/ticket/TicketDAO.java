package net.revature.project1.robert.ticket;

import net.revature.project1.robert.util.CRUD;

import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements CRUD<Ticket> {

    @Override
    public Ticket create(Ticket newObject) {
        return null;
    }

    @Override
    public Ticket findById(String username) {
        return null;
    }
    public List<Ticket> findPendingTickets(){
        List<Ticket> pending = new ArrayList<Ticket>();
        return pending;
    }
    public List<Ticket> findPreviousTickets(String username){
        List<Ticket> previous = new ArrayList<Ticket>();
        return previous;
    }

    @Override
    public boolean update(Ticket updated) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
