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
import bookstore.ui.subpanel.BillPanel;
import javax.swing.table.DefaultTableModel;
import bookstore.exceptions.DatabasePermissonErrorException;
import javax.swing.table.JTableHeader;

public class AddBill extends javax.swing.JFrame {    
    public AddBill(BillPanel parent, Bill bill){
        this.parent = parent;
        this.initialize(bill);
    }
    
    public void initialize(Bill bill){
        this.bill = bill;
        
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
        this.renderBill();
        this.reloadTable();
    }

    public void renderTable(ArrayList<DetailedBill> detailedBills){
        String[] columnName = {"Mã sách", "Tên sách", "Nhà xuất bản",
        "Số lượng ", "Đơn giá", "Tổng"};
        
        Object[][] rows = new Object[detailedBills.size()][6];
        try{
            for(int i = 0; i < detailedBills.size(); i ++){
                if (detailedBills.get(i) == null){
                    continue;
                }

                Book book = Book.findById(detailedBills.get(i).getBookId());
                rows[i][0] = book.getId();
                rows[i][1] = book.getName();
                Publisher publisher = Publisher.findById(book.getPublisherId());
                rows[i][2] = publisher.getName();
                rows[i][3] = String.valueOf(detailedBills.get(i).getAmount());
                rows[i][4] = Formatter.int2Price(detailedBills.get(i).getPrice());
                rows[i][5] = Formatter.int2Price(
                                detailedBills.get(i).getAmount() * detailedBills.get(i).getPrice()
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
        if (this.bill == null)
            return;
        
        try{
            ArrayList<DetailedBill> detailedBills = DetailedBill.selectAll(this.bill.getId());
            detailedBills.add(null);
            this.renderTable(detailedBills);
            this.paidTextField.setText(Formatter.int2Price(this.bill.getPaid()));

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
        billIdLabel = new javax.swing.JLabel();
        filler28 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        billIdTextField = new javax.swing.JTextField();
        filler29 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        billDateLabel = new javax.swing.JLabel();
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        billDateTextField = new javax.swing.JTextField();
        filler31 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        employeeLabel = new javax.swing.JLabel();
        filler27 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        employeeTextField = new javax.swing.JTextField();
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        customerLabel = new javax.swing.JLabel();
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        customerComboBox = new javax.swing.JComboBox<>();
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        discountLabel = new javax.swing.JLabel();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        discountComboBox = new javax.swing.JComboBox<>();
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        scrollPanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        interactionPanel = new javax.swing.JPanel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        bookChooserPanel = new javax.swing.JPanel();
        bookInfoPanel = new javax.swing.JPanel();
        bookPanel = new javax.swing.JPanel();
        bookLabel = new javax.swing.JLabel();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        bookComboBox = new javax.swing.JComboBox<>();
        publisherPanel = new javax.swing.JPanel();
        publisherLabel = new javax.swing.JLabel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        publisherTextField = new javax.swing.JTextField();
        pricePanel = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        priceTextField = new javax.swing.JTextField();
        amountPanel = new javax.swing.JPanel();
        amountLabel = new javax.swing.JLabel();
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        amountTextField = new javax.swing.JTextField();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        actionPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(70, 0), new java.awt.Dimension(70, 0), new java.awt.Dimension(70, 32767));
        deleteButton = new javax.swing.JButton();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        statisticPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        allTotalPricePanel = new javax.swing.JPanel();
        allTotalPriceLabel = new javax.swing.JLabel();
        allTotalPriceValueLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        reducedPricePanel = new javax.swing.JPanel();
        reducedPriceLabel = new javax.swing.JLabel();
        reducedPriceValueLabel = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        finalPricePanel = new javax.swing.JPanel();
        finalPriceLabel = new javax.swing.JLabel();
        finalPriceValueLabel = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        paidPanel = new javax.swing.JPanel();
        paidLabel = new javax.swing.JLabel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        paidTextField = new javax.swing.JTextField();
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        remainPricePanel = new javax.swing.JPanel();
        remainPriceLabel = new javax.swing.JLabel();
        remainPriceValueLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        paidButton = new javax.swing.JButton();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 402));
        setSize(new java.awt.Dimension(1000, 400));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        customerPanel.setBackground(new java.awt.Color(0, 51, 51));
        customerPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        customerPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        customerPanel.setPreferredSize(new java.awt.Dimension(10, 100));
        customerPanel.setLayout(new javax.swing.BoxLayout(customerPanel, javax.swing.BoxLayout.LINE_AXIS));
        customerPanel.add(filler18);

        billIdLabel.setBackground(new java.awt.Color(0, 51, 51));
        billIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        billIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        billIdLabel.setText("Mã hóa đơn");
        billIdLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        billIdLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        billIdLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        customerPanel.add(billIdLabel);
        customerPanel.add(filler28);

        billIdTextField.setEditable(false);
        billIdTextField.setBackground(new java.awt.Color(255, 255, 255));
        billIdTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        billIdTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        billIdTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        billIdTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        billIdTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        billIdTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(billIdTextField);
        customerPanel.add(filler29);

        billDateLabel.setBackground(new java.awt.Color(0, 51, 51));
        billDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        billDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        billDateLabel.setText("Ngày tạo");
        billDateLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        billDateLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        billDateLabel.setPreferredSize(new java.awt.Dimension(80, 50));
        customerPanel.add(billDateLabel);
        customerPanel.add(filler30);

        billDateTextField.setEditable(false);
        billDateTextField.setBackground(new java.awt.Color(255, 255, 255));
        billDateTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        billDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        billDateTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        billDateTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        billDateTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        billDateTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(billDateTextField);
        customerPanel.add(filler31);

        employeeLabel.setBackground(new java.awt.Color(0, 51, 51));
        employeeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        employeeLabel.setForeground(new java.awt.Color(255, 255, 255));
        employeeLabel.setText("Nhân viên");
        employeeLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        employeeLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        employeeLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        customerPanel.add(employeeLabel);
        customerPanel.add(filler27);

        employeeTextField.setEditable(false);
        employeeTextField.setBackground(new java.awt.Color(255, 255, 255));
        employeeTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        employeeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        employeeTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        employeeTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        employeeTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        employeeTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(employeeTextField);
        customerPanel.add(filler26);

        customerLabel.setBackground(new java.awt.Color(0, 51, 51));
        customerLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel.setText("Khách hàng");
        customerLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        customerLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        customerLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        customerPanel.add(customerLabel);
        customerPanel.add(filler21);

        customerComboBox.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerComboBox.setBorder(null);
        customerComboBox.setMaximumSize(new java.awt.Dimension(350, 40));
        customerComboBox.setMinimumSize(new java.awt.Dimension(10, 10));
        customerComboBox.setPreferredSize(new java.awt.Dimension(350, 30));
        customerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboBoxActionPerformed(evt);
            }
        });
        customerPanel.add(customerComboBox);
        customerPanel.add(filler23);

        discountLabel.setBackground(new java.awt.Color(0, 51, 51));
        discountLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        discountLabel.setForeground(new java.awt.Color(255, 255, 255));
        discountLabel.setText("Khuyến mãi");
        discountLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        discountLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        discountLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        customerPanel.add(discountLabel);
        customerPanel.add(filler24);

        discountComboBox.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        discountComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        discountComboBox.setBorder(null);
        discountComboBox.setMaximumSize(new java.awt.Dimension(200, 40));
        discountComboBox.setMinimumSize(new java.awt.Dimension(10, 10));
        discountComboBox.setPreferredSize(new java.awt.Dimension(200, 20));
        discountComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountComboBoxActionPerformed(evt);
            }
        });
        customerPanel.add(discountComboBox);
        customerPanel.add(filler20);

        getContentPane().add(customerPanel);

        scrollPanel.setBackground(new java.awt.Color(255, 255, 255));
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

        interactionPanel.setBackground(new java.awt.Color(255, 255, 255));
        interactionPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        interactionPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        interactionPanel.setPreferredSize(new java.awt.Dimension(300, 350));
        interactionPanel.setLayout(new javax.swing.BoxLayout(interactionPanel, javax.swing.BoxLayout.LINE_AXIS));
        interactionPanel.add(filler7);

        bookChooserPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookChooserPanel.setMaximumSize(new java.awt.Dimension(32000, 300));
        bookChooserPanel.setPreferredSize(new java.awt.Dimension(600, 32000));
        bookChooserPanel.setLayout(new javax.swing.BoxLayout(bookChooserPanel, javax.swing.BoxLayout.PAGE_AXIS));

        bookInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookInfoPanel.setAlignmentX((float)0.5);
        bookInfoPanel.setPreferredSize(new java.awt.Dimension(605, 300));
        bookInfoPanel.setLayout(new javax.swing.BoxLayout(bookInfoPanel, javax.swing.BoxLayout.PAGE_AXIS));

        bookPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        bookPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        bookPanel.setPreferredSize(new java.awt.Dimension(32000, 100));
        bookPanel.setLayout(new javax.swing.BoxLayout(bookPanel, javax.swing.BoxLayout.LINE_AXIS));

        bookLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookLabel.setText("Sách");
        bookLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        bookLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        bookPanel.add(bookLabel);
        bookPanel.add(filler13);

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

        publisherPanel.setBackground(new java.awt.Color(255, 255, 255));
        publisherPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        publisherPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        publisherPanel.setPreferredSize(new java.awt.Dimension(32000, 100));
        publisherPanel.setLayout(new javax.swing.BoxLayout(publisherPanel, javax.swing.BoxLayout.LINE_AXIS));

        publisherLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        publisherLabel.setText("Nhà xuất bản");
        publisherLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        publisherLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        publisherPanel.add(publisherLabel);
        publisherPanel.add(filler14);

        publisherTextField.setEditable(false);
        publisherTextField.setBackground(new java.awt.Color(255, 255, 255));
        publisherTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        publisherTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        publisherTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        publisherTextField.setPreferredSize(new java.awt.Dimension(300, 35));
        publisherPanel.add(publisherTextField);

        bookInfoPanel.add(publisherPanel);

        pricePanel.setBackground(new java.awt.Color(255, 255, 255));
        pricePanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        pricePanel.setMinimumSize(new java.awt.Dimension(0, 0));
        pricePanel.setPreferredSize(new java.awt.Dimension(32000, 100));
        pricePanel.setLayout(new javax.swing.BoxLayout(pricePanel, javax.swing.BoxLayout.LINE_AXIS));

        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceLabel.setText("Đơn giá");
        priceLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        priceLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        pricePanel.add(priceLabel);
        pricePanel.add(filler16);

        priceTextField.setEditable(false);
        priceTextField.setBackground(new java.awt.Color(255, 255, 255));
        priceTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        priceTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        priceTextField.setPreferredSize(new java.awt.Dimension(300, 35));
        pricePanel.add(priceTextField);

        bookInfoPanel.add(pricePanel);

        amountPanel.setBackground(new java.awt.Color(255, 255, 255));
        amountPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        amountPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        amountPanel.setPreferredSize(new java.awt.Dimension(32000, 100));
        amountPanel.setLayout(new javax.swing.BoxLayout(amountPanel, javax.swing.BoxLayout.LINE_AXIS));

        amountLabel.setBackground(new java.awt.Color(255, 255, 255));
        amountLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        amountLabel.setText("Số lượng");
        amountLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        amountLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        amountPanel.add(amountLabel);
        amountPanel.add(filler17);

        amountTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        amountTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        amountTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        amountTextField.setPreferredSize(new java.awt.Dimension(300, 35));
        amountPanel.add(amountTextField);

        bookInfoPanel.add(amountPanel);
        bookInfoPanel.add(filler19);

        bookChooserPanel.add(bookInfoPanel);
        bookChooserPanel.add(filler10);

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

        filler12.setBackground(new java.awt.Color(255, 255, 255));
        actionPanel.add(filler12);

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

        bookChooserPanel.add(actionPanel);
        bookChooserPanel.add(filler15);

        interactionPanel.add(bookChooserPanel);
        interactionPanel.add(filler6);
        interactionPanel.add(filler8);

        statisticPanel.setBackground(new java.awt.Color(255, 255, 255));
        statisticPanel.setMaximumSize(new java.awt.Dimension(500, 300));
        statisticPanel.setPreferredSize(new java.awt.Dimension(400, 100));
        statisticPanel.setLayout(new javax.swing.BoxLayout(statisticPanel, javax.swing.BoxLayout.PAGE_AXIS));
        statisticPanel.add(filler1);

        allTotalPricePanel.setBackground(new java.awt.Color(255, 255, 255));
        allTotalPricePanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        allTotalPricePanel.setPreferredSize(new java.awt.Dimension(400, 30));
        allTotalPricePanel.setLayout(new javax.swing.BoxLayout(allTotalPricePanel, javax.swing.BoxLayout.LINE_AXIS));

        allTotalPriceLabel.setBackground(new java.awt.Color(255, 255, 255));
        allTotalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        allTotalPriceLabel.setText("Tổng cộng:");
        allTotalPriceLabel.setAlignmentX(0.5F);
        allTotalPriceLabel.setMaximumSize(new java.awt.Dimension(200, 1000));
        allTotalPriceLabel.setMinimumSize(new java.awt.Dimension(100, 0));
        allTotalPriceLabel.setPreferredSize(new java.awt.Dimension(200, 100));
        allTotalPricePanel.add(allTotalPriceLabel);

        allTotalPriceValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        allTotalPriceValueLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        allTotalPriceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        allTotalPriceValueLabel.setText("0đ");
        allTotalPriceValueLabel.setAlignmentX(0.5F);
        allTotalPriceValueLabel.setMaximumSize(new java.awt.Dimension(32000, 1000));
        allTotalPricePanel.add(allTotalPriceValueLabel);

        statisticPanel.add(allTotalPricePanel);
        statisticPanel.add(filler3);

        reducedPricePanel.setBackground(new java.awt.Color(255, 255, 255));
        reducedPricePanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        reducedPricePanel.setPreferredSize(new java.awt.Dimension(400, 30));
        reducedPricePanel.setLayout(new javax.swing.BoxLayout(reducedPricePanel, javax.swing.BoxLayout.LINE_AXIS));

        reducedPriceLabel.setBackground(new java.awt.Color(255, 255, 255));
        reducedPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        reducedPriceLabel.setText("Giảm giá:");
        reducedPriceLabel.setAlignmentX(0.5F);
        reducedPriceLabel.setMaximumSize(new java.awt.Dimension(200, 1000));
        reducedPriceLabel.setMinimumSize(new java.awt.Dimension(100, 0));
        reducedPriceLabel.setPreferredSize(new java.awt.Dimension(200, 100));
        reducedPricePanel.add(reducedPriceLabel);

        reducedPriceValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        reducedPriceValueLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        reducedPriceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        reducedPriceValueLabel.setText("0đ");
        reducedPriceValueLabel.setAlignmentX(0.5F);
        reducedPriceValueLabel.setMaximumSize(new java.awt.Dimension(32000, 1000));
        reducedPricePanel.add(reducedPriceValueLabel);

        statisticPanel.add(reducedPricePanel);
        statisticPanel.add(filler4);

        finalPricePanel.setBackground(new java.awt.Color(255, 255, 255));
        finalPricePanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        finalPricePanel.setPreferredSize(new java.awt.Dimension(400, 30));
        finalPricePanel.setLayout(new javax.swing.BoxLayout(finalPricePanel, javax.swing.BoxLayout.LINE_AXIS));

        finalPriceLabel.setBackground(new java.awt.Color(255, 255, 255));
        finalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        finalPriceLabel.setText("Thành tiền:");
        finalPriceLabel.setAlignmentX(0.5F);
        finalPriceLabel.setMaximumSize(new java.awt.Dimension(200, 1000));
        finalPriceLabel.setMinimumSize(new java.awt.Dimension(100, 0));
        finalPriceLabel.setPreferredSize(new java.awt.Dimension(200, 100));
        finalPricePanel.add(finalPriceLabel);

        finalPriceValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        finalPriceValueLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        finalPriceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        finalPriceValueLabel.setText("0đ");
        finalPriceValueLabel.setAlignmentX(0.5F);
        finalPriceValueLabel.setMaximumSize(new java.awt.Dimension(32000, 1000));
        finalPricePanel.add(finalPriceValueLabel);

        statisticPanel.add(finalPricePanel);
        statisticPanel.add(filler5);

        paidPanel.setBackground(new java.awt.Color(255, 255, 255));
        paidPanel.setMaximumSize(new java.awt.Dimension(32000, 30));
        paidPanel.setLayout(new javax.swing.BoxLayout(paidPanel, javax.swing.BoxLayout.LINE_AXIS));

        paidLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        paidLabel.setText("Thực trả:");
        paidLabel.setMaximumSize(new java.awt.Dimension(190, 32000));
        paidLabel.setPreferredSize(new java.awt.Dimension(190, 22));
        paidPanel.add(paidLabel);
        paidPanel.add(filler9);

        paidTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        paidTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        paidTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        paidTextField.setPreferredSize(new java.awt.Dimension(200, 35));
        paidTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidTextFieldActionPerformed(evt);
            }
        });
        paidPanel.add(paidTextField);

        statisticPanel.add(paidPanel);
        statisticPanel.add(filler22);

        remainPricePanel.setBackground(new java.awt.Color(255, 255, 255));
        remainPricePanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        remainPricePanel.setPreferredSize(new java.awt.Dimension(400, 30));
        remainPricePanel.setLayout(new javax.swing.BoxLayout(remainPricePanel, javax.swing.BoxLayout.LINE_AXIS));

        remainPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        remainPriceLabel.setText("Còn lại");
        remainPriceLabel.setAlignmentX(0.5F);
        remainPriceLabel.setMaximumSize(new java.awt.Dimension(200, 1000));
        remainPriceLabel.setMinimumSize(new java.awt.Dimension(100, 0));
        remainPriceLabel.setPreferredSize(new java.awt.Dimension(200, 100));
        remainPricePanel.add(remainPriceLabel);

        remainPriceValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        remainPriceValueLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        remainPriceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        remainPriceValueLabel.setText("0đ");
        remainPriceValueLabel.setAlignmentX(0.5F);
        remainPriceValueLabel.setMaximumSize(new java.awt.Dimension(32000, 1000));
        remainPricePanel.add(remainPriceValueLabel);

        statisticPanel.add(remainPricePanel);
        statisticPanel.add(filler2);

        paidButton.setBackground(new java.awt.Color(0, 0, 0));
        paidButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        paidButton.setForeground(new java.awt.Color(255, 255, 255));
        paidButton.setText("Thanh toán");
        paidButton.setFocusPainted(false);
        paidButton.setMaximumSize(new java.awt.Dimension(150, 50));
        paidButton.setMinimumSize(new java.awt.Dimension(100, 30));
        paidButton.setPreferredSize(new java.awt.Dimension(150, 50));
        paidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidButtonActionPerformed(evt);
            }
        });
        statisticPanel.add(paidButton);
        statisticPanel.add(filler25);

        interactionPanel.add(statisticPanel);
        interactionPanel.add(filler11);

        getContentPane().add(interactionPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try{
            Book book = (Book)this.bookComboBox.getSelectedItem();
            
            String bookId = book.getId();
            
            Integer amount = null;
            try{
                amount = Integer.valueOf(this.amountTextField.getText());
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
            DetailedBill detailedBill;
            if (row == -1 || row == this.table.getRowCount() - 1){
                detailedBill = DetailedBill.insert(this.bill.getId(), bookId, amount);
            }
            else{
                String oldBookId = (String)this.table.getValueAt(row, 0);
                Integer oldAmount = Integer.valueOf((String)this.table.getValueAt(row, 3));
                Integer oldPrice = Formatter.price2Int((String)this.table.getValueAt(row, 4));
                DetailedBill old = new DetailedBill(oldBookId, this.bill.getId(), oldPrice, oldAmount);
              
                detailedBill = new DetailedBill(bookId, this.bill.getId(), book.getPrice(), amount);
                DetailedBill.update(old, detailedBill);
            }
            
            this.bill = Bill.findById(this.bill.getId());
            this.reloadTable();
            this.renderBill();
            
            if (row == -1 || row == this.table.getRowCount() - 2){
                row = this.table.getRowCount() - 2;
                this.table.setRowSelectionInterval(row + 1, row + 1);
            }

            this.updateStatisticPanel();
            this.parent.reloadTable();
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = this.table.getSelectedRow();
        
        if (row == -1 || row == this.table.getSelectedRow() - 1)
            return;
        
        String bookId = (String)this.table.getValueAt(row, 0);
        
        try{
            DetailedBill.delete(this.bill.getId(), bookId);
            this.bill = Bill.findById(this.bill.getId());
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa. " + e, "Hóa đơn", 1);
        }
        this.updateStatisticPanel();
        this.reloadTable();
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    private void paidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidButtonActionPerformed
        Integer paid = Formatter.price2Int(this.paidTextField.getText());
        this.bill.setPaid(paid);
        try{
            Bill tmp = Bill.update(this.bill);
            if (tmp != null){
                this.bill = tmp;
            }
            else{
                throw new Exception("Cập nhật thất bại. Xem chi tiết ở log.");
            }
            
            JOptionPane.showMessageDialog(null, "Thanh toán hóa đơn thành công", "Hóa đơn", 1);
            this.updateStatisticPanel();
            this.parent.reloadTable();
        }
        catch(BillException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", 1);
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi khi thanh toán. " + e, "Hóa đơn", 1);
            return;
        }
        
    }//GEN-LAST:event_paidButtonActionPerformed

    private void discountComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountComboBoxActionPerformed
        Discount discount = (Discount) this.discountComboBox.getSelectedItem();
        String discountId = discount == null? null : discount.getId();
        
        if (this.bill.getDiscountId() == null && discountId == null)
            return;
        if(this.bill.getDiscountId() != null)
            if (this.bill.getDiscountId().equals(discountId) )
            return;
   
        this.bill.setDiscountId(discountId);
        
        try{
            Bill tmp = Bill.update(this.bill);
            if (tmp != null){
                this.bill = tmp;
            }
            else{
                throw new Exception("Cập nhật thất bại. Xem chi tiết ở log.");
            }
            this.updateStatisticPanel();
            this.parent.reloadTable();
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Không thể đổi mã khuyến mãi. Lý do: " + e, "Lỗi", 1);
        }
    }//GEN-LAST:event_discountComboBoxActionPerformed

    private void paidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidTextFieldActionPerformed
        Integer finalPrice = this.bill.getFinalPrice();
        Integer paidPrice = Formatter.price2Int(this.paidTextField.getText());
        Integer remainPrice = finalPrice - paidPrice;
        this.remainPriceValueLabel.setText(Formatter.int2Price(remainPrice));
    }//GEN-LAST:event_paidTextFieldActionPerformed

    private void bookComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookComboBoxActionPerformed
        this.loadBookInformation();
    }//GEN-LAST:event_bookComboBoxActionPerformed

    private void customerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboBoxActionPerformed
        
        Customer customer = (Customer) this.customerComboBox.getSelectedItem();
        
        if (this.bill.getCustomerId().equals(customer.getId()))
            return;
        
        this.bill.setCustomerId(customer.getId());
        
        try{
            Bill tmp = Bill.update(this.bill);
            if (tmp != null){
                this.bill = tmp;
            }
            else{
                throw new Exception("Cập nhật thất bại. Xem chi tiết ở log.");
            }
            
            this.parent.reloadTable();
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Không thể đổi khách hàng. Lý do: " + e, "Lỗi", 1);
        }
        
    }//GEN-LAST:event_customerComboBoxActionPerformed

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
                String amount = (String) this.table.getValueAt(row, 3);
                String price  = (String) this.table.getValueAt(row, 4);

                this.bookComboBox.getModel().setSelectedItem(Book.findById(bookId));
                this.loadBookInformation();
                this.priceTextField.setText(price);
                this.amountTextField.setText(amount);
            }
            else{
                this.addButton.setText("Thêm sách");
                this.deleteButton.setVisible(false);
                this.bookComboBox.setEditable(true);
                this.bookComboBox.setEnabled(true);
                
                this.bookComboBox.setSelectedIndex(0);
                this.loadBookInformation();
                this.amountTextField.setText(null);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void updateStatisticPanel(){
        Integer finalPrice = this.bill.getFinalPrice();
        Integer totalPrice = this.bill.getTotalPrice();
        Integer reducedPrice = totalPrice - finalPrice;
        Integer paidPrice = this.bill.getPaid();
        Integer remainPrice = finalPrice - paidPrice;
        
        this.allTotalPriceValueLabel.setText(Formatter.int2Price(totalPrice));
        this.reducedPriceValueLabel.setText(Formatter.int2Price(reducedPrice));
        this.finalPriceValueLabel.setText(Formatter.int2Price(finalPrice));
        this.remainPriceValueLabel.setText(Formatter.int2Price(remainPrice));
    }
    
    public void renderBill(){
        if (this.bill == null)
            return;
        
        if (this.bill.getId() != null){
            this.billIdTextField.setText(bill.getId().toString());
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.billDateTextField.setText(dateFormat.format(bill.getDate()));
        
        this.employeeTextField.setText(App.getAccount().getEmployeeId());
        
        this.updateStatisticPanel();
        
        try{
            Customer selectedCustomer = Customer.findById(bill.getCustomerId());
            this.customerComboBox.getModel().setSelectedItem(selectedCustomer);
            
            Discount selectedDiscount = Discount.findById(bill.getDiscountId());
            this.discountComboBox.getModel().setSelectedItem(selectedDiscount);
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    
    public void setupComboBox(){
        try{
            Object customers[] = Customer.selectAll().toArray();
            DefaultComboBoxModel customerCbm = new DefaultComboBoxModel(customers);

            this.customerComboBox.setModel(customerCbm);

            Object books[] = Book.selectAll().toArray();
            DefaultComboBoxModel bookCbm = new DefaultComboBoxModel(books);
            this.bookComboBox.setModel(bookCbm);
            this.loadBookInformation();

            ArrayList<Discount> discountArrayList = new ArrayList<>();
            discountArrayList.add(null);
            discountArrayList.addAll(Discount.selectAllToday());
            Object discounts[] = discountArrayList.toArray();
            DefaultComboBoxModel discountCbm = new DefaultComboBoxModel(discounts);
            this.discountComboBox.setModel(discountCbm);
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

            this.priceTextField.setText(Formatter.int2Price(selectedBook.getPrice()));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel allTotalPriceLabel;
    private javax.swing.JPanel allTotalPricePanel;
    private javax.swing.JLabel allTotalPriceValueLabel;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JPanel amountPanel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JLabel billDateLabel;
    private javax.swing.JTextField billDateTextField;
    private javax.swing.JLabel billIdLabel;
    private javax.swing.JTextField billIdTextField;
    private javax.swing.JPanel bookChooserPanel;
    private javax.swing.JComboBox<String> bookComboBox;
    private javax.swing.JPanel bookInfoPanel;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JComboBox<String> customerComboBox;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> discountComboBox;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JLabel employeeLabel;
    private javax.swing.JTextField employeeTextField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler23;
    private javax.swing.Box.Filler filler24;
    private javax.swing.Box.Filler filler25;
    private javax.swing.Box.Filler filler26;
    private javax.swing.Box.Filler filler27;
    private javax.swing.Box.Filler filler28;
    private javax.swing.Box.Filler filler29;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler30;
    private javax.swing.Box.Filler filler31;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JLabel finalPriceLabel;
    private javax.swing.JPanel finalPricePanel;
    private javax.swing.JLabel finalPriceValueLabel;
    private javax.swing.JPanel interactionPanel;
    private javax.swing.JButton paidButton;
    private javax.swing.JLabel paidLabel;
    private javax.swing.JPanel paidPanel;
    private javax.swing.JTextField paidTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel pricePanel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JPanel publisherPanel;
    private javax.swing.JTextField publisherTextField;
    private javax.swing.JLabel reducedPriceLabel;
    private javax.swing.JPanel reducedPricePanel;
    private javax.swing.JLabel reducedPriceValueLabel;
    private javax.swing.JLabel remainPriceLabel;
    private javax.swing.JPanel remainPricePanel;
    private javax.swing.JLabel remainPriceValueLabel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JPanel statisticPanel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private BillPanel parent;
    private Bill bill;
}
