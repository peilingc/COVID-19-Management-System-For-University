/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Hospital.DoctorRole;

import Busines.EcoSystem;
import Business.Enterprise.CDC_MedicalTeamEnterprise;
import Business.Enterprise.Enterprise;
import Business.Hospital.Doctor;
import Business.Hospital.Patient;
import Business.Hospital.Ward;
import Business.Network.Network;
import Business.Organization.CDC_AnalystOrganization;
import Business.Organization.Organization;
import Business.University.Student;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoundDeadWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PeiLingChiang
 */
public class PatientManagementJPanel extends javax.swing.JPanel {
    private JPanel upc;
    private UserAccount account;
    private Organization organization;
    private EcoSystem system;
    private Doctor doctor;
    private Patient patient;

    /**
     * Creates new form PatientManagementJPanel
     */
 
    PatientManagementJPanel(JPanel upc, UserAccount account, Organization organization, EcoSystem system, Doctor doctor) {
        initComponents();
        this.upc = upc;
        this.account = account;
        this.organization = organization;
        this.system = system;
        this.doctor = doctor;
        
        populateRegisteredTable();
        txaPrescription.setEnabled(false);
        btnSubmitP.setEnabled(false);
        tblWard.setEnabled(false);
        btnSubmitW.setEnabled(false);
    }
  
    
    public void populateRegisteredTable() {
        DefaultTableModel model = (DefaultTableModel)tblRegistered.getModel();
        model.setRowCount(0);
        for(Patient p : doctor.getPatientDirentory().getPatientList()){
            if(p.getStudent().getRegisteringStatus().equals("registered")){
                Object row[] = new Object[5];
                row[0] = p;
                row[1] = p.getSymptoms();
                row[2] = p.getWardID() ==0 ? "" : p.getWardID();
                row[3] = p.getPrescription();
                row[4] = !(p.getStudent().getTestingStatus().equals("immune") 
                            || p.getStudent().getTestingStatus().equals("dead") ) 
                                ? "curing": p.getStudent().getTestingStatus();
               model.addRow(row);
            }
        }
    }
    
