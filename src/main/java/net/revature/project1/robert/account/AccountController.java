package net.revature.project1.robert.account;

import io.javalin.Javalin;
import io.javalin.http.Context;

import javax.xml.crypto.Data;

public class AccountController {

    public AccountController(Javalin app){
        app.get("register", this::registerController);
        app.get("login", this::loginController);
    }

    private void registerController(Context context) {
    }

    private void loginController(Context context){

    }

}
