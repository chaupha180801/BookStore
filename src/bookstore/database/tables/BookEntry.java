
package bookstore.database.tables;
import java.sql.*;
import java.util.*;
import java.util.Date;
import bookstore.database.Database;
import bookstore.exceptions.BillException;
import bookstore.exceptions.DatabasePermissonErrorException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;
public class BookEntry {
    private String id;
    private Date date;
    private int totalPrice;

    public BookEntry(String id, Date date, int totalPrice) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
    }
    
    public BookEntry(){}

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.phieunhapsach";
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
        
    static public BookEntry findById(String id) throws DatabasePermissonErrorException{
        try{
            String query = """
                           SELECT mapn, ngaynhap, tongtiennhap
                           FROM qlnhasach.phieunhapsach 
                           WHERE mapn = ?
                           """;
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            Date date = rs.getDate(2);
            int totalPrice = rs.getInt(3);           
                      
            return new BookEntry(id, date, totalPrice);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
    static public ArrayList<BookEntry> selectAll() throws DatabasePermissonErrorException{
        ArrayList<BookEntry> bookEntrys = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.phieunhapsach order by Mapn ASC";

            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                Date date = rs.getDate(2);
                int totalPrice = rs.getInt(3);                

                bookEntrys.add(new BookEntry(id, date, totalPrice));
            }
            
            return bookEntrys;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return bookEntrys;
        }
    }
    
    static public BookEntry insert(Date date) 
            throws DatabasePermissonErrorException,
            BillException
            {
        try{
            CallableStatement cstmt = Database.connection().prepareCall(
                    "{? = call qlnhasach.them_pns(?)}"
            );
            cstmt.registerOutParameter(1, OracleTypes.VARCHAR);            
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            cstmt.setDate(2, sqlDate);
            
            cstmt.execute();
            
            String bookEntryId = cstmt.getString(1);
            
            cstmt.close();             
            
            return BookEntry.findById(bookEntryId);
        }
        catch (SQLException ex) {
            
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            
            
            System.out.println(ex.getMessage());
            return null;
        } 
    }
    
    static public boolean delete(String id) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.phieunhapsach WHERE mapn = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1, id);
            
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {           
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
            }
    }
    
}
