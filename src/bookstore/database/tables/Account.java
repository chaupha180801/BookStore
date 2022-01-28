/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.database.tables;

import bookstore.database.Database;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class Account {
    final static public String SALE_STAFF_ROLE = "salestaff";
    final static public String STOCK_STAFF_ROLE = "stockstaff";
    final static public String MANAGER_ROLE = "manager";
    
    final static public String ADMIN_USERNAME = "qlnhasach";
    final static public String ADMIN_PASSWORD = "qlns";
    
    final static public String SALE_STAFF_USERNAME = "bookstore_sale_staff";
    final static public String STOCK_STAFF_USERNAME = "bookstore_stock_staff";
    final static public String MANAGER_USERNAME = "bookstore_manager";
    
    final static public String SALE_STAFF_PASWORD = "qlns"; 
    final static public String STOCK_STAFF_PASWORD = "qlns";
    final static public String MANAGER_PASWORD = "qlns";
    
    private String username;
    private String role;
    private String employeeId;
    
    private Account(String username, String role, String employeeId){
        this.username = username;
        this.role = role;
        this.employeeId = employeeId;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public String getUsername(){
        return this.username;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    
    
    static public Account authenticate(String username, String password){
        try{
            String query = "SELECT role, manv FROM taikhoan WHERE username = ? and password = ? ";
            PreparedStatement ps = Database.connection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String role = rs.getString(1);
                String employeeId = rs.getString(2);
                return new Account(username, role, employeeId);
            }
            else 
                return null;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public void globalAuthenticate(String username, String password){
        try{
            String query = "SELECT username, role FROM taikhoan WHERE username = ? and password = ? ";
            PreparedStatement ps = Database.connection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String role = rs.getString(2);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public String getUsernameOfRole(){
        if (this.role.equals(Account.SALE_STAFF_ROLE))
            return Account.SALE_STAFF_USERNAME;
        else if (this.role.equals(Account.STOCK_STAFF_ROLE))
            return Account.STOCK_STAFF_USERNAME;
        else if (this.role.equals(Account.MANAGER_ROLE))
            return Account.MANAGER_USERNAME;
        else
            return null;
    }
    
    public String getPasswordOfRole(){
        if (this.role.equals(Account.SALE_STAFF_ROLE))
            return Account.SALE_STAFF_PASWORD;
        else if (this.role.equals(Account.STOCK_STAFF_ROLE))
            return Account.STOCK_STAFF_PASWORD;
        else if (this.role.equals(Account.MANAGER_ROLE))
            return Account.MANAGER_PASWORD;
        else
            return null;
    }
  
    
}
