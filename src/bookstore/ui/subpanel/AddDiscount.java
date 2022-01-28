/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.ui.subpanel;

import java.text.ParseException;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.BorderFactory;
import bookstore.database.tables.Discount;
import javax.swing.JOptionPane;
import bookstore.exceptions.DatabasePermissonErrorException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class AddDiscount extends javax.swing.JFrame {
    
    protected void initialize(DiscountPanel parent){
        this.parent = parent;
        this.setLocationRelativeTo(null);
        this.idTextField.setEditable(false);
        this.idTextField.setFocusable(false);
    }
    
    public AddDiscount(DiscountPanel parent) {
        this.initComponents();
        this.initialize(parent);
        this.action = 0;
    }
    
    public AddDiscount(DiscountPanel parent, Discount discount){
        this.initComponents();
        this.initialize(parent);

        this.idTextField.setText(discount.getId());
        this.nameTextField.setText(discount.getName());
        this.startDateJDchoose.setDate(discount.getStartDate());
        this.finishDateJDchoose.setDate(discount.getFinishDate());
        this.describeTextField.setText(discount.getDescribe());
        this.discountRateTextField.setText(String.valueOf(discount.getDiscountRate()));
        this.addButton.setText("Cập nhật");
        this.action = 1;
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        informationPanel = new javax.swing.JPanel();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        describeTextField = new javax.swing.JTextField();
        discountRateTextField = new javax.swing.JTextField();
        discribeLabel = new javax.swing.JLabel();
        finishDateLabel = new javax.swing.JLabel();
        discountRateLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        startDateJDchoose = new com.toedter.calendar.JDateChooser();
        finishDateJDchoose = new com.toedter.calendar.JDateChooser();
        choosePanel = new javax.swing.JPanel();
        addButton = new metro.MetroButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(200, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        cancelButton = new metro.MetroButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainPanel.setMinimumSize(new java.awt.Dimension(600, 500));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 500));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        informationPanel.setBackground(new java.awt.Color(255, 255, 255));
        informationPanel.setMaximumSize(new java.awt.Dimension(32767, 400));
        informationPanel.setMinimumSize(new java.awt.Dimension(200, 300));
        informationPanel.setName("Thêm tác giả"); // NOI18N
        informationPanel.setPreferredSize(new java.awt.Dimension(300, 300));

        idTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        idTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        idTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        idTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nameTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        nameTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        nameTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        describeTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        describeTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        describeTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        describeTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        describeTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        discountRateTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        discountRateTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        discountRateTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        discountRateTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        discountRateTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        discribeLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        discribeLabel.setText("Mô tả");
        discribeLabel.setFocusable(false);
        discribeLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        discribeLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        discribeLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        discribeLabel.setRequestFocusEnabled(false);

        finishDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        finishDateLabel.setText("Ngày kết thúc");
        finishDateLabel.setFocusable(false);
        finishDateLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        finishDateLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        finishDateLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        finishDateLabel.setRequestFocusEnabled(false);

        discountRateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        discountRateLabel.setText("Tỉ lệ khuyến mãi");
        discountRateLabel.setFocusable(false);
        discountRateLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        discountRateLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        discountRateLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        discountRateLabel.setRequestFocusEnabled(false);

        startDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        startDateLabel.setText("Ngày bắt đầu");
        startDateLabel.setFocusable(false);
        startDateLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        startDateLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        startDateLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        startDateLabel.setRequestFocusEnabled(false);

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nameLabel.setText("Tên khuyến mãi");
        nameLabel.setFocusable(false);
        nameLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        nameLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        nameLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        nameLabel.setRequestFocusEnabled(false);

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idLabel.setText("Mã khuyến mãi");
        idLabel.setFocusable(false);
        idLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        idLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        idLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        idLabel.setRequestFocusEnabled(false);

        startDateJDchoose.setDateFormatString("yyyy-MM-dd");
        startDateJDchoose.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        finishDateJDchoose.setDateFormatString("yyyy-MM-dd");
        finishDateJDchoose.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        org.jdesktop.layout.GroupLayout informationPanelLayout = new org.jdesktop.layout.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(informationPanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(discribeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(finishDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(discountRateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(startDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, 50, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(describeTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(idTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(discountRateTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(startDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(finishDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, informationPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(idTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(startDateLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(startDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(finishDateLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(finishDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(describeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(discribeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(discountRateTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(discountRateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        mainPanel.add(informationPanel);

        choosePanel.setBackground(new java.awt.Color(255, 255, 255));
        choosePanel.setMaximumSize(new java.awt.Dimension(32000, 100));
        choosePanel.setMinimumSize(new java.awt.Dimension(150, 80));
        choosePanel.setPreferredSize(new java.awt.Dimension(152, 100));

        addButton.setBackground(new java.awt.Color(0, 0, 0));
        addButton.setText("Thêm");
        addButton.setFont(new java.awt.Font("Sogoe Ui", 1, 20)); // NOI18N
        addButton.setMaximumSize(new java.awt.Dimension(200, 100));
        addButton.setMinimumSize(new java.awt.Dimension(100, 70));
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
        cancelButton.setMaximumSize(new java.awt.Dimension(200, 100));
        cancelButton.setMinimumSize(new java.awt.Dimension(100, 60));
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
        
    private Discount getDiscount(){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String id = this.idTextField.getText();
            String name = this.nameTextField.getText();
            String startdate = dateFormat.format(startDateJDchoose.getDate());
            Date ngbd = dateFormat.parse(startdate);
            java.sql.Date sqlngbd = new java.sql.Date(ngbd.getTime());
            String finishdate = dateFormat.format(finishDateJDchoose.getDate());
            Date ngkt = dateFormat.parse(finishdate);
            java.sql.Date sqlngkt = new java.sql.Date(ngkt.getTime());
            String describe = this.describeTextField.getText();
            float discountRate = Float.valueOf(this.discountRateTextField.getText());
            return new Discount(id, name, sqlngbd, sqlngkt, describe, discountRate);
        }catch(ParseException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
     private void addDiscount (Discount discount){
        if (discount.getName().isEmpty() 
            || discount.getDescribe().isEmpty()
        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if (Discount.insert(discount)){
                    JOptionPane.showMessageDialog(null, "Dữ liệu đã được thêm.", "Thêm", 1);
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

    
    private void updateDiscount (Discount discount){
        if (discount.getName().isEmpty() 
            || discount.getDescribe().isEmpty()
        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if(Discount.update(discount)){
                    JOptionPane.showMessageDialog(
                        null,
                        "Dữ liệu đã được cập nhật.",
                        "Cập nhật khuyến mãi",
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
                JOptionPane.showMessageDialog(
                    null,
                    "Bạn không có quyền sửa dữ liệu này.",
                    "Lỗi",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        try{
            Discount discount = this.getDiscount();

            if(this.action == 0){
                this.addDiscount(discount);
            }
            else if(this.action == 1){
                this.updateDiscount(discount);
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
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metro.MetroButton addButton;
    private metro.MetroButton cancelButton;
    private javax.swing.JPanel choosePanel;
    private javax.swing.JTextField describeTextField;
    private javax.swing.JLabel discountRateLabel;
    private javax.swing.JTextField discountRateTextField;
    private javax.swing.JLabel discribeLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private com.toedter.calendar.JDateChooser finishDateJDchoose;
    private javax.swing.JLabel finishDateLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private com.toedter.calendar.JDateChooser startDateJDchoose;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
    private int action;
    private DiscountPanel parent;
    
}
