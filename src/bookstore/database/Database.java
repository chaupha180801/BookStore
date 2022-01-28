/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.database;

/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import bookstore.database.tables.Account;
import java.sql.SQLException;


public class Database {
    static private String database_name;
    static private String username;
    static private String password;
    static private int port = 1521;
    static private String hostname = "localhost";
    static private Connection connection;
    static private boolean is_connected;
    static private String url;

    static public void initialize(String database_name, String username, String password){
       Database.database_name = database_name;
       Database.password = password;
       Database.username = username;
    }
    
    static public void initialize(
            String database_name,
            String username,
            String password,
            String hostname,
            int port
    ){
        Database.database_name = database_name;
        Database.hostname = hostname;
        Database.username = username;
        Database.password = password;
        Database.port = port;
    }
    
    public static void connect(){
        Database.url = "jdbc:oracle:thin:@"
                + Database.hostname 
                + ":"
                + Database.port
                + ":"
                + Database.database_name;
        Database.connection = null;
        
        try{ 
            Class.forName("oracle.jdbc.OracleDriver");
            Database.connection = DriverManager.getConnection(url, username, password);
            Database.is_connected = true;
        }
        catch (Exception e){
            e.printStackTrace();
            Database.is_connected = false;
        }
    }
   
    static public Connection connection() throws SQLException{
        //connection.setAutoCommit(true);
        return Database.connection;
    }
    
    static public boolean isConnected(){
        return Database.is_connected;
    }
}
