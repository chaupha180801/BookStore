/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.database.tables;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.util.Date;
import bookstore.database.Database;
import bookstore.exceptions.DatabasePermissonErrorException;
import javax.swing.JOptionPane;

public class Customer {
    private String id;
    private String name;
    private int typeOfCustomer;
    private String address;
    private String phoneNumber;
    private int debt;
    
    public Customer(){}

    public Customer(String id, String name, int typeOfCustomer, String address, String phoneNumber, int debt) {
        this.id = id;
        this.name = name;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.debt = debt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getDebt() {
        return debt;
    }
    
    @Override
    public String toString() {
        return "MAKH: " + this.id +
                "--" + "TENKH: " + this.name + "--" + "TIEN NO: "  +this.debt; 
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.khachhang";
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
    
    static public Customer findById(String id) throws DatabasePermissonErrorException{
        try{
            String query = "SELECT * FROM qlnhasach.khachhang WHERE makh = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            String name = rs.getString(2);
            int typeOfCustomer = rs.getInt(3);
            String address = rs.getString(4);
            String phoneNumber = rs.getString(5);
            int debt = rs.getInt(6);
            
            return new Customer(id, name, typeOfCustomer, address, phoneNumber, debt);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<Customer> findByName(String name, Boolean abs) throws DatabasePermissonErrorException{
        ArrayList<Customer> customers = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.khachhang WHERE tenkh = ?";
            else
                query = "SELECT * FROM qlnhasach.khachhang WHERE upper(tenkh) LIKE upper(?)";

            PreparedStatement st = Database.connection().prepareStatement(query);

            if (abs)
                st.setString(1, name);
            else
                st.setString(1, "%" + name + "%");

            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                int typeOfCustomer = rs.getInt(3);
                String address = rs.getString(4);
                String phoneNumber = rs.getString(5);
                int debt = rs.getInt(6);

                customers.add(new Customer(id, _name, typeOfCustomer, address, phoneNumber, debt));
            }
            
            return customers;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return customers;
        }
    }
    
    static public ArrayList<Customer> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Customer> customers = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.khachhang order by MaKH ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int typeOfCustomer = rs.getInt(3);
                String address = rs.getString(4);
                String phoneNumber = rs.getString(5);
                int debt = rs.getInt(6);

                customers.add(new Customer(id, name, typeOfCustomer, address, phoneNumber, debt));
            }         
            return customers;
        }catch(Exception ex){
           if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return customers;
        }
    }
    static public boolean insert(Customer customer) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.khachhang(tenkh, loaikh, diachi, sdt, tongno)"
                            + " VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getTypeOfCustomer());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getPhoneNumber());
            ps.setInt(5, customer.getDebt());
            
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-02290: check constraint (QLNHASACH.CHECK_LOAIKH) violated"))
                JOptionPane.showMessageDialog(null,
                        "Loại khách hàng chỉ có thể là 0, 1, 2",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
                    
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
                return false;
        }
 
    }
    static public boolean delete(Customer customer) throws DatabasePermissonErrorException{
       
        try{
            CallableStatement cstmt = Database.connection().prepareCall("{call qlnhasach.xoa_kh(?)}");
            cstmt.setString(1, customer.getId());           
            cstmt.execute();
            cstmt.close();                     
            return true;
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-20000"))
                JOptionPane.showMessageDialog(null,
                        "Chỉ xóa khách hàng khi tổng nợ bằng không.",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    static public boolean update(Customer customer) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.khachhang SET tenkh = ? ,"
                        + " loaikh = ?,  diachi = ?,"
                        + "sdt = ?, tongno = ?"
                        +" WHERE makh =?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, customer.getName());
                ps.setInt(2, customer.getTypeOfCustomer());
                ps.setString(3, customer.getAddress());
                ps.setString(4, customer.getPhoneNumber());
                ps.setInt(5, customer.getDebt());
                ps.setString(6, customer.getId());
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                if(ex.getMessage().contains("ORA-02290: check constraint (QLNHASACH.CHECK_LOAIKH) violated"))
                JOptionPane.showMessageDialog(null,
                        "Loại khách hàng chỉ có thể là 0, 1, 2",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
                if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }
    static public int countCustomer() throws DatabasePermissonErrorException{
        try{
            int value = 0;
            String query = "SELECT count(*) FROM qlnhasach.khachhang";
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
    
    static public int totalDebt() throws DatabasePermissonErrorException{
        try{
            int value = 0;
            String query = "SELECT sum(tongno) FROM qlnhasach.khachhang";
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
