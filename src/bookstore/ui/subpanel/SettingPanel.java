/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.ui.subpanel;

/** Thôi em làm đi, biết làm đổi mật khẩu ko, đó v em làm đi, muốn làm sao cũng đc, ko thì bỏ đi
 * để cái nhỏ nhỏ ở gốc thôi, thì em để đi, tự em làm cho đẹp thì em tự sửa, anh thích v
 * mà tên dài quá cái đó 1 dòng chứa ko hết, thì phải nhỏ thôi
 * cái đó nó ko quan trọng thì để nhỏ, chứ để to làm gì
 *
 * @author DELL
 */
public class SettingPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingPanel
     */
    public SettingPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        infoPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel3 = new javax.swing.JPanel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel2 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        actionPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        changePasswordButton = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        changePasswordButton1 = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
        add(filler12);

        infoPanel.setAlignmentX(0.5f);
        infoPanel.setMaximumSize(new java.awt.Dimension(32000, 100));
        infoPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        infoPanel.setLayout(new javax.swing.BoxLayout(infoPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(filler2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Mật khẩu cũ");
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel1.setMinimumSize(new java.awt.Dimension(10, 10));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel1.add(jLabel1);

        jPasswordField1.setMaximumSize(new java.awt.Dimension(200, 25));
        jPasswordField1.setMinimumSize(new java.awt.Dimension(200, 25));
        jPasswordField1.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel1.add(jPasswordField1);
        jPanel1.add(filler4);

        infoPanel.add(jPanel1);
        infoPanel.add(filler10);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(filler7);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mật khẩu mới");
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel2.setMinimumSize(new java.awt.Dimension(10, 10));
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel3.add(jLabel2);

        jPasswordField2.setMaximumSize(new java.awt.Dimension(200, 25));
        jPasswordField2.setMinimumSize(new java.awt.Dimension(200, 25));
        jPasswordField2.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(jPasswordField2);
        jPanel3.add(filler8);

        infoPanel.add(jPanel3);

        add(infoPanel);
        add(filler9);

        actionPanel.setAlignmentX(0.5f);
        actionPanel.setAlignmentY(0.5F);
        actionPanel.setMaximumSize(new java.awt.Dimension(32000, 200));
        actionPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        actionPanel.setPreferredSize(new java.awt.Dimension(426, 150));
        actionPanel.setLayout(new javax.swing.BoxLayout(actionPanel, javax.swing.BoxLayout.PAGE_AXIS));
        actionPanel.add(filler1);

        changePasswordButton.setBackground(new java.awt.Color(0, 153, 255));
        changePasswordButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        changePasswordButton.setForeground(new java.awt.Color(255, 255, 255));
        changePasswordButton.setText("Đổi mật khẩu");
        changePasswordButton.setAlignmentX(0.5F);
        changePasswordButton.setMaximumSize(new java.awt.Dimension(200, 50));
        changePasswordButton.setMinimumSize(new java.awt.Dimension(10, 10));
        changePasswordButton.setPreferredSize(new java.awt.Dimension(200, 50));
        actionPanel.add(changePasswordButton);
        actionPanel.add(filler11);

        changePasswordButton1.setBackground(new java.awt.Color(0, 153, 255));
        changePasswordButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        changePasswordButton1.setForeground(new java.awt.Color(255, 255, 255));
        changePasswordButton1.setText("Đăng xuất");
        changePasswordButton1.setAlignmentX(0.5F);
        changePasswordButton1.setMaximumSize(new java.awt.Dimension(200, 50));
        changePasswordButton1.setMinimumSize(new java.awt.Dimension(10, 10));
        changePasswordButton1.setPreferredSize(new java.awt.Dimension(200, 50));
        actionPanel.add(changePasswordButton1);
        actionPanel.add(filler3);

        add(actionPanel);
        add(filler5);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton changePasswordButton1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    // End of variables declaration//GEN-END:variables
}