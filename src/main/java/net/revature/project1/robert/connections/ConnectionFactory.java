package net.revature.project1.robert.connections;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    private Properties properties = new Properties();
    private ConnectionFactory(){
        try{
            properties.load(new FileReader("src/main/resources/db.properties"));
        }catch(IOException e){
            e.printStackTrace();
            //System.out.println(Paths.get("src/main/java/resources/db.properties").toAbsolutePath().normalize().toString());
        }
    }
    static{
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static ConnectionFactory getConnectionFactory(){
        return connectionFactory;
    }
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"), properties.getProperty("password"));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
