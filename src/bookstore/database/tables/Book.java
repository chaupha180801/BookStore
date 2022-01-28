/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.database.tables;

import java.sql.*;
import java.util.*;
import bookstore.database.Database;
import bookstore.exceptions.DatabasePermissonErrorException;
import javax.swing.JOptionPane;

public class Book {
    private String id;
    private String name;
    private int publishDate;
    private int price;
    private String typeId;
    private String publisherId;
    private String authorId;
    private int numberOftock;
    
    public Book(){}

    public Book(String id, String name, int publishDate, int price, String typeId, String publisherId, String authorId, int numberOftock) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.price = price;
        this.typeId = typeId;
        this.publisherId = publisherId;
        this.authorId = authorId;
        this.numberOftock = numberOftock;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public int getNumberOfStock() {
        return numberOftock;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }
    
    static public boolean testDelete() throws DatabasePermissonErrorException{
        Connection conn = null;
        try{
            conn = Database.connection();
            String query = "DELETE FROM qlnhasach.sach";
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
    
    static public Book findById(String id) throws DatabasePermissonErrorException{
        try{
            String query = "SELECT * FROM qlnhasach.sach WHERE masach = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            String name = rs.getString(2);
            int publishYear = rs.getInt(3);
            int price = rs.getInt(4);
            String typeId = rs.getString(5);
            String publisherId = rs.getString(6);
            String authorId = rs.getString(7);
            int numberOfStock = rs.getInt(8);
            
            return new Book(id, name, publishYear, price, typeId, publisherId, authorId, numberOfStock);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<Book> findByName(String name, Boolean abs) throws DatabasePermissonErrorException{
        ArrayList<Book> books = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.sach WHERE tensach = ?";
            else
                query = "SELECT * FROM qlnhasach.sach WHERE upper(tensach) LIKE upper(?)";

            PreparedStatement st = Database.connection().prepareStatement(query);

            if (abs)
                st.setString(1, name);
            else
                st.setString(1, "%" + name + "%");

            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                int publishYear = rs.getInt(3);
                int price = rs.getInt(4);
                String typeId = rs.getString(5);
                String publisherId = rs.getString(6);
                String authorId = rs.getString(7);
                int numberOfStock = rs.getInt(8);

                books.add(new Book(id, _name, publishYear, price, typeId, publisherId, authorId, numberOfStock));
            }
            
            return books;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return books;
        }
    }
    
    static public ArrayList<Book> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Book> books = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.sach order by MaSach ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int publishYear = rs.getInt(3);
                int price = rs.getInt(4);
                String typeId = rs.getString(5);
                String publisherId = rs.getString(6);
                String authorId = rs.getString(7);
                int numberOfStock = rs.getInt(8);

                books.add(new Book(id, name, publishYear, price, typeId, publisherId, authorId, numberOfStock));
            }
            
            return books;
        }catch(Exception ex){
           if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return books;
        }
    }
    static public boolean insert(Book book) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.sach(tensach, namxb, giabia, matl, manxb, matg, soluongton)"
                            + " VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = Database.connection().prepareStatement(query);
            ps.setString(1, book.getName());
            ps.setInt(2, book.getPublishDate());
            ps.setInt(3, book.getPrice());
            ps.setString(4, book.getTypeId());
            ps.setString(5, book.getPublisherId());
            ps.setString(6, book.getAuthorId());
            ps.setInt(7, book.getNumberOfStock());
            
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
                return false;
        }
 
    }
    static public boolean delete(Book book) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.sach WHERE masach = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1,book.getId());           
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if (ex.getMessage().contains("ORA-02292: integrity constraint (QLNHASACH.FK_SACH1) violated - child record found")) {
                JOptionPane.showMessageDialog(null,
                        "Sách đang được bán tại cửa hàng không được xóa, KHÔNG được xóa!!!",
                        "Enror", 
                        JOptionPane.WARNING_MESSAGE);
            }
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    static public boolean update(Book book) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.sach SET tensach = ? ,"
                        + " namxb = ?,  giabia = ?,"
                        + "matl = ?, manxb = ?, matg = ?, soluongton = ?"
                        +" WHERE masach =?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, book.getName());
                ps.setInt(2, book.getPublishDate());
                ps.setInt(3, book.getPrice());
                ps.setString(4, book.getTypeId());
                ps.setString(5, book.getPublisherId());
                ps.setString(6, book.getAuthorId());
                ps.setInt(7, book.getNumberOfStock());
                ps.setString(8, book.getId());
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }
    
    static public int countBook() throws DatabasePermissonErrorException{
        try{
            int value = 0;
            String query = "SELECT count(*) FROM qlnhasach.sach";
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
