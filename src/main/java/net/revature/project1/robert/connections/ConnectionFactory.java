package net.revature.project1.robert.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionFactory(){

    }
    public ConnectionFactory getConnectionFactory(){
        return connectionFactory;
    }
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
