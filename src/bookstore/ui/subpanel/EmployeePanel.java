/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.ui.subpanel;

import java.util.ArrayList;
import bookstore.database.tables.Employee;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import bookstore.exceptions.*;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;


public class EmployeePanel extends javax.swing.JPanel {

    /**
     * Creates new form EmployeePanel
     */
    public EmployeePanel() {
        initComponents();
        this.reloadTable();
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(0,204,102));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setPreferredSize(new Dimension(60, 40));
        table.setRowHeight(40);
        table.setSelectionBackground(Color.black);
    }
    
    public void renderTable(ArrayList<Employee> employees){
        String[] columnName = {"Mã nhân viên", "Tên nhân viên", "Chức vụ",
        "Ngày bắt đầu", "Địa chỉ", "SĐT", "Lương"};
        Object[][] rows = new Object[employees.size()][7];
        
        for(int i = 0; i < employees.size(); i ++){
            rows[i][0] = employees.get(i).getId();
            rows[i][1] = employees.get(i).getName();
            rows[i][2] = employees.get(i).getPosition();
            rows[i][3] = employees.get(i).getStartDate();
            rows[i][4] = employees.get(i).getAddress();
            rows[i][5] = employees.get(i).getPhoneNumber();
            rows[i][6] = employees.get(i).getSalary();
        }
        DefaultTableModel model = new DefaultTableModel(rows, columnName);
        this.table.setModel(model);
    }
    
    public Employee getSelectedRowInTable(){
        try{
            int row = this.table.getSelectedRow();

            if (row == -1)
                return null;

            String id = this.table.getValueAt(row,0).toString();
            String name = this.table.getValueAt(row,1).toString();
            int position = Integer.valueOf(this.table.getValueAt(row,2).toString());
            Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(this.table.getValueAt(row, 3).toString());
            java.sql.Date sqlngvl = new java.sql.Date(startdate.getTime());
            String address = this.table.getValueAt(row,4).toString();
            String phonenumber = this.table.getValueAt(row,5).toString();
            int salary = Integer.valueOf(this.table.getValueAt(row,6).toString());
            return new Employee(id, name, position, sqlngvl, address, phonenumber, salary);
        }catch(ParseException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public void reloadTable(){
        try{
            ArrayList<Employee> employees = Employee.selectAll();      
            this.renderTable(employees);
        }catch(DatabasePermissonErrorException ex){
            CardLayout card = (CardLayout)this.displayPanel.getLayout();
            card.show(this.displayPanel,"nopermission");
            updateSalaryButton.setVisible(false);
            addButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            resetButton.setVisible(false);
            return;
        }       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        updateSalaryPanel = new javax.swing.JPanel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(429, 0), new java.awt.Dimension(429, 0), new java.awt.Dimension(429, 32767));
        updateSalaryButton = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        changeTextField = new javax.swing.JTextField();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        searchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        searchTextField = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        addButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        editButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        deleteButton = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        resetButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        noPermissionLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setMinimumSize(new java.awt.Dimension(300, 400));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        titlePanel.setBackground(new java.awt.Color(255, 255, 255));
        titlePanel.setMaximumSize(new java.awt.Dimension(32767, 100));
        titlePanel.setMinimumSize(new java.awt.Dimension(200, 50));
        titlePanel.setPreferredSize(new java.awt.Dimension(650, 50));
        titlePanel.setLayout(new java.awt.BorderLayout());

        titleLabel.setBackground(new java.awt.Color(40, 60, 92));
        titleLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("QUẢN LÝ THÔNG TIN NHÂN VIÊN");
        titlePanel.add(titleLabel, java.awt.BorderLayout.CENTER);

        add(titlePanel);

        updateSalaryPanel.setBackground(new java.awt.Color(255, 255, 255));
        updateSalaryPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        updateSalaryPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        updateSalaryPanel.setPreferredSize(new java.awt.Dimension(40, 40));

        updateSalaryButton.setBackground(new java.awt.Color(0, 0, 0));
        updateSalaryButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateSalaryButton.setForeground(new java.awt.Color(255, 255, 255));
        updateSalaryButton.setText("Tăng lương");
        updateSalaryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        updateSalaryButton.setMaximumSize(new java.awt.Dimension(103, 32000));
        updateSalaryButton.setMinimumSize(new java.awt.Dimension(110, 30));
        updateSalaryButton.setPreferredSize(new java.awt.Dimension(110, 40));
        updateSalaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSalaryButtonActionPerformed(evt);
            }
        });

        changeTextField.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        changeTextField.setText("Nhập mức lương tăng");
        changeTextField.setMaximumSize(new java.awt.Dimension(500, 32000));
        changeTextField.setMinimumSize(new java.awt.Dimension(20, 20));
        changeTextField.setPreferredSize(new java.awt.Dimension(20, 20));
        changeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                changeTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                changeTextFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout updateSalaryPanelLayout = new javax.swing.GroupLayout(updateSalaryPanel);
        updateSalaryPanel.setLayout(updateSalaryPanelLayout);
        updateSalaryPanelLayout.setHorizontalGroup(
            updateSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSalaryPanelLayout.createSequentialGroup()
                .addComponent(filler8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateSalaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        updateSalaryPanelLayout.setVerticalGroup(
            updateSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSalaryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateSalaryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(changeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateSalaryPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateSalaryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(updateSalaryPanel);

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        searchPanel.setMaximumSize(new java.awt.Dimension(32767, 100));
        searchPanel.setMinimumSize(new java.awt.Dimension(300, 50));
        searchPanel.setPreferredSize(new java.awt.Dimension(650, 80));
        searchPanel.setLayout(new javax.swing.BoxLayout(searchPanel, javax.swing.BoxLayout.LINE_AXIS));

        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\loupe.png")); // NOI18N
        searchButton.setBorder(null);
        searchButton.setMaximumSize(new java.awt.Dimension(32, 32));
        searchButton.setMinimumSize(new java.awt.Dimension(32, 32));
        searchButton.setPreferredSize(new java.awt.Dimension(32, 32));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchPanel.add(searchButton);
        searchPanel.add(filler1);

        searchTextField.setFont(new java.awt.Font("Times New Roman", 2, 15)); // NOI18N
        searchTextField.setText("Nhập thông tin cần tìm vào đây.");
        searchTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 60, 92)));
        searchTextField.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        searchTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        searchTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusLost(evt);
            }
        });
        searchPanel.add(searchTextField);
        searchPanel.add(filler2);

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\add.png")); // NOI18N
        addButton.setBorder(null);
        addButton.setMaximumSize(new java.awt.Dimension(32, 32));
        addButton.setMinimumSize(new java.awt.Dimension(32, 32));
        addButton.setPreferredSize(new java.awt.Dimension(32, 32));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        searchPanel.add(addButton);
        searchPanel.add(filler3);

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\edit (1).png")); // NOI18N
        editButton.setBorder(null);
        editButton.setMaximumSize(new java.awt.Dimension(32, 32));
        editButton.setMinimumSize(new java.awt.Dimension(32, 32));
        editButton.setPreferredSize(new java.awt.Dimension(32, 32));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        searchPanel.add(editButton);
        searchPanel.add(filler4);

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\001-bin.png")); // NOI18N
        deleteButton.setBorder(null);
        deleteButton.setMaximumSize(new java.awt.Dimension(32, 32));
        deleteButton.setMinimumSize(new java.awt.Dimension(32, 32));
        deleteButton.setPreferredSize(new java.awt.Dimension(32, 32));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        searchPanel.add(deleteButton);
        searchPanel.add(filler5);

        resetButton.setBackground(new java.awt.Color(255, 255, 255));
        resetButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Pictures\\loop.png")); // NOI18N
        resetButton.setBorder(null);
        resetButton.setMaximumSize(new java.awt.Dimension(32, 32));
        resetButton.setMinimumSize(new java.awt.Dimension(32, 32));
        resetButton.setPreferredSize(new java.awt.Dimension(32, 32));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        searchPanel.add(resetButton);

        add(searchPanel);

        displayPanel.setLayout(new java.awt.CardLayout());

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(null);
        tablePanel.setMinimumSize(new java.awt.Dimension(200, 300));
        tablePanel.setPreferredSize(new java.awt.Dimension(650, 240));

        table.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Ngày bắt đầu", "Địa chỉ", "SĐT", "Lương"
            }
        ));
        table.setSelectionForeground(new java.awt.Color(255, 204, 255));
        tablePanel.setViewportView(table);

        displayPanel.add(tablePanel, "table");

        noPermissionLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        noPermissionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noPermissionLabel.setText("Bạn không có quyền xem dữ liệu này");
        noPermissionLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        noPermissionLabel.setOpaque(true);
        displayPanel.add(noPermissionLabel, "nopermission");

        add(displayPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        try{
            String input = searchTextField.getText();
            ArrayList<Employee> employees = Employee.findByName(input,false);
            this.renderTable(employees);
        }catch(DatabasePermissonErrorException ex){
            JOptionPane.showMessageDialog(null,
                "Bạn không có quyền tìm kiếm dữ liệu này.",
                "Lỗi", 1);
            
        }

    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        // TODO add your handling code here:
        if(searchTextField.getText().equals("Nhập thông tin cần tìm vào đây.")){
            searchTextField.setText("");
        }
    }//GEN-LAST:event_searchTextFieldFocusGained

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
        if(searchTextField.getText().equals("")){
            searchTextField.setText("Nhập thông tin cần tìm vào đây.");
        }
    }//GEN-LAST:event_searchTextFieldFocusLost

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        AddEmployee addEmployee = new AddEmployee(this);
        addEmployee.show();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        Employee employee = this.getSelectedRowInTable();

        if (employee == null)
        return;

        AddEmployee addEmployee = new AddEmployee(this, employee);
        addEmployee.show();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try{
            Employee employee = this.getSelectedRowInTable();

            if (employee == null)
            return;

            int option = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc muốn xóa " + employee.getName() + " không? ",
                "Xóa",
                JOptionPane.YES_NO_OPTION
            );
            if(option == JOptionPane.YES_OPTION){
                if(Employee.delete(employee)){
                    JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công.", "Xóa dữ liệu", 1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Dữ liệu không xóa được.", "Sửa thông tin", 2);
                }
            }

            this.reloadTable();
        }catch(DatabasePermissonErrorException ex){
            JOptionPane.showMessageDialog(null,
                "Bạn không có quyền xóa dữ liệu này.",
                "Lỗi ", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        this.reloadTable();
        if(this.searchTextField.getText().equals("") == false){
            this.searchTextField.setText("Nhập thông tin cần tìm vào đây.");
        }
    }//GEN-LAST:event_resetButtonActionPerformed

    private void updateSalaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSalaryButtonActionPerformed
        try{
            Employee employee = this.getSelectedRowInTable();

            if (employee == null)
            return;
            
            int change = Integer.valueOf(changeTextField.getText());
            if(change == 0){
               JOptionPane.showMessageDialog(null, "Bạn chưa nhập mức lương tăng thêm", "Nhập mức lương", 2); 
            }
            int option = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc muốn tăng lương " + employee.getName() + " không? ",
                "Tăng",
                JOptionPane.YES_NO_OPTION
            );
            if(option == JOptionPane.YES_OPTION){
                if(Employee.updateSalary(employee.getId(), change)){
                    JOptionPane.showMessageDialog(null, "Tăng lương thành công", "Tăng lương", 1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Không thực hiện thành công", "Tăng lương", 2);
                }
            }

            this.reloadTable();
        }catch(DatabasePermissonErrorException ex){
            JOptionPane.showMessageDialog(null,
                "Bạn không có quyền tăng lương.",
                "Lỗi ", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_updateSalaryButtonActionPerformed

    private void changeTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_changeTextFieldFocusGained
        if(changeTextField.getText().equals("Nhập mức lương tăng")){
            changeTextField.setText("");
        }
    }//GEN-LAST:event_changeTextFieldFocusGained

    private void changeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_changeTextFieldFocusLost
        if(changeTextField.getText().equals("")){
            changeTextField.setText("Nhập mức lương tăng");
        }
    }//GEN-LAST:event_changeTextFieldFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField changeTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JButton editButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JLabel noPermissionLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JButton updateSalaryButton;
    private javax.swing.JPanel updateSalaryPanel;
    // End of variables declaration//GEN-END:variables
}
