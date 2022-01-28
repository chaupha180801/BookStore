/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.ui.subpanel;

import java.util.ArrayList;
import bookstore.database.tables.Bill;
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
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.util.HashMap;
import bookstore.database.Database;

public class BillPanel extends javax.swing.JPanel {

 
    public BillPanel() {
        initComponents();
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(0,204,102));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setPreferredSize(new Dimension(60, 40));
        table.setRowHeight(40);
        table.setSelectionBackground(Color.black);
        this.reloadTable();
        
        try{
            Bill.testDelete();
            
            

        }catch(DatabasePermissonErrorException ex){
            addButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
        }
    }
    
    public void renderTable(ArrayList<Bill> bills){
        String[] columnName = {"Mã hóa đơn", "Ngày hóa đơn", "Thành tiền",
        "Số tiền thực trả", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Tổng hóa đơn"};
        Object[][] rows = new Object[bills.size()][8];
        
        for(int i = 0; i < bills.size(); i ++){
            rows[i][0] = bills.get(i).getId();
            rows[i][1] = bills.get(i).getDate();
            rows[i][2] = bills.get(i).getTotalPrice();
            rows[i][3] = bills.get(i).getPaid();
            rows[i][4] = bills.get(i).getEmployeeId();
            rows[i][5] = bills.get(i).getCustomerId();
            rows[i][6] = bills.get(i).getDiscountId();
            rows[i][7] = bills.get(i).getFinalPrice();
            
        }
        DefaultTableModel model = new DefaultTableModel(rows, columnName);
        this.table.setModel(model);
    }
    
    public Bill getSelectedRowInTable(){
        try{
            int row = this.table.getSelectedRow();
            
            if (row == -1)
                return null;

            String id = this.table.getValueAt(row,0).toString();
            Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(this.table.getValueAt(row, 1).toString());
            java.sql.Date sqlnghd = new java.sql.Date(startdate.getTime());
            int finalPrice = Integer.valueOf(this.table.getValueAt(row,2).toString());
            int paid = Integer.valueOf(this.table.getValueAt(row,3).toString());
            String employeeId = this.table.getValueAt(row,4).toString();
            String customerId = this.table.getValueAt(row,5).toString();
            String discountId = (String)this.table.getValueAt(row, 6);
            if(discountId == null)
                discountId = null;
            else
                discountId = discountId.toString();
            
            int totalPrice = Integer.valueOf(this.table.getValueAt(row,7).toString());
            return new Bill(id, sqlnghd, totalPrice, paid, employeeId, customerId, discountId, finalPrice);
        }catch(ParseException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public void reloadTable(){
        try{
            ArrayList<Bill> bills = Bill.selectAll();
            this.renderTable(bills);
        }catch(DatabasePermissonErrorException ex){
            CardLayout card = (CardLayout)this.displayPanel.getLayout();
            card.show(this.displayPanel,"nopermission");
            return;
        }       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        updateSalaryPanel = new javax.swing.JPanel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(446, 0), new java.awt.Dimension(446, 0), new java.awt.Dimension(446, 32767));
        statictistButton = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        dateJDchoose = new com.toedter.calendar.JDateChooser();
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
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        inBillButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        noPermissionLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        titlePanel.setBackground(new java.awt.Color(255, 255, 255));
        titlePanel.setMaximumSize(new java.awt.Dimension(32767, 100));
        titlePanel.setMinimumSize(new java.awt.Dimension(200, 50));
        titlePanel.setPreferredSize(new java.awt.Dimension(650, 50));
        titlePanel.setLayout(new java.awt.BorderLayout());

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("QUẢN LÝ THÔNG TIN HÓA ĐƠN");
        titlePanel.add(titleLabel, java.awt.BorderLayout.CENTER);
        titlePanel.add(filler8, java.awt.BorderLayout.PAGE_END);

        add(titlePanel);

        updateSalaryPanel.setBackground(new java.awt.Color(255, 255, 255));
        updateSalaryPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        updateSalaryPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        updateSalaryPanel.setPreferredSize(new java.awt.Dimension(40, 40));

        statictistButton.setBackground(new java.awt.Color(0, 0, 0));
        statictistButton.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        statictistButton.setForeground(new java.awt.Color(255, 255, 255));
        statictistButton.setText("Thống kê theo ngày");
        statictistButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        statictistButton.setMaximumSize(new java.awt.Dimension(103, 32000));
        statictistButton.setMinimumSize(new java.awt.Dimension(110, 30));
        statictistButton.setPreferredSize(new java.awt.Dimension(110, 45));
        statictistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statictistButtonActionPerformed(evt);
            }
        });

        dateJDchoose.setDateFormatString("yyyy-MM-dd");
        dateJDchoose.setMaximumSize(new java.awt.Dimension(150, 150));
        dateJDchoose.setMinimumSize(new java.awt.Dimension(60, 60));
        dateJDchoose.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout updateSalaryPanelLayout = new javax.swing.GroupLayout(updateSalaryPanel);
        updateSalaryPanel.setLayout(updateSalaryPanelLayout);
        updateSalaryPanelLayout.setHorizontalGroup(
            updateSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSalaryPanelLayout.createSequentialGroup()
                .addComponent(filler9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statictistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateJDchoose, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        updateSalaryPanelLayout.setVerticalGroup(
            updateSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateSalaryPanelLayout.createSequentialGroup()
                .addGroup(updateSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filler9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filler7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filler6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(updateSalaryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(updateSalaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateJDchoose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(updateSalaryPanelLayout.createSequentialGroup()
                                .addComponent(statictistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
        searchPanel.add(filler10);

        inBillButton.setBackground(new java.awt.Color(255, 255, 255));
        inBillButton.setIcon(new javax.swing.ImageIcon("D:\\ireport\\inhoadon.png")); // NOI18N
        inBillButton.setBorder(null);
        inBillButton.setMaximumSize(new java.awt.Dimension(32, 32));
        inBillButton.setMinimumSize(new java.awt.Dimension(32, 32));
        inBillButton.setPreferredSize(new java.awt.Dimension(32, 32));
        inBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inBillButtonActionPerformed(evt);
            }
        });
        searchPanel.add(inBillButton);

        add(searchPanel);

        displayPanel.setLayout(new java.awt.CardLayout());

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setMinimumSize(new java.awt.Dimension(200, 300));
        tablePanel.setPreferredSize(new java.awt.Dimension(650, 240));

        table.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày hóa đơn", "Thành tiền", "Số tiền thực trả", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Tổng hóa đơn"
            }
        ));
        table.setSelectionForeground(new java.awt.Color(255, 204, 255));
        tablePanel.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(7).setResizable(false);
        }

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
            Bill bill = Bill.findById(input);
            ArrayList<Bill> bills = new ArrayList<>();
            bills.add(bill);
            this.renderTable(bills);
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
        InitialInfoBillChooser infoChooser = new InitialInfoBillChooser(this);
        infoChooser.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        Bill bill = this.getSelectedRowInTable();

        if (bill == null)
            return;

        AddBill addBill = new AddBill(this, bill);
        addBill.show();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try{
            Bill bill = this.getSelectedRowInTable();

            if (bill == null)
            return;

            int option = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc muốn xóa " + bill.getId() + " không? ",
                "Xóa",
                JOptionPane.YES_NO_OPTION
            );
            if(option == JOptionPane.YES_OPTION){
                if(Bill.delete(bill.getId())){
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
        ((JTextField)dateJDchoose.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void statictistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statictistButtonActionPerformed
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(dateJDchoose.getDate());
            try{
                Date nghd = dateFormat.parse(date);
                java.sql.Date sqlnghd = new java.sql.Date(nghd.getTime());
                ShowBill bills = new ShowBill(sqlnghd);
                bills.setVisible(true);
                bills.pack();
                bills.setLocationRelativeTo(null);
                bills.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }catch(ParseException ex){
                System.out.println(ex.getMessage());     
            }
            
            
        }catch(DatabasePermissonErrorException ex){
            System.out.println(ex.getMessage());
        }       
    }//GEN-LAST:event_statictistButtonActionPerformed

    private void inBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inBillButtonActionPerformed
        Bill bill = this.getSelectedRowInTable();
        if(bill.getDiscountId() != null){
            try {  
                JasperDesign jd = JRXmlLoader.load(
                        "D:\\ireport\\report-baocao.jrxml"
                );
                JasperReport jr = JasperCompileManager.compileReport(
                        "D:\\ireport\\report-baocao.jrxml"
                );

                HashMap hm = new HashMap();
                hm.put("MaHD", bill.getId());

                JasperPrint jp = JasperFillManager.fillReport(jr, hm, Database.connection());
                JasperViewer.viewReport(jp, false);

                java.text.SimpleDateFormat sdm = new java.text.SimpleDateFormat("dd MM yyyy hh mm ss");

                String fileName = "report " + sdm.format(new java.util.Date()) + ".pdf"; 

                JasperExportManager.exportReportToPdfFile(
                    jp, "D:\\UIT\\Lap trinh java\\bookstore\\report\\" + fileName
                );
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot show report" + e);
                 e.printStackTrace();
            }
        }
        else {
            try {  
                JasperDesign jd = JRXmlLoader.load(
                        "D:\\ireport\\report-baocao_khongKM.jrxml"
                );
                JasperReport jr = JasperCompileManager.compileReport(
                        "D:\\ireport\\report-baocao_khongKM.jrxml"
                );

                HashMap hm = new HashMap();
                hm.put("MaHD", bill.getId());

                JasperPrint jp = JasperFillManager.fillReport(jr, hm, Database.connection());
                JasperViewer.viewReport(jp, false);

                java.text.SimpleDateFormat sdm = new java.text.SimpleDateFormat("dd MM yyyy hh mm ss");

                String fileName = "report " + sdm.format(new java.util.Date()) + ".pdf"; 

                JasperExportManager.exportReportToPdfFile(
                    jp, "D:\\UIT\\Lap trinh java\\bookstore\\report\\" + fileName
                );
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot show report" + e);
             e.printStackTrace();
            }
        }
    }//GEN-LAST:event_inBillButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private com.toedter.calendar.JDateChooser dateJDchoose;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JButton editButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JButton inBillButton;
    private javax.swing.JLabel noPermissionLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton statictistButton;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel updateSalaryPanel;
    // End of variables declaration//GEN-END:variables
}
