package net.revature.project1.robert.ticket;

import io.javalin.Javalin;
import io.javalin.http.Context;
import net.revature.project1.robert.util.CurrentUser;
public class TicketController {
    CurrentUser currentUser = new CurrentUser();
    public TicketController(Javalin app){
        app.post("pending", this::viewPendingTicketController);
        app.post("previous", this::seePreviousTicketController);
    }
    public void viewPendingTicketController(Context context){

    }
    public void seePreviousTicketController(Context context){

    }
}
