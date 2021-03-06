

package bookstore.ui.subpanel;

import java.util.*;
import javax.swing.*;
import bookstore.App;
import bookstore.exceptions.*;
import bookstore.database.tables.*;
import java.awt.*;  

public class InitialInfoBillChooser extends javax.swing.JFrame {

    /** Creates new form InitialInfoBillChooser */
    public InitialInfoBillChooser(BillPanel parent) {
        initComponents();
        this.parent = parent;
        this.setLocationRelativeTo(null);
        ((JTextField)this.customerComboBox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        ((JTextField)this.customerComboBox.getEditor().getEditorComponent()).setEditable(false);
        ((JTextField)this.discountComboBox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        ((JTextField)this.discountComboBox.getEditor().getEditorComponent()).setEditable(false);
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JFrame main = this;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                main.dispose();
            }
        });
        
        try{
            Object customers[] = Customer.selectAll().toArray();
            DefaultComboBoxModel customerCbm = new DefaultComboBoxModel(customers);
            this.customerComboBox.setModel(customerCbm);
            
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        customerPanel = new javax.swing.JPanel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        customerLabel = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 30));
        customerComboBox = new javax.swing.JComboBox<>();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(1576, 0), new java.awt.Dimension(157, 0), new java.awt.Dimension(176, 32767));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(157, 0), new java.awt.Dimension(157, 0), new java.awt.Dimension(147, 32767));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        discountPanel = new javax.swing.JPanel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        discountLabel = new javax.swing.JLabel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 30));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        discountComboBox = new javax.swing.JComboBox<>();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(170, 0), new java.awt.Dimension(170, 0), new java.awt.Dimension(181, 32767));
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(170, 0), new java.awt.Dimension(170, 0), new java.awt.Dimension(170, 32767));
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 3200));
        submitPanel = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32000, 32000));
        setName("Ch???n kh??ch h??ng v?? th??ng tin khuy???n m??i."); // NOI18N
        setPreferredSize(new java.awt.Dimension(550, 400));
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));
        getContentPane().add(jPanel1);

        customerPanel.setMaximumSize(new java.awt.Dimension(32000, 50));
        customerPanel.setPreferredSize(new java.awt.Dimension(400, 100));

        customerLabel.setBackground(new java.awt.Color(0, 204, 102));
        customerLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        customerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerLabel.setText("Ch???n kh??ch h??ng");
        customerLabel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        customerLabel.setPreferredSize(new java.awt.Dimension(50, 50));

        customerComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        customerComboBox.setMaximumSize(new java.awt.Dimension(32000, 50));
        customerComboBox.setPreferredSize(new java.awt.Dimension(350, 40));

        org.jdesktop.layout.GroupLayout customerPanelLayout = new org.jdesktop.layout.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(customerPanelLayout.createSequentialGroup()
                .add(customerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(customerPanelLayout.createSequentialGroup()
                        .add(filler15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(customerComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 461, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(filler13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(customerPanelLayout.createSequentialGroup()
                        .add(customerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(filler8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 527, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(filler6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 527, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(customerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(filler11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(customerLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 181, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(filler12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(0, 0, Short.MAX_VALUE)))
                .add(10, 10, 10))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(customerPanelLayout.createSequentialGroup()
                .add(customerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(customerLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(customerPanelLayout.createSequentialGroup()
                        .add(filler8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(filler11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(filler12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)))
                .add(filler6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(customerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(customerComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(customerPanelLayout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(customerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(filler13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(filler15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
        );

        getContentPane().add(customerPanel);

        discountPanel.setMaximumSize(new java.awt.Dimension(32000, 100));
        discountPanel.setPreferredSize(new java.awt.Dimension(450, 100));

        discountLabel.setBackground(new java.awt.Color(204, 204, 255));
        discountLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        discountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        discountLabel.setText("Ch???n khuy???n m??i");
        discountLabel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        discountLabel.setPreferredSize(new java.awt.Dimension(100, 100));

        discountComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        discountComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        discountComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        discountComboBox.setMaximumSize(new java.awt.Dimension(32000, 50));
        discountComboBox.setPreferredSize(new java.awt.Dimension(350, 40));

        org.jdesktop.layout.GroupLayout discountPanelLayout = new org.jdesktop.layout.GroupLayout(discountPanel);
        discountPanel.setLayout(discountPanelLayout);
        discountPanelLayout.setHorizontalGroup(
            discountPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(filler10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 527, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(filler14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 527, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(discountPanelLayout.createSequentialGroup()
                .add(158, 158, 158)
                .add(filler5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(discountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(filler18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(discountComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 460, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(filler19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(discountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(filler16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 156, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(discountLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(filler17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        discountPanelLayout.setVerticalGroup(
            discountPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(discountPanelLayout.createSequentialGroup()
                .add(discountPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(discountLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(discountPanelLayout.createSequentialGroup()
                        .add(filler10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(filler17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(filler16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)))
                .add(filler14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(discountPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(discountComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(discountPanelLayout.createSequentialGroup()
                        .add(filler5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(filler19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(7, 7, 7)
                        .add(filler18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(discountPanel);
        getContentPane().add(filler3);

        submitPanel.setLayout(new javax.swing.BoxLayout(submitPanel, javax.swing.BoxLayout.LINE_AXIS));

        submitButton.setBackground(new java.awt.Color(40, 60, 82));
        submitButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("T???o");
        submitButton.setFocusPainted(false);
        submitButton.setMaximumSize(new java.awt.Dimension(100, 40));
        submitButton.setMinimumSize(new java.awt.Dimension(100, 30));
        submitButton.setPreferredSize(new java.awt.Dimension(100, 40));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        submitPanel.add(submitButton);

        getContentPane().add(submitPanel);
        getContentPane().add(filler4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        this.dispose();
        Customer customer = (Customer) this.customerComboBox.getSelectedItem();
        Discount discount = (Discount) this.discountComboBox.getSelectedItem();
        
        Bill bill;
        
        String employeeId = App.getAccount().getEmployeeId();
        String customerId = customer.getId();
        String discountId = null;
        if (discount != null)
            discountId = discount.getId();
        
        try{
            bill = Bill.insert(employeeId, customerId, discountId, new Date());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "L???i", 1);
            return;
        }
        this.parent.reloadTable();
        AddBill addBill = new AddBill(this.parent, bill);
        addBill.show();
    }//GEN-LAST:event_submitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customerComboBox;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JComboBox<String> discountComboBox;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JPanel discountPanel;
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
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton submitButton;
    private javax.swing.JPanel submitPanel;
    // End of variables declaration//GEN-END:variables
    private BillPanel parent;
}
