package net.revature.project1.robert.application;

import io.javalin.Javalin;
import net.revature.project1.robert.connections.ConnectionFactory;
public class ApplicationEntry{
    public static void main(String[] args){
        Javalin app = Javalin.create().start(8008);
    }
}