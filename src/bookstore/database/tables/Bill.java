/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.database.tables;

import java.sql.*;
import java.util.*;
import java.util.Date;
import bookstore.database.Database;
import bookstore.exceptions.BillException;
import bookstore.exceptions.DatabasePermissonErrorException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class Bill {
    private String id;
    private Date date;
    private int totalPrice;
    private int paid;
    private String employeeId;
    private String customerId;
    private String discountId;
    private int finalPrice;
    
    public Bill(){}
    
    
    public Bill(
            String id,
            Date date,
            int totalPrice,
            int paid,
            String employeeId,
            String customerId,
            String discountId,
            int finalPrice
    ){
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.paid = paid;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.discountId = discountId;
        this.finalPrice = finalPrice;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getPaid() {
        return paid;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDiscountId() {
        return discountId;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.hoadon";
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
      
    static public Bill findById(String id) throws DatabasePermissonErrorException{
        try{
            String query = """
                           SELECT mahd, ngayhd, tonghd, sotienthuctra, manv, makh, makm, thanhtien 
                           FROM qlnhasach.hoadon 
                           WHERE mahd = ?
                           """;
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            Date date = rs.getDate(2);
            int totalPrice = rs.getInt(3);
            int paid = rs.getInt(4);
            String employeeId = rs.getString(5);
            String customerId = rs.getString(6);
            String discountId = rs.getString(7);
            int finalPrice = rs.getInt(8);
        
            return new Bill(id, date, totalPrice, paid, employeeId, customerId, discountId, finalPrice);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
    static public ArrayList<Bill> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Bill> bills = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.hoadon order by Mahd ASC";

            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                Date date = rs.getDate(2);
                int totalPrice = rs.getInt(3);
                int paid = rs.getInt(4);
                String employeeId = rs.getString(5);
                String customerId = rs.getString(6);
                String discountId = rs.getString(7);
                int finalPrice = rs.getInt(8);

                bills.add(new Bill(id, date, totalPrice, paid, employeeId, customerId, discountId, finalPrice));
            }

            return bills;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return bills;
        }
    }
    
    static public Bill insert(String employeeId, String customerId, String discountId, Date date) 
            throws DatabasePermissonErrorException,
            BillException
            {
        try{
            CallableStatement cstmt = Database.connection().prepareCall(
                    "{? = call qlnhasach.them_hd(?, ?, ?, ?)}"
            );
            cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
            cstmt.setString(2, employeeId);
            cstmt.setString(3, customerId);
            cstmt.setString(4, discountId);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            cstmt.setDate(5, sqlDate);
            
            cstmt.execute();
            
            String billId = cstmt.getString(1);
            
            cstmt.close();             

            return Bill.findById(billId);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            if (ex.getMessage().contains("ORA-20001"))
                throw new BillException("Tiền nợ lớn hơn 200,000đ");
            
            System.out.println(ex.getMessage());
            return null;
        } 
    }
    
    static public boolean delete(String id) throws DatabasePermissonErrorException{
       
        try{
            CallableStatement cstmt = Database.connection().prepareCall("{call qlnhasach.xoa_hd(?)}");
            cstmt.setString(1, id);
            
            cstmt.execute();
            cstmt.close();

            return true;
        }
        catch (SQLException ex) {           
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
            }
    }
    
    static public Bill update(Bill bill) throws DatabasePermissonErrorException, BillException{
        try {
            String query = 
                """
                UPDATE qlnhasach.hoadon 
                SET makh = ?, makm = ?, sotienthuctra = ?
                WHERE mahd =?
                """;
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, bill.getCustomerId());
            ps.setString(2, bill.getDiscountId());     
            ps.setInt(3, bill.getPaid());
            ps.setString(4, bill.getId());
            if (ps.executeUpdate() > 0)
                return Bill.findById(bill.getId());

            return null;
        } catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-20005"))
                throw new BillException("Số tiền thực trả chỉ áp dụng cho khách hàng thân quen."
                        + "Vui lòng trả đúng số tiền đã mua sách.");
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    } 
    
    static public int totalPrice() throws DatabasePermissonErrorException{//bo
        try{
            int value = 0;
            String query = "SELECT sum(thanhtien) "
                         + "FROM qlnhasach.hoadon "
                         + "";
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
    
    static public ArrayList<Bill> selectBills(Date date) throws DatabasePermissonErrorException{//bỏ
        ArrayList<Bill> bills = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.hoadon "
                         + "WHERE trunc(qlnhasach.hoadon.ngayhd) = ? "
                         + "ORDER BY Mahd ASC";
            
            Connection conn = Database.connection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            //conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            PreparedStatement st = conn.prepareStatement(query);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            st.setDate(1,sqlDate);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                Date _date = rs.getDate(2);
                int totalPrice = rs.getInt(3);
                int paid = rs.getInt(4);
                String employeeId = rs.getString(5);
                String customerId = rs.getString(6);
                String discountId = rs.getString(7);
                int finalPrice = rs.getInt(8);

                bills.add(new Bill(id, _date, totalPrice, 
                                    paid, employeeId, customerId,
                                    discountId, finalPrice));
            }
            
            return bills;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return bills;
        }
    }
    
    static public int sumFinalPrice(Date date) throws DatabasePermissonErrorException{//bỏ
        try{
            int value = 0;
            String query = "SELECT sum(thanhtien) "
                         + "FROM qlnhasach.hoadon "
                         + "WHERE trunc(qlnhasach.hoadon.ngayhd) = ? ";
                    
            PreparedStatement st = Database.connection().prepareStatement(query);

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            st.setDate(1,sqlDate);
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
    
    static public int sumTotalPrice(Date date) throws DatabasePermissonErrorException{//bỏ
        try{
            int value = 0;
            String query = "SELECT count(*) "
                         + "FROM qlnhasach.hoadon "
                         + "WHERE trunc(qlnhasach.hoadon.ngayhd) = ? ";
                    
            PreparedStatement st = Database.connection().prepareStatement(query);

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            st.setDate(1,sqlDate);
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
    
     static public int countBill(Date date) throws DatabasePermissonErrorException{//bỏ
        try{
            int value = 0;
            String query = "SELECT count(*) "
                         + "FROM qlnhasach.hoadon "
                         + "WHERE trunc(qlnhasach.hoadon.ngayhd) = ? ";
                    
            PreparedStatement st = Database.connection().prepareStatement(query);

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            st.setDate(1,sqlDate);
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
