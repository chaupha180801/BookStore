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

public class Author {
    public Author(){}
    public Author(
            String id,
            String name,
            String address,
            String lifeStory,
            String phoneNumber,
            String email
    ){
        this.id = id;
        this.name = name;
        this.address = address;
        this.lifeStory = lifeStory;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public String getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLifeStory() {
        return lifeStory;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLifeStory(String lifeStory) {
        this.lifeStory = lifeStory;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name; 
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.tacgia";
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
    
    static public Author findById(String id) throws DatabasePermissonErrorException {
        try{
            String query = "SELECT * FROM qlnhasach.tacgia WHERE matg = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            String name = rs.getString(2);
            String address = rs.getString(3);
            String lifeStory = rs.getString(4);
            String phoneNumber = rs.getString(5);
            String email = rs.getString(6);
            
            return new Author(id, name, address, lifeStory, phoneNumber, email);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<Author> findByName(String name, Boolean abs) 
    throws DatabasePermissonErrorException{
        ArrayList<Author> authors = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.tacgia WHERE tentg = ?";
            else
                query = "SELECT * FROM qlnhasach.tacgia WHERE upper(tentg) LIKE upper(?)";

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
                String lifeStory = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String email = rs.getString(6);

                authors.add(new Author(id, _name, address, lifeStory, phoneNumber, email));
            }
            
            return authors;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return authors;
        }
    }
    
    static public ArrayList<Author> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Author> authors = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.tacgia order by MaTG ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                String address = rs.getString(3);
                String lifeStory = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String email = rs.getString(6);

                authors.add(new Author(id, _name, address, lifeStory, phoneNumber, email));
            }
            
            return authors;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return authors;
        }
    }
    
    static public boolean insert(Author author) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.tacgia(tentg,diachi,tieusu,sdt,email)"
                            + " VALUES (?,?,?,?,?)";
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, author.getName());
            ps.setString(2, author.getAddress());
            ps.setString(3, author.getLifeStory());
            ps.setString(4, author.getPhoneNumber());
            ps.setString(5, author.getEmail());
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
        
        
    }
    static public boolean delete(Author author) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.tacgia WHERE matg = ?";
                            
            PreparedStatement ps = Database.connection().prepareStatement(query);
            
            ps.setString(1,author.getId());           
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-02292")) {
                JOptionPane.showMessageDialog(null,
                        "Sách của tác giả hiện có tại cửa hàng , KHÔNG được xóa!!!",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
            }
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
            }
   
    }
    static public boolean update(Author author) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.tacgia SET tentg = ? ,"
                        + "diachi = ?, tieusu = ?,"
                        + "sdt = ?, email = ?"
                        +" WHERE matg =?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, author.getName()); 
                ps.setString(2,author.getAddress());
                ps.setString(3,author.getLifeStory());
                ps.setString(4, author.getPhoneNumber());
                ps.setString(5, author.getEmail());
                ps.setString(6, author.getId());    
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                
                if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }
    
    static public int countAuthor() throws DatabasePermissonErrorException{
        try{
            int value = 0;
            String query = "SELECT count(*) FROM qlnhasach.tacgia";
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
   
    private String id;
    private String name;
    private String address;
    private String lifeStory;
    private String phoneNumber;
    private String email;
}
