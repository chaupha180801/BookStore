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

public class Employee {
    private String id;
    private String name;
    private int position;
    private Date startDate;
    private String address;
    private String phoneNumber;
    private int salary;
    
    public Employee(){}

    public Employee(String id, String name, int position, Date startDate, String address, String phoneNumber, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.startDate = startDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }
    
    
    static public Employee findById(String id) throws DatabasePermissonErrorException {
        try{
            String query = "SELECT * FROM qlnhasach.nhanvien WHERE manv = ?";
            PreparedStatement st = Database.connection().prepareStatement(query);

            st.setString(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next() == false)
                return null;
            
            String name = rs.getString(2);
            int position = rs.getInt(3);
            Date startdate = rs.getDate(4);
            String address = rs.getString(5);
            String phoneNumber = rs.getString(6);
            int salary = rs.getInt(7);
            
            return new Employee(id, name, position, startdate, address, phoneNumber, salary);
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    static public ArrayList<Employee> findByName(String name, Boolean abs) 
    throws DatabasePermissonErrorException{
        ArrayList<Employee> employees = new ArrayList<>();
        
        try{
            String query;
            if (abs)
                query = "SELECT * FROM qlnhasach.nhanvien WHERE tennv = ?";
            else
                query = "SELECT * FROM qlnhasach.nhanvien WHERE upper(tennv) LIKE upper(?)"
                        + "or upper(diachi) LIKE upper(?)";

            PreparedStatement st = Database.connection().prepareStatement(query);

            if (abs)
                st.setString(1, name);
            else
                st.setString(1, "%" + name + "%");
                st.setString(2, "%" + name + "%");

            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                int position = rs.getInt(3);
                Date startdate = rs.getDate(4);
                String address = rs.getString(5);
                String phoneNumber = rs.getString(6);
                int salary = rs.getInt(7);

                employees.add(new Employee(id, _name, position, startdate, address, phoneNumber, salary));
            }
            
            return employees;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942")|| ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return employees;
        }
    }
    static public ArrayList<Employee> selectAll() throws DatabasePermissonErrorException{
        ArrayList<Employee> employees = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM qlnhasach.nhanvien order by MaNV ASC";
                
            PreparedStatement st = Database.connection().prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String id = rs.getString(1);
                String _name = rs.getString(2);
                int position = rs.getInt(3);
                Date startdate = rs.getDate(4);
                String address = rs.getString(5);
                String phoneNumber = rs.getString(6);
                int salary = rs.getInt(7);

                employees.add(new Employee(id, _name, position, startdate, address, phoneNumber, salary));
            }
            
            return employees;
        }catch(Exception ex){
            if(ex.getMessage().contains("ORA-00942"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return employees;
        }
    }
    
    static public boolean insert(Employee employee) throws DatabasePermissonErrorException{
        try{
            String query = "INSERT INTO qlnhasach.nhanvien(tennv, chucvu, ngaylv, diachi, sdt, luong)"
                            + " VALUES (?, ?, TO_DATE(?,'YYYY/MM/DD'), ?, ?, ?)";
            PreparedStatement ps=Database.connection().prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getPosition());
            ps.setString(3, employee.getStartDate().toString());
            ps.setString(4, employee.getAddress());
            ps.setString(5, employee.getPhoneNumber());
            ps.setInt(6, employee.getSalary());
            return (ps.executeUpdate()>0);
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-02290: check constraint (QLNHASACH.CHECK_CHUCVU) violated"))
                JOptionPane.showMessageDialog(null,
                        "Chức vụ của nhân viên chỉ có thể là 0, 1, 2",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        } 
    }
    
    static public boolean delete(Employee employee) throws DatabasePermissonErrorException{
       
        try{
            String query = "DELETE FROM qlnhasach.nhanvien WHERE manv = ?";
                            
            PreparedStatement ps=Database.connection().prepareStatement(query);
            
            ps.setString(1,employee.getId());           
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
    static public boolean update(Employee employee) throws DatabasePermissonErrorException{
        try {
                String query = "UPDATE qlnhasach.nhanvien SET tennv = ? ,"
                        + "chucvu = ?, ngaylv = TO_DATE(?,'YYYY/MM/DD'),"
                        + "diachi = ?, sdt = ?, luong = ?"
                        +" WHERE manv =?";
                PreparedStatement ps=Database.connection().prepareStatement(query);
                ps.setString(1, employee.getName());
                ps.setInt(2, employee.getPosition());
                ps.setString(3, employee.getStartDate().toString());
                ps.setString(4, employee.getAddress());
                ps.setString(5, employee.getPhoneNumber());
                ps.setInt(6, employee.getSalary()); 
                ps.setString(7, employee.getId());
                return (ps.executeUpdate()>0);
                
            } catch (SQLException ex) {
                if(ex.getMessage().contains("ORA-02290: check constraint (QLNHASACH.CHECK_CHUCVU) violated"))
                JOptionPane.showMessageDialog(null,
                        "Chức vụ của nhân viên chỉ có thể là 0, 1, 2",
                        "Lỗi", 
                        JOptionPane.WARNING_MESSAGE);
                if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                    throw new DatabasePermissonErrorException();
                System.out.println(ex.getMessage());
                return false;
            }
    }
    
    static public boolean updateSalary(String id, int change) throws DatabasePermissonErrorException{
           try{
            CallableStatement cstmt = Database.connection().prepareCall(
                    "{call qlnhasach.cap_nhat_luong_bat_thuong(?, ?)}"
            );
            
            cstmt.setString(1, id);
            cstmt.setInt(2, change);                      
            cstmt.execute();
                      
            cstmt.close();             
            
            return true;
        }
        catch (SQLException ex) {
            if(ex.getMessage().contains("ORA-00942") || ex.getMessage().contains("ORA-01031"))
                throw new DatabasePermissonErrorException();
            System.out.println(ex.getMessage());
            return false;
        } 
    }
    
       static public int countEmployee() throws DatabasePermissonErrorException{
        try{
            int value = 0;
            String query = "SELECT count(*) FROM qlnhasach.nhanvien";
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
