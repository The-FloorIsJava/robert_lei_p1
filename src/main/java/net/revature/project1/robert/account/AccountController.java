package net.revature.project1.robert.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import net.revature.project1.robert.util.CurrentUser;

public class AccountController {

    AccountService accountServices = new AccountService();
    public AccountController(Javalin app){
        app.get("register", this::registerController);
        app.get("login", this::loginController);
        app.post("logout", this::logoutController);
    }

    private void registerController(Context context) throws JsonProcessingException{
        if(CurrentUser.isLoggedIn()){
            context.json("already logged in");
        }else {
            ObjectMapper mapper = new ObjectMapper();
            Account acc = mapper.readValue(context.body(), Account.class);
            boolean successful = accountServices.register(acc);
            if(successful){
                context.json("registered");
            }else{
                context.json("registration error");
            }
        }
    }

    private void loginController(Context context) throws JsonProcessingException {
        if(CurrentUser.isLoggedIn()){
            context.json("already logged in");
        }else {
            ObjectMapper mapper = new ObjectMapper();
            Account acc = mapper.readValue(context.body(), Account.class);
            boolean verified = accountServices.login(acc);
            if (verified) {
                context.json("logged in");
            } else {
                context.json("login failed");
            }
        }
    }
    private void logoutController(Context ctx){
        CurrentUser.logout();
        ctx.json("logged out");
    }

}
