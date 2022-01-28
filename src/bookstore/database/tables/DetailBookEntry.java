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
import bookstore.exceptions.BookEntryException;
import bookstore.exceptions.DatabasePermissonErrorException;
import javax.swing.JOptionPane;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.SQLException;
public class DetailBookEntry {
    private String bookId;
    private String bookEntryId;
    private int amount;
    private int price;
    
    public DetailBookEntry(){}

    public DetailBookEntry(String bookId, String bookEntryId, int amount, int price) {
        this.bookId = bookId;
        this.bookEntryId = bookEntryId;
        this.amount = amount;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookEntryId() {
        return bookEntryId;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
    
    static public DetailBookEntry findById(String bookEntryId, String bookId) 
            throws DatabasePermissonErrorException{
        try{
            String query =  """
                            SELECT soluongnhap, gianhapsach 
                            FROM qlnhasach.chitietphieunhap
                            WHERE mapn = ? and masach = ?
                            """ ;
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, bookEntryId);
            st.setString(2, bookId);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            int amount = rs.getInt(1);
            int price = rs.getInt(2);
                      
            return new DetailBookEntry(bookId, bookEntryId, amount, price);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public DetailBookEntry insert(String bookEntryId, String bookId, Integer amount, Integer price) 
            throws DatabasePermissonErrorException, BookEntryException{
        try{
            CallableStatement cstmt = Database.connection().prepareCall("{call qlnhasach.them_ctpns(?, ?, ?, ?)}");
            cstmt.setString(1, bookEntryId);
            cstmt.setString(2, bookId);
            cstmt.setInt(3, amount);
            cstmt.setInt(4, price);
            
            cstmt.execute();
            
            DetailBookEntry detailBookEntry = DetailBookEntry.findById(bookEntryId, bookId);
            
            cstmt.close();
            
            return detailBookEntry;
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            
            if(ex.getMessage().contains("ORA-20002"))
                throw new BookEntryException("Chỉ nhập sách có số lượng tồn nhỏ hơn hoặc bằng 250"); 

            if(ex.getMessage().contains("ORA-20003"))
                throw new BookEntryException("Số lượng nhập tối thiểu là 300");
            
            if(ex.getMessage().contains("ORA-20006"))
                throw new BookEntryException("Giá nhập phải nhỏ hơn hoặc bằng giá bán.");
            
            System.out.println(ex.getMessage());
            return null;
        } 
    }
    
    static public boolean delete(String bookEntryId, String bookId) throws DatabasePermissonErrorException{
       
       try{
            String query = "DELETE FROM qlnhasach.chitietphieunhap WHERE mapn = ? and masach = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1, bookEntryId); 
            ps.setString(2, bookId);
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
            }
   
    }
    static public boolean update(DetailBookEntry oldDB, DetailBookEntry newDB) throws DatabasePermissonErrorException{
        try {
                String query = """
                               UPDATE qlnhasach.chitietphieunhap 
                               SET mapn = ?, masach = ?, soluongnhap = ?, gianhapsach = ?
                               WHERE mapn = ? and masach = ?
                               """;
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, newDB.getBookEntryId()); 
                ps.setString(2, newDB.getBookId());
                ps.setInt(3, newDB.getAmount()); 
                ps.setInt(4, newDB.getPrice()); 
                ps.setString(5, oldDB.getBookEntryId()); 
                ps.setString(6, oldDB.getBookId());
                
                return (ps.executeUpdate()>0);
            } catch (SQLException ex) {
                
                if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }
    
    static public ArrayList<DetailBookEntry> selectAll(String id) throws DatabasePermissonErrorException{
        ArrayList<DetailBookEntry> detailBookEntrys = new ArrayList<>();
        try{
            String query = "SELECT masach, gianhapsach, soluongnhap "
                    + "FROM qlnhasach.chitietphieunhap "
                    + "WHERE mapn = ?";
 
            PreparedStatement st = Database.connection().prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                String bookId = rs.getString(1);
                int price = rs.getInt(2);
                int amount = rs.getInt(3);

                detailBookEntrys.add(new DetailBookEntry(bookId, id, amount, price));
            }
            
            return detailBookEntrys;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return detailBookEntrys;
        }
    }
}