    private void populateWardTable() {
        DefaultTableModel model = (DefaultTableModel)tblWard.getModel();
        model.setRowCount(0);  
        for(Ward w : system.getWardDir().getWardList()){
            if (w.getRemainingBeds()!=0){
                Object row[] = new Object[4];
                row[0] = w;
                row[1] = w.getDepartment();
                row[2] = w.getRemainingBeds();
                row[3] = w.getCapacity();                   
                model.addRow(row);
            }    
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistered = new javax.swing.JTable();
        btnViewDetail = new javax.swing.JButton();
        situationCombobox = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnWard = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaPrescription = new javax.swing.JTextArea();
        btnSubmitP = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblWard = new javax.swing.JTable();
        btnSubmitW = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Patient Management");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 6, 270, -1));

        tblRegistered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient's Name", "Symptom(s)", "Ward", "Prescription", "Health Status"
            }
        ));
        jScrollPane1.setViewportView(tblRegistered);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 592, 110));

        btnViewDetail.setText("View Patient Details >>");
        btnViewDetail.setMaximumSize(new java.awt.Dimension(164, 29));
        btnViewDetail.setMinimumSize(new java.awt.Dimension(164, 29));
        btnViewDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailActionPerformed(evt);
            }
        });
        add(btnViewDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 210, -1));

        situationCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dead", "immune" }));
        situationCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                situationComboboxActionPerformed(evt);
            }
        });
        add(situationCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        btnSubmit.setText("Submit Current Situation");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 230, 210, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        btnPre.setText("Make Prescription >>");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        btnWard.setText("Arrange Ward >>");
        btnWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWardActionPerformed(evt);
            }
        });
        add(btnWard, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 160, -1));

        txaPrescription.setColumns(20);
        txaPrescription.setRows(5);
        txaPrescription.setEnabled(false);
        jScrollPane3.setViewportView(txaPrescription);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 580, 50));

        btnSubmitP.setText("Submit");
        btnSubmitP.setEnabled(false);
        btnSubmitP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPActionPerformed(evt);
            }
        });
        add(btnSubmitP, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 106, -1));

        tblWard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ward ID", "Department", "Remaining Beds", "capacity"
            }
        ));
        tblWard.setEnabled(false);
        jScrollPane2.setViewportView(tblWard);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 580, 100));

        btnSubmitW.setText("Submit");
        btnSubmitW.setEnabled(false);
        btnSubmitW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitWActionPerformed(evt);
            }
        });
        add(btnSubmitW, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, 106, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailActionPerformed
        // TODO add your handling code here:
        int row = tblRegistered.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        Patient p = (Patient)tblRegistered.getValueAt(row, 0);
        ViewPatientJPanel vpJP = new ViewPatientJPanel(upc, p.getStudent());
        upc.add("ViewPatientJPanel", vpJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_btnViewDetailActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        int row = tblRegistered.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Patient p = (Patient)tblRegistered.getValueAt(row, 0);
        
        p.getStudent().setTestingStatus(situationCombobox.getSelectedItem().toString());
        String s = situationCombobox.getSelectedItem().toString();
        
        JOptionPane.showMessageDialog(null, "Patient's latest situation updated successfully!");
        
        if (s.equalsIgnoreCase("dead")){
            p.getStudent().setContactStatus("");
            p.getStudent().setTestingStatus("dead");
            FoundDeadWorkRequest wr = new FoundDeadWorkRequest();
            wr.setMessage(p.getStudent().getName());
            
            Organization org = null;
            for(Network network : system.getNetworkList()){
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    if (e instanceof CDC_MedicalTeamEnterprise){
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            if (o instanceof CDC_AnalystOrganization){
                                org = o;
                                break;
                            }
                        }
                        if (org!=null){
                            org.getWorkQueue().getWorkRequestList().add(wr);
                        }
                    }
                }
            }
            
        }
        
        
        populateRegisteredTable();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void situationComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_situationComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_situationComboboxActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        int row = tblRegistered.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        patient = (Patient)tblRegistered.getValueAt(row, 0);
        
        txaPrescription.setEnabled(true);
        btnSubmitP.setEnabled(true);
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWardActionPerformed
        // TODO add your handling code here:
        int row = tblRegistered.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        patient = (Patient)tblRegistered.getValueAt(row, 0); 
        
        tblWard.setEnabled(true);
        btnSubmitW.setEnabled(true);
        populateWardTable();
    }//GEN-LAST:event_btnWardActionPerformed

    private void btnSubmitPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPActionPerformed
        // TODO add your handling code here:
        patient.setPrescription(txaPrescription.getText());
        txaPrescription.setEnabled(false);
        btnSubmitP.setEnabled(false);
        populateRegisteredTable();
    }//GEN-LAST:event_btnSubmitPActionPerformed

    private void btnSubmitWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitWActionPerformed
        // TODO add your handling code here:
        int row = tblWard.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try{
            //if already have a ward
            int wid = patient.getWardID();
            Ward originalWard = system.getWardDir().searchWard(wid);
            
            //add back original one
            originalWard.setRemainingBeds(originalWard.getRemainingBeds()+1);
        }
        
        catch(Exception e){
        }
        
        finally{
            Ward w = (Ward)tblWard.getValueAt(row, 0);
            w.setRemainingBeds(w.getRemainingBeds()-1);
            patient.setWardID(w.getWardID());
        }
        
        tblWard.setEnabled(false);
        btnSubmitW.setEnabled(false);
        populateRegisteredTable();
        populateWardTable();
    }//GEN-LAST:event_btnSubmitWActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmitP;
    private javax.swing.JButton btnSubmitW;
    private javax.swing.JButton btnViewDetail;
    private javax.swing.JButton btnWard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> situationCombobox;
    private javax.swing.JTable tblRegistered;
    private javax.swing.JTable tblWard;
    private javax.swing.JTextArea txaPrescription;
    // End of variables declaration//GEN-END:variables

}
