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
public class MoneyBill {
    private String id;
    private String customerId;
    private Date billDate;
    private int money;
    
    public MoneyBill(){}

    public MoneyBill(String id, String customerId, Date billDate, int money) {
        this.id = id;
        this.customerId = customerId;
        this.billDate = billDate;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public int getMoney() {
        return money;
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.phieuthutien";
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
    static public MoneyBill findById(String id) throws DatabasePermissonErrorException{
        try{
            String query = "SELECT * FROM qlnhasach.phieuthutien WHERE maphieuthu = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            String customerId = rs.getString(2);
            Date billDate = rs.getDate(3);
            int moneyBill = rs.getInt(4);
            return new MoneyBill(id, customerId, billDate, moneyBill);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<MoneyBill> findByCustomerId(String customerId, Boolean abs) throws DatabasePermissonErrorException{
        ArrayList<MoneyBill> bills = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.phieuthutien WHERE makh = ?";
            else
                query = "SELECT * FROM qlnhasach.phieuthutien WHERE upper(makh) like upper(?)";

            PreparedStatement st = Database.connection().prepareStatement(query);

            if (abs)
                st.setString(1, customerId);
            else
                st.setString(1, "%" + customerId + "%");

            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(2);
                String _customerId = rs.getString(1);
                Date billDate = rs.getDate(3);
                int moneyBill = rs.getInt(4);

                bills.add(new MoneyBill(id, _customerId, billDate, moneyBill));
            }
            
            return bills;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return bills;
        }
    }
    static public ArrayList<MoneyBill> selectAll() throws DatabasePermissonErrorException{
        ArrayList<MoneyBill> bills = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.phieuthutien order by Maphieuthu ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String customerId = rs.getString(2);
                Date billDate = rs.getDate(3);
                int moneyBill = rs.getInt(4);

                bills.add(new MoneyBill(id, customerId, billDate, moneyBill));
            }
            
            return bills;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return bills;
        }
    }
    
    static public boolean insert(MoneyBill bill) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.phieuthutien(makh, ngaythutien, sotienthu)"
                            + " VALUES (?, TO_DATE(?,'YYYY/MM/DD'), ?)";
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, bill.getCustomerId());
            ps.setString(2, bill.getBillDate().toString());
            ps.setInt(3, bill.getMoney());
      
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        } 
    }
    
    static public boolean delete(MoneyBill bill) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.phieuthutien WHERE maphieuthu = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1,bill.getId());           
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-02292")) {
                JOptionPane.showMessageDialog(null,
                        "Nhân viên hiện đang làm việc tại cửa hàng , KHÔNG được xóa!!!",
                        "Enror", 
                        JOptionPane.WARNING_MESSAGE);
            }
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
            }
   
    }
    static public boolean update(MoneyBill bill) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.phieuthutien SET "
                        + "ngaythutien = TO_DATE(?,'YYYY/MM/DD'), sotienthu = ?"
                        +" WHERE maphieuthu =? and makh = ?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                
                ps.setString(1, bill.getBillDate().toString());
                ps.setInt(2, bill.getMoney()); 
                ps.setString(3, bill.getId());
                ps.setString(4, bill.getCustomerId());
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                
                if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }
    
    
}
