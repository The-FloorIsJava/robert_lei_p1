package net.revature.project1.robert.ticket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import net.revature.project1.robert.util.CurrentUser;

import java.util.List;

public class TicketController {
    TicketService ticketServices = new TicketService();
    public TicketController(Javalin app){
        app.get("pending", this::viewPendingTicketController);
        app.get("previous", this::seePreviousTicketController);
        app.post("update", this::processPendingTicket);
        app.post("submit", this::submitTicketController);
    }
    private void viewPendingTicketController(Context context){
        if(!CurrentUser.isLoggedIn()){
            context.json("not logged in");
        } else if(CurrentUser.getUserType().equals("employee")){
            context.json("not enough permissions as your account type");
        } else {
            List<Ticket> pendingTickets = ticketServices.listPendingTickets();
            context.json(pendingTickets);
        }
    }
    private void seePreviousTicketController(Context context){
        if(!CurrentUser.isLoggedIn()){
            context.json("not logged in");
        } else if(CurrentUser.getUserType().equals("manager")){
            context.json("no previous ticket viewing for this account type");
        } else {
            List<Ticket> previousTickets = ticketServices.listPreviousTickets(CurrentUser.getUserName());
            context.json(previousTickets);
        }
    }
    private void processPendingTicket(Context context) throws JsonProcessingException{
        if(!CurrentUser.isLoggedIn()){
            context.json("not logged in");
        } else if(CurrentUser.getUserType().equals("employee")){
            context.json("not enough permissions for this account type");
        } else {
            boolean updated = false;
            ObjectMapper mapper = new ObjectMapper();
            Ticket processing = mapper.readValue(context.body(),Ticket.class);
            updated = ticketServices.processTicket(processing);
            if(updated){
                context.json("ticket "+processing.getTicketId()+" processed");
            }else{
                context.json("ticket failed to process");
            }
        }
    }
    private void submitTicketController(Context context) throws JsonProcessingException {
        if(!CurrentUser.isLoggedIn()){
            context.json("not logged in");
        }else if(CurrentUser.getUserType().equals("manager")){
            context.json("no ticket sending for this account type");
        }else {
            ObjectMapper mapper = new ObjectMapper();
            Ticket newTicket = mapper.readValue(context.body(), Ticket.class);
            boolean ticketResponse = ticketServices.addTicket(newTicket);
            if(ticketResponse){
                context.json("ticket inserted");
            }else{
                context.json("ticket failed to submit");
            }
        }
    }
}
