/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.database.tables;


import java.sql.*;
import java.util.*;
import java.util.logging.*;
import bookstore.database.Database;
import javax.swing.JOptionPane;
import bookstore.exceptions.DatabasePermissonErrorException;

public class Publisher {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    
    public Publisher(){}

    public Publisher(String id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    @Override
    public String toString() {
        return this.id + " - " + this.name; 
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.nhaxuatban";
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.executeUpdate();
            conn.rollback();
            conn.setAutoCommit(true);
            return true;
        }
        catch (SQLException ex) { 
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex1) {
               System.out.println(ex1.getMessage());
            }
            if(ex.getMessage().contains("ORA-00942")
                || ex.getMessage().contains("ORA-01031")
                || ex.getMessage().contains("ORA-00903")
            )
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    static public Publisher findById(String id) throws DatabasePermissonErrorException{
        try{
            String query = "SELECT * FROM qlnhasach.nhaxuatban WHERE manxb = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            String name = rs.getString(2);
            String address = rs.getString(3);
            String phoneNumber = rs.getString(4);
            
            return new Publisher(id, name, address, phoneNumber);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<Publisher> findByName(String name, Boolean abs) throws DatabasePermissonErrorException{
        ArrayList<Publisher> publishs = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.nhaxuatban WHERE tennxb = ?";
            else
                query = "SELECT * FROM qlnhasach.nhaxuatban WHERE upper(tennxb) LIKE upper(?)";

            PreparedStatement st = Database.connection().prepareStatement(query);

            if (abs)
                st.setString(1, name);
            else
                st.setString(1, "%" + name + "%");

            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                String address = rs.getString(3);
                String phoneNumber = rs.getString(4);

                publishs.add(new Publisher(id, _name, address, phoneNumber));
            }
            
            return publishs;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return publishs;
        }
    }
    
    static public ArrayList<Publisher> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Publisher> publishs = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.nhaxuatban order by MaNXB ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                String address = rs.getString(3);
                String phoneNumber = rs.getString(4);
                
                publishs.add(new Publisher(id, _name, address, phoneNumber));
            }
            
            return publishs;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return publishs;
        }
    }
    
    static public boolean insert(Publisher publish) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.nhaxuatban(tennxb,diachi,sdt)"
                            + " VALUES (?,?,?)";
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, publish.getName());
            ps.setString(2, publish.getAddress());
            ps.setString(3, publish.getPhoneNumber());
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
    }
    static public boolean delete(Publisher publish) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.nhaxuatban WHERE manxb = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1,publish.getId());           
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-02292")) {
                JOptionPane.showMessageDialog(null, 
                        "Sách của nhà xuất bản hiện có tại cửa hàng , KHÔNG được xóa!!!",
                        "Enror", 
                        JOptionPane.WARNING_MESSAGE);
            }
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
   
    }
    static public boolean update(Publisher publish) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.nhaxuatban SET tennxb = ?,"
                        + "diachi = ?,"
                        + "sdt = ? "
                        +" WHERE manxb =?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, publish.getName()); 
                ps.setString(2, publish.getAddress());
                ps.setString(3, publish.getPhoneNumber());
                ps.setString(4, publish.getId());    
                return (ps.executeUpdate()>0);
                
        } catch (SQLException ex) {
                if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
        }
    }
    
    static public int countPublisher() throws DatabasePermissonErrorException{
        try{
            int value = 0;
            String query = "SELECT count(*) FROM qlnhasach.nhaxuatban";
            PreparedStatement st = Database.connection().prepareStatement(query);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                value = rs.getInt(1);
            }
            return value;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
