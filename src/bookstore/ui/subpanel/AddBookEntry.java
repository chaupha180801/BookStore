/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.ui.subpanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.text.ParseException;
import bookstore.database.tables.*;

import bookstore.App;
import bookstore.utils.Formatter;
import bookstore.exceptions.*;
import java.util.Date;
import javax.swing.JFrame;
import java.text.SimpleDateFormat;
import bookstore.ui.subpanel.BookEntryPanel;
import javax.swing.table.DefaultTableModel;
import bookstore.exceptions.DatabasePermissonErrorException;
import javax.swing.table.JTableHeader;

public class AddBookEntry extends javax.swing.JFrame {
    

     public AddBookEntry(BookEntryPanel parent, BookEntry bookEntry) {
        this.parent = parent;
        this.initialize(bookEntry);
      
    }

    public void initialize(BookEntry bookEntry){
        this.bookEntry = bookEntry;
        
        this.initComponents();
        
        this.deleteButton.setVisible(false);
     
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(0,204,102));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setPreferredSize(new Dimension(60, 40));
        table.setRowHeight(40);
        table.setSelectionBackground(Color.black);
     
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JFrame main = this;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                main.dispose();
            }
        });
        
        this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                tableMouseClicked();
            }
        });
        
        this.setupComboBox();
        this.renderBookEntry();
        this.reloadTable();
    }


    public void renderTable(ArrayList<DetailBookEntry> detailBookEntries){
        String[] columnName = {"Mã sách", "Tên sách", "Nhà xuất bản", "Giá bán",
        "Số lượng ", "Giá nhập", "Tổng"};
        
        Object[][] rows = new Object[detailBookEntries.size()][7];
        try{
            for(int i = 0; i < detailBookEntries.size(); i ++){
                if (detailBookEntries.get(i) == null){
                    continue;
                }

                Book book = Book.findById(detailBookEntries.get(i).getBookId());
                rows[i][0] = book.getId();
                rows[i][1] = book.getName();
                rows[i][2] = Formatter.int2Price(book.getPrice());
                Publisher publisher = Publisher.findById(book.getPublisherId());
                rows[i][3] = publisher.getName();
                rows[i][4] = detailBookEntries.get(i).getAmount();
                rows[i][5] = Formatter.int2Price(detailBookEntries.get(i).getPrice());
                rows[i][6] = Formatter.int2Price(
                                detailBookEntries.get(i).getAmount() * detailBookEntries.get(i).getPrice()
                            );
               
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        DefaultTableModel model = new DefaultTableModel(rows, columnName);
        this.table.setModel(model);
    }
    
     public void reloadTable(){
        if (this.bookEntry == null)
            return;
        
        try{
            ArrayList<DetailBookEntry> detailBookEntries = DetailBookEntry.selectAll(this.bookEntry.getId());
            detailBookEntries.add(null);
            this.renderTable(detailBookEntries);

            this.updateStatisticPanel();
        }catch(DatabasePermissonErrorException ex){
            JOptionPane.showMessageDialog(null,
                "Bạn không có quyền tìm kiếm dữ liệu này.",
                "Lỗi", 1);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerPanel = new javax.swing.JPanel();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        bookEntryLabel = new javax.swing.JLabel();
        filler28 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        bookEntryTextField = new javax.swing.JTextField();
        filler29 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        bookEntryDateLabel = new javax.swing.JLabel();
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        bookEntryDateTextField = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        allTotalPriceLabel = new javax.swing.JLabel();
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        allTotalPriceValueLabel = new javax.swing.JLabel();
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        interactionPanel = new javax.swing.JPanel();
        bookChooserPanel = new javax.swing.JPanel();
        bookInfoPanel = new javax.swing.JPanel();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 10), new java.awt.Dimension(50, 10), new java.awt.Dimension(50, 32767));
        bookPanel = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
        bookLabel = new javax.swing.JLabel();
        bookComboBox = new javax.swing.JComboBox<>();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 32767));
        publisherPanel = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
        publisherLabel = new javax.swing.JLabel();
        publisherTextField = new javax.swing.JTextField();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 32767));
        priceSalePanel = new javax.swing.JPanel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
        priceSaleLabel = new javax.swing.JLabel();
        priceSaleTextField = new javax.swing.JTextField();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 32767));
        pricePanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
        priceLabel = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 15), new java.awt.Dimension(50, 32767));
        amountPanel = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
        amountLabel = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(30, 15));
        actionPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        deleteButton = new javax.swing.JButton();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        scrollPanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 642));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        customerPanel.setBackground(new java.awt.Color(0, 51, 51));
        customerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        customerPanel.setMaximumSize(new java.awt.Dimension(32000, 100));
        customerPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        customerPanel.setPreferredSize(new java.awt.Dimension(10, 100));
        customerPanel.setLayout(new javax.swing.BoxLayout(customerPanel, javax.swing.BoxLayout.LINE_AXIS));
        customerPanel.add(filler18);

        bookEntryLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bookEntryLabel.setForeground(new java.awt.Color(255, 255, 255));
        bookEntryLabel.setText("Mã phiếu nhập");
        bookEntryLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        bookEntryLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        bookEntryLabel.setPreferredSize(new java.awt.Dimension(130, 60));
        customerPanel.add(bookEntryLabel);
        customerPanel.add(filler28);

        bookEntryTextField.setEditable(false);
        bookEntryTextField.setBackground(new java.awt.Color(0, 51, 51));
        bookEntryTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookEntryTextField.setForeground(new java.awt.Color(255, 255, 255));
        bookEntryTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookEntryTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        bookEntryTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        bookEntryTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(bookEntryTextField);
        customerPanel.add(filler29);

        bookEntryDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bookEntryDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        bookEntryDateLabel.setText("Ngày tạo");
        bookEntryDateLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        bookEntryDateLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        bookEntryDateLabel.setPreferredSize(new java.awt.Dimension(80, 50));
        customerPanel.add(bookEntryDateLabel);
        customerPanel.add(filler30);

        bookEntryDateTextField.setEditable(false);
        bookEntryDateTextField.setBackground(new java.awt.Color(0, 51, 51));
        bookEntryDateTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookEntryDateTextField.setForeground(new java.awt.Color(255, 255, 255));
        bookEntryDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookEntryDateTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        bookEntryDateTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        bookEntryDateTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(bookEntryDateTextField);
        customerPanel.add(filler1);

        allTotalPriceLabel.setBackground(new java.awt.Color(255, 255, 255));
        allTotalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        allTotalPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        allTotalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allTotalPriceLabel.setText("Tổng cộng:");
        allTotalPriceLabel.setToolTipText("");
        allTotalPriceLabel.setAlignmentX(0.5F);
        allTotalPriceLabel.setMaximumSize(new java.awt.Dimension(200, 50));
        allTotalPriceLabel.setMinimumSize(new java.awt.Dimension(100, 0));
        allTotalPriceLabel.setPreferredSize(new java.awt.Dimension(200, 50));
        customerPanel.add(allTotalPriceLabel);
        customerPanel.add(filler26);

        allTotalPriceValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        allTotalPriceValueLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        allTotalPriceValueLabel.setForeground(new java.awt.Color(255, 255, 255));
        allTotalPriceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        allTotalPriceValueLabel.setText("0đ");
        allTotalPriceValueLabel.setAlignmentX(0.5F);
        allTotalPriceValueLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        allTotalPriceValueLabel.setMaximumSize(new java.awt.Dimension(32000, 35));
        allTotalPriceValueLabel.setMinimumSize(new java.awt.Dimension(29, 10));
        allTotalPriceValueLabel.setPreferredSize(new java.awt.Dimension(200, 35));
        customerPanel.add(allTotalPriceValueLabel);
        customerPanel.add(filler21);
        customerPanel.add(filler23);

        getContentPane().add(customerPanel);

        interactionPanel.setBackground(new java.awt.Color(255, 255, 255));
        interactionPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        interactionPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        interactionPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        interactionPanel.setLayout(new javax.swing.BoxLayout(interactionPanel, javax.swing.BoxLayout.LINE_AXIS));

        bookChooserPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookChooserPanel.setMaximumSize(new java.awt.Dimension(32000, 400));
        bookChooserPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        bookInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookInfoPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        bookInfoPanel.setPreferredSize(new java.awt.Dimension(605, 500));
        bookInfoPanel.setLayout(new javax.swing.BoxLayout(bookInfoPanel, javax.swing.BoxLayout.PAGE_AXIS));
        bookInfoPanel.add(filler12);

        bookPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookPanel.setMaximumSize(new java.awt.Dimension(32000, 180));
        bookPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        bookPanel.setPreferredSize(new java.awt.Dimension(32000, 180));
        bookPanel.setLayout(new javax.swing.BoxLayout(bookPanel, javax.swing.BoxLayout.LINE_AXIS));
        bookPanel.add(filler5);

        bookLabel.setBackground(new java.awt.Color(255, 255, 255));
        bookLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookLabel.setText("Sách");
        bookLabel.setFocusable(false);
        bookLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bookLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        bookLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        bookPanel.add(bookLabel);

        bookComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bookComboBox.setMaximumSize(new java.awt.Dimension(32000, 35));
        bookComboBox.setMinimumSize(new java.awt.Dimension(0, 0));
        bookComboBox.setPreferredSize(new java.awt.Dimension(300, 35));
        bookComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookComboBoxActionPerformed(evt);
            }
        });
        bookPanel.add(bookComboBox);

        bookInfoPanel.add(bookPanel);
        bookInfoPanel.add(filler9);

        publisherPanel.setBackground(new java.awt.Color(255, 255, 255));
        publisherPanel.setMaximumSize(new java.awt.Dimension(32000, 180));
        publisherPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        publisherPanel.setPreferredSize(new java.awt.Dimension(32000, 180));
        publisherPanel.setLayout(new javax.swing.BoxLayout(publisherPanel, javax.swing.BoxLayout.LINE_AXIS));
        publisherPanel.add(filler2);

        publisherLabel.setBackground(new java.awt.Color(255, 255, 255));
        publisherLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        publisherLabel.setText("Nhà xuất bản");
        publisherLabel.setFocusable(false);
        publisherLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        publisherLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        publisherLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        publisherPanel.add(publisherLabel);

        publisherTextField.setEditable(false);
        publisherTextField.setBackground(new java.awt.Color(255, 255, 255));
        publisherTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        publisherTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        publisherTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        publisherTextField.setPreferredSize(new java.awt.Dimension(300, 35));
        publisherPanel.add(publisherTextField);

        bookInfoPanel.add(publisherPanel);
        bookInfoPanel.add(filler11);

        priceSalePanel.setBackground(new java.awt.Color(255, 255, 255));
        priceSalePanel.setMaximumSize(new java.awt.Dimension(32000, 180));
        priceSalePanel.setMinimumSize(new java.awt.Dimension(0, 0));
        priceSalePanel.setPreferredSize(new java.awt.Dimension(32000, 180));
        priceSalePanel.setLayout(new javax.swing.BoxLayout(priceSalePanel, javax.swing.BoxLayout.LINE_AXIS));
        priceSalePanel.add(filler7);

        priceSaleLabel.setBackground(new java.awt.Color(255, 255, 255));
        priceSaleLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceSaleLabel.setText("Giá bán");
        priceSaleLabel.setFocusable(false);
        priceSaleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        priceSaleLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        priceSaleLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        priceSalePanel.add(priceSaleLabel);

        priceSaleTextField.setEditable(false);
        priceSaleTextField.setBackground(new java.awt.Color(255, 255, 255));
        priceSaleTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceSaleTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        priceSaleTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        priceSaleTextField.setPreferredSize(new java.awt.Dimension(300, 35));
        priceSalePanel.add(priceSaleTextField);

        bookInfoPanel.add(priceSalePanel);
        bookInfoPanel.add(filler14);

        pricePanel.setBackground(new java.awt.Color(255, 255, 255));
        pricePanel.setMaximumSize(new java.awt.Dimension(32000, 180));
        pricePanel.setMinimumSize(new java.awt.Dimension(0, 0));
        pricePanel.setPreferredSize(new java.awt.Dimension(32000, 180));
        pricePanel.setLayout(new javax.swing.BoxLayout(pricePanel, javax.swing.BoxLayout.LINE_AXIS));
        pricePanel.add(filler3);

        priceLabel.setBackground(new java.awt.Color(255, 255, 255));
        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceLabel.setText("Giá nhập");
        priceLabel.setFocusable(false);
        priceLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        priceLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        priceLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        pricePanel.add(priceLabel);

        priceTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        priceTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        priceTextField.setPreferredSize(new java.awt.Dimension(300, 35));
        pricePanel.add(priceTextField);

        bookInfoPanel.add(pricePanel);
        bookInfoPanel.add(filler13);

        amountPanel.setBackground(new java.awt.Color(255, 255, 255));
        amountPanel.setMaximumSize(new java.awt.Dimension(32000, 180));
        amountPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        amountPanel.setPreferredSize(new java.awt.Dimension(110, 180));
        amountPanel.setLayout(new javax.swing.BoxLayout(amountPanel, javax.swing.BoxLayout.LINE_AXIS));
        amountPanel.add(filler4);

        amountLabel.setBackground(new java.awt.Color(255, 255, 255));
        amountLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        amountLabel.setText("Số lượng");
        amountLabel.setFocusable(false);
        amountLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        amountLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        amountLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        amountPanel.add(amountLabel);

        amountTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        amountTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        amountTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        amountTextField.setPreferredSize(new java.awt.Dimension(300, 35));
        amountPanel.add(amountTextField);

        bookInfoPanel.add(amountPanel);
        bookInfoPanel.add(filler19);

        actionPanel.setBackground(new java.awt.Color(255, 255, 255));
        actionPanel.setLayout(new javax.swing.BoxLayout(actionPanel, javax.swing.BoxLayout.LINE_AXIS));

        addButton.setBackground(new java.awt.Color(0, 0, 0));
        addButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Thêm sách");
        addButton.setFocusPainted(false);
        addButton.setMaximumSize(new java.awt.Dimension(150, 50));
        addButton.setMinimumSize(new java.awt.Dimension(100, 30));
        addButton.setPreferredSize(new java.awt.Dimension(150, 50));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        actionPanel.add(addButton);
        actionPanel.add(filler8);

        deleteButton.setBackground(new java.awt.Color(0, 0, 0));
        deleteButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa sách");
        deleteButton.setFocusPainted(false);
        deleteButton.setMaximumSize(new java.awt.Dimension(150, 50));
        deleteButton.setMinimumSize(new java.awt.Dimension(100, 30));
        deleteButton.setPreferredSize(new java.awt.Dimension(150, 50));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        actionPanel.add(deleteButton);

        org.jdesktop.layout.GroupLayout bookChooserPanelLayout = new org.jdesktop.layout.GroupLayout(bookChooserPanel);
        bookChooserPanel.setLayout(bookChooserPanelLayout);
        bookChooserPanelLayout.setHorizontalGroup(
            bookChooserPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bookChooserPanelLayout.createSequentialGroup()
                .add(bookChooserPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(filler10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 582, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(bookChooserPanelLayout.createSequentialGroup()
                        .add(120, 120, 120)
                        .add(actionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(filler15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 582, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(bookInfoPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 590, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(158, 158, 158))
        );
        bookChooserPanelLayout.setVerticalGroup(
            bookChooserPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bookChooserPanelLayout.createSequentialGroup()
                .add(bookInfoPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 246, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(filler10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(actionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(filler15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        interactionPanel.add(bookChooserPanel);
        interactionPanel.add(filler6);

        getContentPane().add(interactionPanel);

        scrollPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        scrollPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        scrollPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        table.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Nhà xuất bản", "Số lương", "Đơn giá", "Tổng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionForeground(new java.awt.Color(255, 204, 255));
        scrollPanel.setViewportView(table);

        getContentPane().add(scrollPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try{
            Book book = (Book)this.bookComboBox.getSelectedItem();

            String bookId = book.getId();

            Integer amount = null;
            Integer price = null;
            try{
                amount = Integer.valueOf(this.amountTextField.getText());
                price = Integer.valueOf(this.priceTextField.getText());
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Số lượng không phù hợp. " + e.getMessage(), "Lỗi", 1);
                return;
            }

            if (amount <= 0){
                JOptionPane.showMessageDialog(null, "Số lượng không phù hợp", "Lỗi", 1);
                return;
            }
            

            int row = this.table.getSelectedRow();
            DetailBookEntry detailBookEntry;

            if (row == -1 || row == this.table.getRowCount() - 1){
                detailBookEntry = DetailBookEntry.insert(this.bookEntry.getId(), bookId, amount, price);
            }
            else{
                String oldBookId = (String)this.table.getValueAt(row, 0);
                Integer oldAmount = Integer.valueOf(this.table.getValueAt(row, 4).toString());
                Integer oldPrice = Formatter.price2Int(this.table.getValueAt(row, 5).toString());
                DetailBookEntry old = new DetailBookEntry(
                        oldBookId,
                        this.bookEntry.getId(), 
                        oldAmount, 
                        oldPrice
                );

                detailBookEntry = new DetailBookEntry(bookId, this.bookEntry.getId(), amount, price);
                DetailBookEntry.update(old, detailBookEntry);
            }

            this.bookEntry = BookEntry.findById(this.bookEntry.getId());
            this.reloadTable();
            this.renderBookEntry();

            if (row == -1 || row == this.table.getRowCount() - 2){
                row = this.table.getRowCount() - 2;
                this.table.setRowSelectionInterval(row + 1, row + 1);
            }

            this.updateStatisticPanel();
            this.parent.reloadTable();
        }
        catch(BookEntryException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", 1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());            
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = this.table.getSelectedRow();

        if (row == -1 || row == this.table.getSelectedRow() - 1)
        return;

        String bookId = (String)this.table.getValueAt(row, 0);

        try{
            DetailBookEntry.delete(this.bookEntry.getId(), bookId);
            this.bookEntry = BookEntry.findById(this.bookEntry.getId());
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa. " + e, "Phiếu nhập sách", 1);
        }

        this.reloadTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void bookComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookComboBoxActionPerformed
        this.loadBookInformation();
    }//GEN-LAST:event_bookComboBoxActionPerformed
    
     private void tableMouseClicked(){
        try{
            int row = this.table.getSelectedRow();

            if (row < this.table.getRowCount() - 1){
                this.addButton.setText("Cập nhật");
                this.deleteButton.setVisible(true);
                this.bookComboBox.setEditable(false);
                this.bookComboBox.setEnabled(false);
                this.bookComboBox.setForeground(Color.BLACK);
                
                String bookId = (String) this.table.getValueAt(row, 0);
                String priceSale  = (String) this.table.getValueAt(row, 2);
                Integer amount = (Integer) this.table.getValueAt(row, 4);
                String price  = (String) this.table.getValueAt(row, 5);
                
                this.bookComboBox.getModel().setSelectedItem(Book.findById(bookId));
                this.loadBookInformation();
                this.priceSaleTextField.setText(String.valueOf(Formatter.price2Int(priceSale)));
                this.priceTextField.setText(String.valueOf(Formatter.price2Int(price)));
                
                this.amountTextField.setText(String.valueOf(amount));
            }
            else{
                this.addButton.setText("Thêm sách");
                this.deleteButton.setVisible(false);
                this.bookComboBox.setEditable(true);
                this.bookComboBox.setEnabled(true);
                
                this.bookComboBox.setSelectedIndex(0);
                this.loadBookInformation();
                this.amountTextField.setText(null);
                this.priceTextField.setText(null);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
     
    public void updateStatisticPanel(){
        Integer totalPrice = this.bookEntry.getTotalPrice();              
        this.allTotalPriceValueLabel.setText(Formatter.int2Price(totalPrice));
    }
    
    public void renderBookEntry(){
        try{
            
            if (this.bookEntry == null)
                return;

            if (this.bookEntry.getId() != null){
                this.bookEntryTextField.setText(bookEntry.getId().toString());
            }
            this.bookEntryTextField.setText(bookEntry.getId().toString());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.bookEntryDateTextField.setText(dateFormat.format(bookEntry.getDate()));

            this.updateStatisticPanel();
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    public void setupComboBox(){
        try{
            Object books[] = Book.selectAll().toArray();
            DefaultComboBoxModel bookCbm = new DefaultComboBoxModel(books);
            this.bookComboBox.setModel(bookCbm);
            this.loadBookInformation();
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    
    public void loadBookInformation(){
        Book selectedBook = (Book) this.bookComboBox.getSelectedItem();
        
        String publisherId = selectedBook.getPublisherId();
        try{
            Publisher publisher = Publisher.findById(publisherId);
            this.publisherTextField.setText(publisher.getName());
            this.priceSaleTextField.setText(Formatter.int2Price(selectedBook.getPrice()));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel allTotalPriceLabel;
    private javax.swing.JLabel allTotalPriceValueLabel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JPanel amountPanel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JPanel bookChooserPanel;
    private javax.swing.JComboBox<String> bookComboBox;
    private javax.swing.JLabel bookEntryDateLabel;
    private javax.swing.JTextField bookEntryDateTextField;
    private javax.swing.JLabel bookEntryLabel;
    private javax.swing.JTextField bookEntryTextField;
    private javax.swing.JPanel bookInfoPanel;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler23;
    private javax.swing.Box.Filler filler26;
    private javax.swing.Box.Filler filler28;
    private javax.swing.Box.Filler filler29;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler30;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel interactionPanel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel pricePanel;
    private javax.swing.JLabel priceSaleLabel;
    private javax.swing.JPanel priceSalePanel;
    private javax.swing.JTextField priceSaleTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JPanel publisherPanel;
    private javax.swing.JTextField publisherTextField;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private BookEntryPanel parent;
    private BookEntry bookEntry;
}
