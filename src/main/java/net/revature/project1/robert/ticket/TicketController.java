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
        app.post("pending", this::viewPendingTicketController);
        app.post("previous", this::seePreviousTicketController);
        app.get("update/{ticketID}", this::processPendingTicket);
        app.get("submit", this::submitTicketController);
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
    private void processPendingTicket(Context context){
        if(!CurrentUser.isLoggedIn()){
            context.json("not logged in");
        } else if(CurrentUser.getUserType().equals("employee")){
            context.json("not enough permissions for this account type");
        } else {
            String ticketID = context.pathParam("ticketID");
            boolean updated = false;
            try{
                updated = ticketServices.processTicket(Integer.parseInt(ticketID));
            }catch(NumberFormatException e){
                context.json("Check the path");
                e.printStackTrace();
            }
            if(updated){
                context.json("ticket "+ticketID+ " processed");
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
