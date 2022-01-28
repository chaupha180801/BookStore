/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.ui.subpanel;

/**
 *
 * @author DELL
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import java.util.ArrayList;
import java.text.ParseException;
import bookstore.database.tables.*;
import bookstore.exceptions.DatabasePermissonErrorException;

public class AddBook extends javax.swing.JFrame {

    /** Creates new form AddBook */
    public void loadCategoryComboBox(String id){
        ((JTextField)this.categoryComboBox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        ((JTextField)this.categoryComboBox.getEditor().getEditorComponent()).setEditable(false);
        
        try{
            Object categories[] = Category.selectAll().toArray();
            DefaultComboBoxModel cbm = new DefaultComboBoxModel(categories);
            if(id != null){
                Category selectedCategory = Category.findById(id);
                cbm.setSelectedItem(selectedCategory);
            }
            this.categoryComboBox.setModel(cbm);
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    
    public void loadAuthorComboBox(String id){
        ((JTextField)this.authorComboBox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        ((JTextField)this.authorComboBox.getEditor().getEditorComponent()).setEditable(false);
        
        try{
            Object authors[] = Author.selectAll().toArray();
            DefaultComboBoxModel cbm = new DefaultComboBoxModel(authors);
            if(id != null){
                Author selectedAuthor = Author.findById(id);
                cbm.setSelectedItem(selectedAuthor);
            }
            this.authorComboBox.setModel(cbm);
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    
    public void loadPublisherComboBox(String id){
        ((JTextField)this.publisherComboBox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        ((JTextField)this.publisherComboBox.getEditor().getEditorComponent()).setEditable(false);
        
        try{
            Object publishers[] = Publisher.selectAll().toArray();
            DefaultComboBoxModel cbm = new DefaultComboBoxModel(publishers);
            if(id != null){
                Publisher selectedPublisher = Publisher.findById(id);
                cbm.setSelectedItem(selectedPublisher);
            }
            this.publisherComboBox.setModel(cbm);
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    protected void initialize(BookPanel parent){
        this.parent = parent;
        this.setLocationRelativeTo(null);
        this.idTextField.setEditable(false);
        this.idTextField.setFocusable(false);
        loadAuthorComboBox(null);
        loadCategoryComboBox(null);
        loadPublisherComboBox(null);
    }
    public AddBook(BookPanel parent)  {
        initComponents();
        this.initialize(parent);
        this.action = 0;     
    }
    
    public AddBook(BookPanel parent, Book book){
        this.initComponents();
        this.initialize(parent);

        this.idTextField.setText(book.getId());
        this.nameTextField.setText(book.getName());
        this.yearPublishTextField.setText(String.valueOf(book.getPublishDate()));
        this.priceTextField.setText(String.valueOf(book.getPrice()));
        this.loadCategoryComboBox(book.getTypeId());
        this.loadPublisherComboBox(book.getPublisherId());
        this.loadAuthorComboBox(book.getAuthorId());
        this.numberOfStockTextField.setText(String.valueOf(book.getNumberOfStock()));
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
        idCategoryLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        idPublisherLabel = new javax.swing.JLabel();
        yearPublishLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idAuthorLabel = new javax.swing.JLabel();
        numberofStockLabel = new javax.swing.JLabel();
        numberOfStockTextField = new javax.swing.JTextField();
        categoryComboBox = new javax.swing.JComboBox<>();
        publisherComboBox = new javax.swing.JComboBox<>();
        authorComboBox = new javax.swing.JComboBox<>();
        priceTextField = new javax.swing.JTextField();
        yearPublishTextField = new javax.swing.JTextField();
        choosePanel = new javax.swing.JPanel();
        addButton = new metro.MetroButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(200, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        cancelButton = new metro.MetroButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainPanel.setMinimumSize(new java.awt.Dimension(600, 500));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        informationPanel.setBackground(new java.awt.Color(255, 255, 255));
        informationPanel.setMaximumSize(new java.awt.Dimension(32767, 600));
        informationPanel.setMinimumSize(new java.awt.Dimension(200, 400));
        informationPanel.setName("Thêm tác giả"); // NOI18N
        informationPanel.setPreferredSize(new java.awt.Dimension(420, 550));

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

        idCategoryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idCategoryLabel.setText("Mã thể loại");
        idCategoryLabel.setFocusable(false);
        idCategoryLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        idCategoryLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        idCategoryLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        idCategoryLabel.setRequestFocusEnabled(false);

        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceLabel.setText("Giá bìa");
        priceLabel.setFocusable(false);
        priceLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        priceLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        priceLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        priceLabel.setRequestFocusEnabled(false);

        idPublisherLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idPublisherLabel.setText("Mã nhà xuất bản");
        idPublisherLabel.setFocusable(false);
        idPublisherLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        idPublisherLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        idPublisherLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        idPublisherLabel.setRequestFocusEnabled(false);

        yearPublishLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        yearPublishLabel.setText("Năm xuất bản");
        yearPublishLabel.setFocusable(false);
        yearPublishLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        yearPublishLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        yearPublishLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        yearPublishLabel.setRequestFocusEnabled(false);

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nameLabel.setText("Tên sách");
        nameLabel.setFocusable(false);
        nameLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        nameLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        nameLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        nameLabel.setRequestFocusEnabled(false);

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idLabel.setText("Mã sách");
        idLabel.setFocusable(false);
        idLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        idLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        idLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        idLabel.setRequestFocusEnabled(false);

        idAuthorLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idAuthorLabel.setText("Mã tác giả");
        idAuthorLabel.setFocusable(false);
        idAuthorLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        idAuthorLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        idAuthorLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        idAuthorLabel.setRequestFocusEnabled(false);

        numberofStockLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        numberofStockLabel.setText("Số lượng tồn");
        numberofStockLabel.setFocusable(false);
        numberofStockLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        numberofStockLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        numberofStockLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        numberofStockLabel.setRequestFocusEnabled(false);

        numberOfStockTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        numberOfStockTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        numberOfStockTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        numberOfStockTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        numberOfStockTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        categoryComboBox.setEditable(true);
        categoryComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TL001", "Loại 2", "Loại 3" }));
        categoryComboBox.setMaximumSize(new java.awt.Dimension(32767, 40));
        categoryComboBox.setMinimumSize(new java.awt.Dimension(58, 40));
        categoryComboBox.setPreferredSize(new java.awt.Dimension(58, 40));

        publisherComboBox.setEditable(true);
        publisherComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        publisherComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        publisherComboBox.setMaximumSize(new java.awt.Dimension(32767, 40));
        publisherComboBox.setMinimumSize(new java.awt.Dimension(58, 40));
        publisherComboBox.setPreferredSize(new java.awt.Dimension(58, 40));

        authorComboBox.setEditable(true);
        authorComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        authorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        priceTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        yearPublishTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        org.jdesktop.layout.GroupLayout informationPanelLayout = new org.jdesktop.layout.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(informationPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(numberofStockLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(idAuthorLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(idCategoryLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(priceLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(idPublisherLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(yearPublishLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, 48, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(idTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(numberOfStockTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(categoryComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(publisherComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(authorComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(priceTextField)
                    .add(yearPublishTextField))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, informationPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(idTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(yearPublishLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(yearPublishTextField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(priceLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(priceTextField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(idCategoryLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(categoryComboBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(15, 15, 15)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(idPublisherLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(informationPanelLayout.createSequentialGroup()
                        .add(3, 3, 3)
                        .add(publisherComboBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(idAuthorLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(authorComboBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(numberofStockLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(numberOfStockTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 38, Short.MAX_VALUE))
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

    private Book getBook(){
        String id = this.idTextField.getText();
        String name = this.nameTextField.getText();
        int publishDate = Integer.valueOf(this.yearPublishTextField.getText());
        int price = Integer.valueOf(this.priceTextField.getText());
        Category category = (Category)this.categoryComboBox.getSelectedItem();
        Publisher publisher = (Publisher)this.publisherComboBox.getSelectedItem();
        Author author = (Author)this.authorComboBox.getSelectedItem();
        int numberOfStock = Integer.valueOf(this.numberOfStockTextField.getText());
        return new Book(id, name, publishDate, price, category.getId(),
                        publisher.getId(), author.getId(), numberOfStock);  
    }
    
    private void addBook(Book book){
        if (book.getName().isEmpty() 
            || String.valueOf(book.getPrice()).isEmpty()
            || String.valueOf(book.getNumberOfStock()).isEmpty()
        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if (Book.insert(book)){
                    JOptionPane.showMessageDialog(null, "Dữ liệu đã được thêm.", "Thêm sách", 1);
                    this.parent.reloadTable();
                }
                else 
                    JOptionPane.showMessageDialog(null, "Dữ liệu không được thêm.", "Lỗi thêm nhân viên", 1);
            }catch(DatabasePermissonErrorException ex){
                    JOptionPane.showMessageDialog(null,
                        "Bạn không có quyền thêm dữ liệu này.",
                        "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    
    private void updateBook(Book book){
        if (book.getName().isEmpty() 
            || String.valueOf(book.getPrice()).isEmpty()
            || String.valueOf(book.getNumberOfStock()).isEmpty()
        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if(Book.update(book)){
                    JOptionPane.showMessageDialog(
                        null,
                        "Dữ liệu đã được cập nhật.",
                        "Cập nhật sách",
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
            Book book = this.getBook();

            if(this.action == 0){
                this.addBook(book);
            }
            else if(this.action == 1){
                this.updateBook(book);
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
    private javax.swing.JComboBox<String> authorComboBox;
    private metro.MetroButton cancelButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JPanel choosePanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel idAuthorLabel;
    private javax.swing.JLabel idCategoryLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idPublisherLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField numberOfStockTextField;
    private javax.swing.JLabel numberofStockLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JComboBox<String> publisherComboBox;
    private javax.swing.JLabel yearPublishLabel;
    private javax.swing.JTextField yearPublishTextField;
    // End of variables declaration//GEN-END:variables
    private int action;
    private BookPanel parent;
}

