/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.database.tables;

import bookstore.exceptions.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import bookstore.database.Database;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Date;
public class Discount {
    private String id;
    private String name;
    private Date startDate;
    private Date finishDate;
    private String describe;
    private float discountRate;
    
    public Discount(){}

    public Discount(String id, String name, Date startDate, Date finishDate, String describe, float discountRate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.describe = describe;
        this.discountRate = discountRate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public String getDescribe() {
        return describe;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    @Override
    public String toString() {
        return this.getName()+ " - " + this.getDiscountRate() * 100 + "%";
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.khuyenmai";
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
    static public Discount findById(String id) throws DatabasePermissonErrorException {
        try{
            String query = "SELECT * FROM qlnhasach.khuyenmai WHERE makm = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            String name = rs.getString(2);
            Date startdate = rs.getDate(3);
            Date finishdate = rs.getDate(4);
            String describe = rs.getString(5);
            float discountRate = rs.getFloat(6);
            
            return new Discount(id, name, startdate, finishdate, describe, discountRate);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<Discount> findByName(String name, Boolean abs) 
    throws DatabasePermissonErrorException{
        ArrayList<Discount> discounts = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.khuyenmai WHERE tenkm = ?";
            else
                query = "SELECT * FROM qlnhasach.khuyenmai WHERE upper(tenkm) LIKE upper(?)";

            PreparedStatement st = Database.connection().prepareStatement(query);

            if (abs)
                st.setString(1, name);
            else
                st.setString(1, "%" + name + "%");

            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                Date startdate = rs.getDate(3);
                Date finishdate = rs.getDate(4);
                String describe = rs.getString(5);
                float discountRate = rs.getFloat(6);

                discounts.add(new Discount(id, _name, startdate, finishdate, describe, discountRate));
            }
            
            return discounts;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return discounts;
        }
    }
    
    static public ArrayList<Discount> selectAllToday() throws DatabasePermissonErrorException{
        ArrayList<Discount> discounts = new ArrayList<>();
        
        try{
            String query = """
                           SELECT * 
                           FROM qlnhasach.khuyenmai
                           WHERE ngaybd <= SYSDATE and SYSDATE <= ngaykt
                           order by MaKM ASC
                           """;
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                Date startdate = rs.getDate(3);
                Date finishdate = rs.getDate(4);
                String describe = rs.getString(5);
                float discountRate = rs.getFloat(6);

                discounts.add(new Discount(id, _name, startdate, finishdate, describe, discountRate));
            }
            
            return discounts;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return discounts;
        }
    }
    
    static public ArrayList<Discount> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Discount> discounts = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.khuyenmai order by MaKM ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                Date startdate = rs.getDate(3);
                Date finishdate = rs.getDate(4);
                String describe = rs.getString(5);
                float discountRate = rs.getFloat(6);

                discounts.add(new Discount(id, _name, startdate, finishdate, describe, discountRate));
            }
            
            return discounts;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return discounts;
        }
    }
    
    static public boolean insert(Discount discount) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.khuyenmai(tenkm, ngaybd, ngaykt, mota, tilekm)"
                            + " VALUES (?, TO_DATE(?,'YYYY/MM/DD'), TO_DATE(?,'YYYY/MM/DD'), ?, ?)";
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, discount.getName());
            ps.setString(2, discount.getStartDate().toString());
            ps.setString(3, discount.getFinishDate().toString());
            ps.setString(4, discount.getDescribe());
            ps.setFloat(5, discount.getDiscountRate());
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-02290: check constraint (QLNHASACH.CHECK_KM) violated")) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Tỉ lệ khuyến mãi không hợp lệ. Tỉ lệ phải nhỏ hơn 1",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
            }
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        } 
    }
    static public boolean delete(Discount discount) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.khuyenmai WHERE makm = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1,discount.getId());           
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-02292")) {
                JOptionPane.showMessageDialog(null,
                        "Khuyến mãi hiện đang được áp dụng tại cửa hàng , KHÔNG được xóa!!!",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
            }
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
            }
   
    }
    static public boolean update(Discount discount) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.khuyenmai SET tenkm = ?, "
                        + "ngaybd = TO_DATE(?,'YYYY/MM/DD'), ngaykt = TO_DATE(?,'YYYY/MM/DD'), "
                        + "mota = ?, tilekm = ? "
                        + "WHERE makm = ?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, discount.getName());
                ps.setString(2, discount.getStartDate().toString());
                ps.setString(3, discount.getFinishDate().toString());
                ps.setString(4, discount.getDescribe());
                ps.setFloat(5, discount.getDiscountRate());
                ps.setString(6, discount.getId());
                return (ps.executeUpdate()>0);
            } catch (SQLException ex) {  
                if (ex.getMessage().contains("ORA-02290: check constraint (QLNHASACH.CHECK_KM) violated")) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Tỉ lệ khuyến mãi không hợp lệ. Tỉ lệ phải nhỏ hơn 1",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
                }
                if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }

}
