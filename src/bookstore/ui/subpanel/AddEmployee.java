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
import java.text.ParseException;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.BorderFactory;
import bookstore.database.tables.Employee;
import javax.swing.JOptionPane;
import bookstore.exceptions.DatabasePermissonErrorException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class AddEmployee extends javax.swing.JFrame {

    protected void initialize(EmployeePanel parent){
        this.parent = parent;
        this.setLocationRelativeTo(null);
        this.idTextField.setEditable(false);
        this.idTextField.setFocusable(false);
    }
    
    public AddEmployee(EmployeePanel parent) {
        this.initComponents();
        this.initialize(parent);
        this.action = 0;
    }
    
     public AddEmployee(EmployeePanel parent, Employee employee){
        this.initComponents();
        this.initialize(parent);

        this.idTextField.setText(employee.getId());
        this.nameTextField.setText(employee.getName());
        this.positionTextField.setText(String.valueOf(employee.getPosition()));
        this.addressTextField.setText(employee.getAddress());
        this.startDateJDchoose.setDate(employee.getStartDate());
        this.phoneNumberTextField.setText(employee.getPhoneNumber());
        this.salaryTextField.setText(String.valueOf(employee.getSalary()));
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
        positionTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        phoneNumberTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        positonLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        startDateJDchoose = new com.toedter.calendar.JDateChooser();
        salaryLabel = new javax.swing.JLabel();
        salaryTextField = new javax.swing.JTextField();
        choosePanel = new javax.swing.JPanel();
        addButton = new metro.MetroButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(200, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        cancelButton = new metro.MetroButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainPanel.setMinimumSize(new java.awt.Dimension(600, 500));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        informationPanel.setBackground(new java.awt.Color(255, 255, 255));
        informationPanel.setMaximumSize(new java.awt.Dimension(32767, 500));
        informationPanel.setMinimumSize(new java.awt.Dimension(200, 400));
        informationPanel.setName("Thêm tác giả"); // NOI18N
        informationPanel.setPreferredSize(new java.awt.Dimension(420, 400));

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

        positionTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        positionTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        positionTextField.setToolTipText("");
        positionTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        positionTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        positionTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        addressTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addressTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        addressTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        addressTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        addressTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        phoneNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneNumberTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        phoneNumberTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        phoneNumberTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        phoneNumberTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addressLabel.setText("Địa chỉ");
        addressLabel.setFocusable(false);
        addressLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        addressLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        addressLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        addressLabel.setRequestFocusEnabled(false);

        startDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        startDateLabel.setText("Ngày vào làm");
        startDateLabel.setFocusable(false);
        startDateLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        startDateLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        startDateLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        startDateLabel.setRequestFocusEnabled(false);

        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneNumberLabel.setText("Số điện thoại");
        phoneNumberLabel.setFocusable(false);
        phoneNumberLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        phoneNumberLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        phoneNumberLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        phoneNumberLabel.setRequestFocusEnabled(false);

        positonLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        positonLabel.setText("Chức vụ");
        positonLabel.setFocusable(false);
        positonLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        positonLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        positonLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        positonLabel.setRequestFocusEnabled(false);

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nameLabel.setText("Tên nhân viên");
        nameLabel.setFocusable(false);
        nameLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        nameLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        nameLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        nameLabel.setRequestFocusEnabled(false);

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        idLabel.setText("Mã nhân viên");
        idLabel.setFocusable(false);
        idLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        idLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        idLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        idLabel.setRequestFocusEnabled(false);

        startDateJDchoose.setDateFormatString("yyyy-MM-dd");
        startDateJDchoose.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        salaryLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        salaryLabel.setText("Lương");
        salaryLabel.setFocusable(false);
        salaryLabel.setMaximumSize(new java.awt.Dimension(200, 40));
        salaryLabel.setMinimumSize(new java.awt.Dimension(200, 40));
        salaryLabel.setPreferredSize(new java.awt.Dimension(200, 40));
        salaryLabel.setRequestFocusEnabled(false);

        salaryTextField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        salaryTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        salaryTextField.setMaximumSize(new java.awt.Dimension(300, 40));
        salaryTextField.setMinimumSize(new java.awt.Dimension(300, 40));
        salaryTextField.setPreferredSize(new java.awt.Dimension(300, 40));

        org.jdesktop.layout.GroupLayout informationPanelLayout = new org.jdesktop.layout.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(informationPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(salaryLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(addressLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(startDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(phoneNumberLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(positonLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, 48, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(addressTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(idTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(positionTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(phoneNumberTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(startDateJDchoose, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(salaryTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, informationPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(idTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(positonLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(positionTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(startDateLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(startDateJDchoose, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(addressTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(addressLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(phoneNumberTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(phoneNumberLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(informationPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(salaryLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(salaryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 30, Short.MAX_VALUE))
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
        addButton.setMinimumSize(new java.awt.Dimension(100, 60));
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
    
    private Employee getEmployee(){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String id = this.idTextField.getText();
            String name = this.nameTextField.getText();
            int position = Integer.valueOf(this.positionTextField.getText());
            String startdate = dateFormat.format(startDateJDchoose.getDate());
            Date ngvl = dateFormat.parse(startdate);
            java.sql.Date sqlngvl = new java.sql.Date(ngvl.getTime());
            String address = this.addressTextField.getText();
            String phonenumber = this.phoneNumberTextField.getText();
            int salary = Integer.valueOf(this.salaryTextField.getText());
            return new Employee(id, name, position, sqlngvl, address, phonenumber, salary);
        }catch(ParseException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    private void addEmployee(Employee employee){
        if (employee.getName().isEmpty() 
            || employee.getAddress().isEmpty()
            || employee.getPhoneNumber().isEmpty()
            || String.valueOf(employee.getSalary()).isEmpty()
            || String.valueOf(employee.getPosition()).isEmpty()
        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if (Employee.insert(employee)){
                    JOptionPane.showMessageDialog(null, "Dữ liệu đã được thêm.", "Thêm nhân viên", 1);
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

    
    private void updateEmployee(Employee employee){
        if (employee.getName().isEmpty() 
            || employee.getAddress().isEmpty()
            || employee.getPhoneNumber().isEmpty()
            || String.valueOf(employee.getSalary()).isEmpty()
            || String.valueOf(employee.getPosition()).isEmpty()
        ){
            JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin.", "Nhập thông tin", 1);
        }
        else{
            try{
                if(Employee.update(employee)){
                    JOptionPane.showMessageDialog(
                        null,
                        "Dữ liệu đã được cập nhật.",
                        "Cập nhật nhân viên",
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
            Employee employee = this.getEmployee();

            if(this.action == 0){
                this.addEmployee(employee);
            }
            else if(this.action == 1){
                this.updateEmployee(employee);
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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metroButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_metroButton2ActionPerformed
/*
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cancelButtonActionPerformed
*/
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private metro.MetroButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private metro.MetroButton cancelButton;
    private javax.swing.JPanel choosePanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JTextField positionTextField;
    private javax.swing.JLabel positonLabel;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JTextField salaryTextField;
    private com.toedter.calendar.JDateChooser startDateJDchoose;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
    private int action;
    private EmployeePanel parent;
}
