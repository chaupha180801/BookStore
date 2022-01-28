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

public class Category {
    private String id;
    private String name;
    private String explain;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExplain() {
        return explain;
    }
    
    public Category(){}

    public Category(String id, String name, String explain) {
        this.id = id;
        this.name = name;
        this.explain = explain;
    }
    
    @Override
    public String toString() {
        return this.id + " - " + this.name; 
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.theloai";
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
     
    static public Category findById(String id) throws DatabasePermissonErrorException{
        try{
            String query = "SELECT * FROM qlnhasach.theloai WHERE matl = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            String name = rs.getString(2);
            String explain = rs.getString(3);

            return new Category(id, name, explain);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<Category> findByName(String name, Boolean abs) throws DatabasePermissonErrorException{
        ArrayList<Category> type = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.theloai WHERE tentl = ?";
            else
                query = "SELECT * FROM qlnhasach.theloai WHERE upper(tentl) LIKE upper(?)";

            PreparedStatement st = Database.connection().prepareStatement(query);

            if (abs)
                st.setString(1, name);
            else
                st.setString(1, "%" + name + "%");

            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                String explain = rs.getString(3);

                type.add(new Category(id, _name, explain));
            }
            
            return type;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return type;
        }
    }
    
    static public ArrayList<Category> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Category> type = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.theloai order by Matl ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                String explain = rs.getString(3);

                type.add(new Category(id, _name, explain));
            }
            
            return type;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return type;
        }
    }
    
    static public boolean insert(Category type) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.theloai(tentl, diengiai)"
                            + " VALUES (?,?)";
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, type.getName());
            ps.setString(2, type.getExplain());
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
        
        
    }
    static public boolean delete(Category type) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.theloai WHERE matl = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1,type.getId());           
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-02292")) {
                JOptionPane.showMessageDialog(null, 
                        "Thể loại sách hiện có tại cửa hàng, KHÔNG được xóa!!!",
                        "Enror",
                        JOptionPane.WARNING_MESSAGE);
            }
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
   
    }
    static public boolean update(Category type) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.theloai SET tentl = ?,"
                        + "diengiai = ?"
                        +" WHERE matl =?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, type.getName()); 
                ps.setString(2, type.getExplain());
                ps.setString(3, type.getId());    
                return (ps.executeUpdate()>0);
                
        } catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());    
            return false;
        }
    }
       static public int countCategory() throws DatabasePermissonErrorException{
        try{
            int value = 0;
            String query = "SELECT count(*) FROM qlnhasach.theloai";
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
