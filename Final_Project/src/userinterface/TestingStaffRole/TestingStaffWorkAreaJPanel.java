/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TestingStaffRole;

import Busines.EcoSystem;
import Business.Organization.Organization;
import Business.University.Student;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestingWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PeiLingChiang
 */
public class TestingStaffWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    UserAccount userAccount;
    Organization organization;
    WorkRequest wr;
    EcoSystem business;
    
    /**
     * Creates new form TestingStaffWorkAreaJPanel
     */
    public TestingStaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.business = business;
        
        populateTable();
        rbNegative.setEnabled(false);
        rbPositive.setEnabled(false);
        btnSubmit.setEnabled(false);
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)tblRequest.getModel();
        model.setRowCount(0);
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof TestingWorkRequest){
                Object[] row = new Object[5];
                row[0] = request.getRequestDate();
                row[1] = request.getReceiver() == null ? null : request.getReceiver();
                row[2] = request;
                row[3] = request.getStatus();
                String result = ((TestingWorkRequest) request).getTestResult();
                row[4] = result == null ? "waiting" : result;
                model.addRow(row);
            }
        }
        tblRequest.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblRequest.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        txtAssign = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        rbNegative = new javax.swing.JRadioButton();
        rbPositive = new javax.swing.JRadioButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Date", "Receiver", "Sender", "Status", "Result"
            }
        ));
        jScrollPane1.setViewportView(tblRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 574, 139));

        txtAssign.setText("Assign to me");
        txtAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAssignActionPerformed(evt);
            }
        });
        add(txtAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        jLabel1.setText("Result: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 50, 20));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, -1, -1));

        buttonGroup1.add(rbNegative);
        rbNegative.setText("Negative");
        rbNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNegativeActionPerformed(evt);
            }
        });
        add(rbNegative, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        buttonGroup1.add(rbPositive);
        rbPositive.setText("Positive");
        rbPositive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPositiveActionPerformed(evt);
            }
        });
        add(rbPositive, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        wr = (WorkRequest)tblRequest.getValueAt(selectedRow, 2);
        if (selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else if (wr.getStatus().equals("completed")){
            JOptionPane.showMessageDialog(null, "The test has been completed!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            wr.setReceiver(userAccount);
            rbNegative.setEnabled(true);
            rbPositive.setEnabled(true);
            btnSubmit.setEnabled(true);
        }
        populateTable();
    }//GEN-LAST:event_txtAssignActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        wr.setStatus("completed");
        if (rbNegative.isSelected()) {
            ((TestingWorkRequest) wr).setTestResult("negative");
            ((Student)wr.getSender().getPerson()).setTestingStatus("negative");
        }
        else {
            ((TestingWorkRequest) wr).setTestResult("positive");
            ((Student)wr.getSender().getPerson()).setTestingStatus("positive");
        }
        
        populateTable();
        buttonGroup1.clearSelection();
        rbNegative.setEnabled(false);
        rbPositive.setEnabled(false);
        btnSubmit.setEnabled(false);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void rbNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNegativeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNegativeActionPerformed

    private void rbPositiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPositiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPositiveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNegative;
    private javax.swing.JRadioButton rbPositive;
    private javax.swing.JTable tblRequest;
    private javax.swing.JButton txtAssign;
    // End of variables declaration//GEN-END:variables
}