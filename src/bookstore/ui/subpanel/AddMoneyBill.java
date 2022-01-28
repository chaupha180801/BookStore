/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.ui.subpanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import java.util.ArrayList;
import java.text.ParseException;
import bookstore.database.tables.*;
import bookstore.exceptions.DatabasePermissonErrorException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class AddMoneyBill extends javax.swing.JFrame {

    public void loadCustomerComboBox(String id){
        ((JTextField)this.customerIdComboBox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        ((JTextField)this.customerIdComboBox.getEditor().getEditorComponent()).setEditable(false);
        
        try{
            Object customers[] = Customer.selectAll().toArray();
            DefaultComboBoxModel cbm = new DefaultComboBoxModel(customers);
            if(id != null){
                Customer selectedCustomer = Customer.findById(id);
                cbm.setSelectedItem(selectedCustomer);
            }
            this.customerIdComboBox.setModel(cbm);
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    
    protected void initialize(MoneyBillPanel parent){
        this.parent = parent;
        this.setLocationRelativeTo(null);
        this.idTextField.setEditable(false);
        this.idTextField.setFocusable(false);
        loadCustomerComboBox(null);
    }
    public AddMoneyBill(MoneyBillPanel parent)  {
        initComponents();
        this.initialize(parent);
        this.action = 0;     
    }
    
    public AddMoneyBill(MoneyBillPanel parent, MoneyBill bill){
        this.initComponents();
        this.initialize(parent);
        this.idTextField.setText(bill.getId());
        this.loadCustomerComboBox(bill.getCustomerId());
        this.billDateJDchoose.setDate(bill.getBillDate());
        this.moneyTextField.setText(String.valueOf(bill.getMoney()));
        this.addButton.setText("Cập nhật");
        this.action = 1;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        informationPanel = new javax.swing.JPanel();
        idTextField = new javax.swing.JTextField();
        billDateLabel = new javax.swing.JLabel();
        customerIdLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        customerIdComboBox = new javax.swing.JComboBox<>();
        moneyTextField = new javax.swing.JTextField();
        billDateJDchoose = new com.toedter.calendar.JDateChooser();
        choosePanel = new javax.swing.JPanel();
        addButton = new metro.MetroButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(200, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        cancelButton = new metro.MetroButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(32000, 32000));
        setMinimumSize(new java.awt.Dimension(650, 550));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(650, 550));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainPanel.setMinimumSize(new java.awt.Dimension(500, 500));
        mainPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        informationPanel.setBackground(new java.awt.Color(255, 255, 255));
        informationPanel.setMaximumSize(new java.awt.Dimension(32767, 600));
        informationPanel.setMinimumSize(new java.awt.Dimension(200, 150));
        informationPanel.setName("Thêm tác giả"); // NOI18N
        informationPanel.setPreferredSize(new java.awt.Dimension(650, 250));

        idTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        idTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        idTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        idTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        billDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        billDateLabel.setText("Ngày thu tiền");
        billDateLabel.setFocusable(false);
        billDateLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        billDateLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        billDateLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        billDateLabel.setRequestFocusEnabled(false);

        customerIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        customerIdLabel.setText("Mã khách hàng");
        customerIdLabel.setFocusable(false);
        customerIdLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        customerIdLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        customerIdLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        customerIdLabel.setRequestFocusEnabled(false);

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idLabel.setText("Mã phiếu thu");
        idLabel.setFocusable(false);
        idLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        idLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        idLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        idLabel.setRequestFocusEnabled(false);

        moneyLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        moneyLabel.setText("Số tiền thu");
        moneyLabel.setFocusable(false);
        moneyLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        moneyLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        moneyLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        moneyLabel.setRequestFocusEnabled(false);

        customerIdComboBox.setEditable(true);
        customerIdComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        customerIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TL001", "Loại 2", "Loại 3" }));
        customerIdComboBox.setMaximumSize(new java.awt.Dimension(150, 40));
        customerIdComboBox.setMinimumSize(new java.awt.Dimension(100, 40));
        customerIdComboBox.setPreferredSize(new java.awt.Dimension(150, 40));

        moneyTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        moneyTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        moneyTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        moneyTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        moneyTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        billDateJDchoose.setDateFormatString("yyyy-MM-dd");
        billDateJDchoose.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        org.jdesktop.layout.GroupLayout informationPanelLayout = new org.jdesktop.layout.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(informationPanelLayout.createSequentialGroup()
                .add(31, 31, 31)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, moneyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, customerIdLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, billDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(customerIdComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(idTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .add(billDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(moneyTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, informationPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, idTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(customerIdLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(customerIdComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(billDateLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(billDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(moneyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(moneyTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(informationPanel);

        choosePanel.setBackground(new java.awt.Color(255, 255, 255));
        choosePanel.setMaximumSize(new java.awt.Dimension(32000, 100));
        choosePanel.setMinimumSize(new java.awt.Dimension(150, 80));
        choosePanel.setPreferredSize(new java.awt.Dimension(152, 100));

        addButton.setBackground(new java.awt.Color(0, 0, 0));
        addButton.setText("Thêm");
        addButton.setFont(new java.awt.Font("Sogoe Ui", 1, 20)); // NOI18N
        addButton.setMaximumSize(new java.awt.Dimension(200, 80));
        addButton.setMinimumSize(new java.awt.Dimension(100, 50));
        addButton.setPreferredSize(new java.awt.Dimension(120, 50));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        choosePanel.add(addButton);
        choosePanel.add(filler1);
        choosePanel.add(filler2);

        cancelButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelButton.setText("Hủy bỏ");
        cancelButton.setFont(new java.awt.Font("Sogoe Ui", 1, 20)); // NOI18N
        cancelButton.setMaximumSize(new java.awt.Dimension(200, 80));
        cancelButton.setMinimumSize(new java.awt.Dimension(100, 50));
        cancelButton.setPreferredSize(new java.awt.Dimension(120, 50));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        choosePanel.add(cancelButton);

        mainPanel.add(choosePanel);

        getContentPane().add(mainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private MoneyBill getMoneyBill(){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String id = this.idTextField.getText();
            Customer customer = (Customer)this.customerIdComboBox.getSelectedItem();
            String billdate = dateFormat.format(billDateJDchoose.getDate());
            Date ngaythutien = dateFormat.parse(billdate);
            java.sql.Date sqlngtt = new java.sql.Date(ngaythutien.getTime());
            int money = Integer.valueOf(this.moneyTextField.getText());
   
            return new MoneyBill(id, customer.getId(), sqlngtt, money);
        }catch(ParseException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    private void addMoneyBill(MoneyBill bill){
        if (bill.getCustomerId().isEmpty() 
            || String.valueOf(bill.getMoney()).isEmpty()
            //|| String.valueOf(bill.getBillDate()).isEmpry()

        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if (MoneyBill.insert(bill)){
                    JOptionPane.showMessageDialog(null, "Dữ liệu đã được thêm.", "Thêm phiếu thu tiền", 1);
                    this.parent.reloadTable();
                }
                else 
                    JOptionPane.showMessageDialog(null, "Dữ liệu không được thêm.", "Lỗi", 1);
            }catch(DatabasePermissonErrorException ex){
                    JOptionPane.showMessageDialog(null,
                        "Bạn không có quyền thêm dữ liệu này.",
                        "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    
    private void updateMoneyBill(MoneyBill bill){
        if (bill.getCustomerId().isEmpty() 
            || String.valueOf(bill.getMoney()).isEmpty()
            //|| String.valueOf(bill.getBillDate()).isEmpry()
        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if(MoneyBill.update(bill)){
                    JOptionPane.showMessageDialog(
                        null,
                        "Dữ liệu đã được cập nhật.",
                        "Cập nhật phiếu thu tiền",
                        1
                    );
                    this.parent.reloadTable();
                }
                else{
                    JOptionPane.showMessageDialog(
                        null,
                        "Dữ liệu không cập nhật được",
                        "Lỗi cập nhật",
                        1
                    );
                }
            }catch(DatabasePermissonErrorException ex){
                    JOptionPane.showMessageDialog(null,
                    "Bạn không có quyền sửa dữ liệu này.",
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        try{
            MoneyBill bill = this.getMoneyBill();

            if(this.action == 0){
                this.addMoneyBill(bill);
            }
            else if(this.action == 1){
                this.updateMoneyBill(bill);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(
                null,
                "Có lỗi xảy ra:" + e.getMessage(),
                "Thông báo.",
                1
            );
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metro.MetroButton addButton;
    private com.toedter.calendar.JDateChooser billDateJDchoose;
    private javax.swing.JLabel billDateLabel;
    private metro.MetroButton cancelButton;
    private javax.swing.JPanel choosePanel;
    private javax.swing.JComboBox<String> customerIdComboBox;
    private javax.swing.JLabel customerIdLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JTextField moneyTextField;
    // End of variables declaration//GEN-END:variables
    private int action;
    private MoneyBillPanel parent;
}
