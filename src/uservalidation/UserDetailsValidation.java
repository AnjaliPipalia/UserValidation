package uservalidation;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * This is UserDetailsValidation class for validating user details
 *
 * @author arp226
 */
public class UserDetailsValidation extends javax.swing.JFrame {

    /**
     * Creates new form UserValidation
     */
    public UserDetailsValidation() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblSales = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtSales = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validator Test");

        lblName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblName.setText("Name:");

        lblAge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAge.setText("   Age:");

        lblSales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSales.setText(" Sales:");

        btnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblName)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(101, 101, 101)
                                                                .addComponent(btnOk)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnExit))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSales)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSales, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAge)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSales)
                                        .addComponent(txtSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnOk)
                                        .addComponent(btnExit))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {
        if (isNameInvalid()) {
            txtName.requestFocusInWindow();
        } else if (isAgeInvalid()) {
            txtAge.requestFocusInWindow();
        } else if (isSalesInvalid()) {
            txtSales.requestFocusInWindow();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Name: ");
            sb.append(txtName.getText().trim());
            sb.append("\n");
            sb.append("Age: ");
            sb.append(txtAge.getText().trim());
            sb.append("\n");
            sb.append("Sales: $");
            sb.append(new DecimalFormat("#,###.00").format(new Double(txtSales.getText().trim())));
            JOptionPane.showMessageDialog(null, sb.toString(), "Validator Test", JOptionPane.INFORMATION_MESSAGE);

            txtName.setText("");
            txtAge.setText("");
            txtSales.setText("");
            txtName.requestFocusInWindow();
        }
    }

    //Validating Sales Field
    private boolean isSalesInvalid() {
        String sales = txtSales.getText().trim();
        if (sales.matches("[0]+\\d")) {
            txtSales.setText(sales.replaceAll("[0]+", ""));
        }

        if (SwingValidator.isNotEmpty(txtSales, "")) {
            if (!SwingValidator.isDouble(txtSales, "")) {
                JOptionPane.showMessageDialog(null, "Sales does not appear to be a valid number.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sales is a required field.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    //Validating Age Field
    private boolean isAgeInvalid() {
        String age = txtAge.getText().trim();
        if (age.matches("[0]+\\d")) {
            txtAge.setText(age.replaceAll("[0]+", ""));
        }

        if (SwingValidator.isNotEmpty(txtAge, "")) {
            if(txtAge.getText().trim().equals("0")){
                 JOptionPane.showMessageDialog(null, "Age cannot be 0.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                return true;
            }
           else if (!SwingValidator.isInteger(txtAge, "")) {
                JOptionPane.showMessageDialog(null, "Age can only be an Integer value.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Age is a required field.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    // Validating the Name Field
    private boolean isNameInvalid() {
        String name = txtName.getText().trim();
        if (!SwingValidator.isNotEmpty(txtName, "")) {
            JOptionPane.showMessageDialog(null, "Name is a required field.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i]) && !Character.isSpaceChar(chars[i])) {
                JOptionPane.showMessageDialog(null, "Please check the User's name. It contains unsupported characters.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDetailsValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDetailsValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDetailsValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDetailsValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserDetailsValidation().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSales;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSales;
    // End of variables declaration

    private static class SwingValidator {
        static boolean isNotEmpty(JTextField field, String fieldName){
            return !field.getText().isEmpty();
        }

        static boolean isInteger(JTextField field, String fieldName){
            try {
                Integer.parseInt(field.getText().trim());
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        static boolean isDouble(JTextField field, String fieldName){
            try {
                Double.parseDouble(field.getText().trim());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
