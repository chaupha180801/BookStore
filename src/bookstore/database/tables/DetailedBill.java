
package bookstore.database.tables;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.util.Date;
import bookstore.database.Database;
import bookstore.exceptions.DatabasePermissonErrorException;
import javax.swing.JOptionPane;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.SQLException;


public class DetailedBill {
    private String bookId;
    private String billId;
    private int price;
    private int amount;
    
    public DetailedBill(){}

    public DetailedBill(String bookId, String billId, int price, int amount) {
        this.bookId = bookId;
        this.billId = billId;
        this.price = price;
        this.amount = amount;
    }

    public String getBookId() {
        return bookId; 
    }

    public String getBillId() {
        return billId;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    static public DetailedBill findById(String billId, String bookId) 
            throws DatabasePermissonErrorException{
        try{
            String query =  """
                            SELECT soluong, dongia 
                            FROM qlnhasach.chitiethoadon 
                            WHERE mahd = ? and masach = ?
                            """ ;
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, billId);
            st.setString(2, bookId);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            int amount = rs.getInt(1);
            int price = rs.getInt(2);
                      
            return new DetailedBill(bookId, billId, price, amount);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public DetailedBill insert(String billId, String bookId, Integer amount) 
            throws DatabasePermissonErrorException{
        try{
            CallableStatement cstmt = Database.connection().prepareCall("{call qlnhasach.them_cthd(?, ?, ?)}");
            cstmt.setString(1, billId);
            cstmt.setString(2, bookId);
            cstmt.setInt(3, amount);
            
            cstmt.execute();
            
            DetailedBill detailedBill = DetailedBill.findById(billId, bookId);
            
            cstmt.close();
            
            return detailedBill;
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        } 
    }
    
    static public boolean delete(String billId, String bookId) throws DatabasePermissonErrorException{
       
       try{
            String query = "DELETE FROM qlnhasach.chitiethoadon WHERE mahd = ? and masach = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1, billId); 
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
    static public boolean update(DetailedBill oldDB, DetailedBill newDB) throws DatabasePermissonErrorException{
        try {
                String query = """
                               UPDATE qlnhasach.chitiethoadon 
                               SET mahd = ?, masach = ?, soluong=?, dongia=?
                               WHERE mahd = ? and masach = ?
                               """;
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, newDB.getBillId()); 
                ps.setString(2, newDB.getBookId());
                ps.setInt(3, newDB.getAmount()); 
                ps.setInt(4, newDB.getPrice()); 
                ps.setString(5, oldDB.getBillId()); 
                ps.setString(6, oldDB.getBookId());
                
                return (ps.executeUpdate()>0);
            } catch (SQLException ex) {
                
                if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }
    
    static public ArrayList<DetailedBill> selectAll(String id) throws DatabasePermissonErrorException{
        ArrayList<DetailedBill> detailedBills = new ArrayList<>();
        try{
            String query = "SELECT masach, dongia, soluong FROM qlnhasach.chitiethoadon where mahd = ?";
 
            PreparedStatement st = Database.connection().prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            

            while (rs.next()){
                String bookId = rs.getString(1);
                int price = rs.getInt(2);
                int amount = rs.getInt(3);

                detailedBills.add(new DetailedBill(bookId, id, price, amount));
            }
            
            return detailedBills;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return detailedBills;
        }
    }
}
