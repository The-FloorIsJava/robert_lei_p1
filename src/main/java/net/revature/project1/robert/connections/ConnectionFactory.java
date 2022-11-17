package net.revature.project1.robert.connections;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    private Properties properties = new Properties();
    private ConnectionFactory(){
        try{
            properties.load(new FileReader("src/main/java/resources/db.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    static{
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
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
