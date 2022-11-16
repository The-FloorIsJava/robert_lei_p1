package net.revature.project1.robert.account;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class AccountController {
    String currentUser;
    String userType;
    public AccountController(){

    }
    public void setup(Javalin app){
        currentUser = null;
        userType = null;
        app.get("login", this::login);
    }

    private void login(Context context){
        String username = context.pathParam("username");
    }

}
