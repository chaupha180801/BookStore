/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.ui.subpanel;

import bookstore.database.tables.Bill;
import bookstore.exceptions.DatabasePermissonErrorException;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import bookstore.utils.Formatter;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;


public class ShowBill extends javax.swing.JFrame {

    static Date date;
    public ShowBill(Date sqldate) throws DatabasePermissonErrorException {
        initComponents();
        this.date = sqldate;
        this.reloadTable(date);
        
        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(0,204,102));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setPreferredSize(new Dimension(60, 40));
        table.setRowHeight(40);
        table.setSelectionBackground(Color.black);
        
        int finalPrice = Bill.sumFinalPrice(date);
        finalPriceTextField.setText(Formatter.int2Price(finalPrice));
        
        int totalPrice = Bill.sumTotalPrice(date);
        totalPriceTextField.setText(Formatter.int2Price(finalPrice));
        
        dateTextField.setText(String.valueOf(date));
        
        int countBill = Bill.countBill(date);
        countBillTextField.setText(String.valueOf(countBill));
        
    }

    public void reloadTable(Date date) throws DatabasePermissonErrorException{
        
        ArrayList<Bill> bills = Bill.selectBills(date);

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerPanel = new javax.swing.JPanel();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        statisticalDateLabel = new javax.swing.JLabel();
        filler34 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        dateTextField = new javax.swing.JTextField();
        filler35 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        countBillLabel = new javax.swing.JLabel();
        filler32 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        countBillTextField = new javax.swing.JTextField();
        filler33 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler39 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        totalPriceLabel = new javax.swing.JLabel();
        filler38 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        totalPriceTextField = new javax.swing.JTextField();
        filler31 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler37 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        finalPriceLabel = new javax.swing.JLabel();
        filler27 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler36 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(32767, 0));
        finalPriceTextField = new javax.swing.JTextField();
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        showBillPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(32000, 32000));
        setPreferredSize(new java.awt.Dimension(815, 800));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        customerPanel.setBackground(new java.awt.Color(0, 51, 51));
        customerPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        customerPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        customerPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        customerPanel.setLayout(new javax.swing.BoxLayout(customerPanel, javax.swing.BoxLayout.LINE_AXIS));
        customerPanel.add(filler18);

        statisticalDateLabel.setBackground(new java.awt.Color(0, 51, 51));
        statisticalDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statisticalDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        statisticalDateLabel.setText("Ngày thống kê");
        statisticalDateLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        statisticalDateLabel.setMinimumSize(new java.awt.Dimension(10, 20));
        statisticalDateLabel.setPreferredSize(new java.awt.Dimension(130, 60));
        customerPanel.add(statisticalDateLabel);
        customerPanel.add(filler34);

        dateTextField.setEditable(false);
        dateTextField.setBackground(new java.awt.Color(0, 51, 51));
        dateTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dateTextField.setForeground(new java.awt.Color(255, 255, 255));
        dateTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        dateTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        dateTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        dateTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(dateTextField);
        customerPanel.add(filler35);

        countBillLabel.setBackground(new java.awt.Color(0, 51, 51));
        countBillLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        countBillLabel.setForeground(new java.awt.Color(255, 255, 255));
        countBillLabel.setText("Số hóa đơn");
        countBillLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        countBillLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        countBillLabel.setPreferredSize(new java.awt.Dimension(100, 50));
        customerPanel.add(countBillLabel);
        customerPanel.add(filler32);

        countBillTextField.setEditable(false);
        countBillTextField.setBackground(new java.awt.Color(0, 51, 51));
        countBillTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        countBillTextField.setForeground(new java.awt.Color(255, 255, 255));
        countBillTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        countBillTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        countBillTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        countBillTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(countBillTextField);
        customerPanel.add(filler33);
        customerPanel.add(filler39);

        totalPriceLabel.setBackground(new java.awt.Color(0, 51, 51));
        totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalPriceLabel.setText("Tổng tiền hóa đơn");
        totalPriceLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        totalPriceLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        totalPriceLabel.setPreferredSize(new java.awt.Dimension(160, 50));
        customerPanel.add(totalPriceLabel);
        customerPanel.add(filler38);
        customerPanel.add(filler30);

        totalPriceTextField.setEditable(false);
        totalPriceTextField.setBackground(new java.awt.Color(0, 51, 51));
        totalPriceTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        totalPriceTextField.setForeground(new java.awt.Color(255, 255, 255));
        totalPriceTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        totalPriceTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        totalPriceTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        totalPriceTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(totalPriceTextField);
        customerPanel.add(filler31);
        customerPanel.add(filler37);

        finalPriceLabel.setBackground(new java.awt.Color(0, 51, 51));
        finalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        finalPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        finalPriceLabel.setText("Tổng tiền thu");
        finalPriceLabel.setMaximumSize(new java.awt.Dimension(300, 32000));
        finalPriceLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        finalPriceLabel.setPreferredSize(new java.awt.Dimension(120, 50));
        customerPanel.add(finalPriceLabel);
        customerPanel.add(filler27);
        customerPanel.add(filler36);

        finalPriceTextField.setEditable(false);
        finalPriceTextField.setBackground(new java.awt.Color(0, 51, 51));
        finalPriceTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        finalPriceTextField.setForeground(new java.awt.Color(255, 255, 255));
        finalPriceTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        finalPriceTextField.setMaximumSize(new java.awt.Dimension(32000, 35));
        finalPriceTextField.setMinimumSize(new java.awt.Dimension(0, 0));
        finalPriceTextField.setPreferredSize(new java.awt.Dimension(100, 35));
        customerPanel.add(finalPriceTextField);
        customerPanel.add(filler26);

        getContentPane().add(customerPanel);

        showBillPanel.setBackground(new java.awt.Color(255, 255, 255));
        showBillPanel.setPreferredSize(new java.awt.Dimension(815, 600));

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setGridColor(new java.awt.Color(40, 60, 80));
        table.setMaximumSize(new java.awt.Dimension(32000, 32000));
        table.setMinimumSize(new java.awt.Dimension(200, 200));
        table.setPreferredSize(new java.awt.Dimension(800, 800));
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(new java.awt.Color(255, 204, 255));
        tablePanel.setViewportView(table);

        org.jdesktop.layout.GroupLayout showBillPanelLayout = new org.jdesktop.layout.GroupLayout(showBillPanel);
        showBillPanel.setLayout(showBillPanelLayout);
        showBillPanelLayout.setHorizontalGroup(
            showBillPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tablePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );
        showBillPanelLayout.setVerticalGroup(
            showBillPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tablePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        getContentPane().add(showBillPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countBillLabel;
    private javax.swing.JTextField countBillTextField;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler26;
    private javax.swing.Box.Filler filler27;
    private javax.swing.Box.Filler filler30;
    private javax.swing.Box.Filler filler31;
    private javax.swing.Box.Filler filler32;
    private javax.swing.Box.Filler filler33;
    private javax.swing.Box.Filler filler34;
    private javax.swing.Box.Filler filler35;
    private javax.swing.Box.Filler filler36;
    private javax.swing.Box.Filler filler37;
    private javax.swing.Box.Filler filler38;
    private javax.swing.Box.Filler filler39;
    private javax.swing.JLabel finalPriceLabel;
    private javax.swing.JTextField finalPriceTextField;
    private javax.swing.JPanel showBillPanel;
    private javax.swing.JLabel statisticalDateLabel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JTextField totalPriceTextField;
    // End of variables declaration//GEN-END:variables

}
