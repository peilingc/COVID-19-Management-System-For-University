/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Hospital.HospitalAdminRole;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Hospital.DoctorDirectory;
import Business.Hospital.PatientDirectory;
import Business.Hospital.WardDirectory;
import Business.Organization.Organization;
import Business.Pharmaceutical_Manufacturer.MasterOrderCatalog;
import Business.Pharmaceutical_Manufacturer.SupplierDirectory;
import Business.University.StudentDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import userinterface.PharmaceuticalManufacturer.Purchase.PurchaseJPanel;
import userinterface.PharmaceuticalManufacturer.Purchase.ViewProductDetailJPanel;

/**
 *
 * @author Jiaqi Wang
 */
public class HospitalAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel upc;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem system;

    /**
     * Creates new form HospitalAdminWorkAreaJPanel
     */
    public HospitalAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.upc = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;

        ImageIcon ii = new ImageIcon("src/images/im_doctor.png");
        ii.setImage(ii.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
//        (width, height,Image.SCALE_DEFAULT )
        lblDoc.setSize(120, 120);
        lblDoc.setIcon(ii);

        ImageIcon ii1 = new ImageIcon("src/images/im_patient.png");
        ii1.setImage(ii1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
//        (width, height,Image.SCALE_DEFAULT )
        lblPatient.setSize(120, 120);
        lblPatient.setIcon(ii1);

        ImageIcon ii2 = new ImageIcon("src/images/im_ward.png");
        ii2.setImage(ii2.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
//        (width, height,Image.SCALE_DEFAULT )
        lblWard.setSize(120, 120);
        lblWard.setIcon(ii2);

        ImageIcon ii3 = new ImageIcon("src/images/im_drug.png");
        ii3.setImage(ii3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
//        (width, height,Image.SCALE_DEFAULT )
        lblDrug.setSize(120, 120);
        lblDrug.setIcon(ii3);

        ImageIcon ii4 = new ImageIcon("src/images/im_money.png");
        ii4.setImage(ii4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
//        (width, height,Image.SCALE_DEFAULT )
        lblFinan.setSize(120, 120);
        lblFinan.setIcon(ii4);

        
                 ImageIcon ii5= new ImageIcon("src/images/cart.png");
        ii5.setImage(ii5.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
//        (width, height,Image.SCALE_DEFAULT )
        lblCart.setSize(120, 120);
        lblCart.setIcon(ii5);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPatient = new javax.swing.JLabel();
        lblWard = new javax.swing.JLabel();
        lblDrug = new javax.swing.JLabel();
        lblDoc = new javax.swing.JLabel();
        btnDoc = new javax.swing.JButton();
        brnWard = new javax.swing.JButton();
        brnDrug = new javax.swing.JButton();
        btnPatient = new javax.swing.JButton();

        btnFinan = new javax.swing.JButton();
        lblFinan = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblCart = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(lblPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 130));
        add(lblWard, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 135, 130));
        add(lblDrug, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 150, 120));
        add(lblDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 160, 140));

        btnDoc.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N

        btnDoc.setText("Doctor Management");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        add(btnDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        brnWard.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N

        brnWard.setText("Ward Management");
        brnWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnWardActionPerformed(evt);
            }
        });

        add(brnWard, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, -1, -1));

        brnDrug.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N

        brnDrug.setText("Drug management");
        brnDrug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnDrugActionPerformed(evt);
            }
        });

        add(brnDrug, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        btnPatient.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N

        btnPatient.setText("Patient Management");
        btnPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientActionPerformed(evt);
            }
        });

        add(btnPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        btnFinan.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnFinan.setText("Financial Management");
        btnFinan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanActionPerformed(evt);
            }
        });
        add(btnFinan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));
        add(lblFinan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 150, 140));

        jButton1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jButton1.setText("Purchasement Manage");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, -1, -1));
        add(lblCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 181, 120));

    }// </editor-fold>//GEN-END:initComponents

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        // TODO add your handling code here:
        DoctorManagementJPanel dmJP = new DoctorManagementJPanel(upc, enterprise, system);
        upc.add(" DoctorManagementJPanel", dmJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_btnDocActionPerformed

    private void btnPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientActionPerformed
        // TODO add your handling code here:
        PatientManagementJPanel pmJP = new PatientManagementJPanel(upc, enterprise, system.getPatientDir());
        upc.add("PatientManagementJPanel", pmJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_btnPatientActionPerformed

    private void brnWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnWardActionPerformed
        // TODO add your handling code here:
        WardManagementJPanel wmJP = new WardManagementJPanel(upc, system.getWardDir());
        upc.add("WardManagementJPanel", wmJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_brnWardActionPerformed

    private void brnDrugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnDrugActionPerformed
        // TODO add your handling code here:


        DrugManagementJPanel dmJP = new DrugManagementJPanel(upc, account, enterprise, system);

        upc.add("DrugManagementJPanel", dmJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_brnDrugActionPerformed


    private void btnFinanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanActionPerformed
        // TODO add your handling code here:
        FinanceManagementJPanel fmJP = new FinanceManagementJPanel(upc, account,organization, enterprise);
        upc.add(" FinanceManagementJPanel", fmJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_btnFinanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        PurchaseJPanel  crwJP= new PurchaseJPanel(upc,account,enterprise,system);
        upc.add(" CustomerRoleWorkAreaJPanel ", crwJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnDrug;

    private javax.swing.JButton brnWard;
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnFinan;
    private javax.swing.JButton btnPatient;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCart;

    private javax.swing.JLabel lblDoc;
    private javax.swing.JLabel lblDrug;
    private javax.swing.JLabel lblFinan;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblWard;
    // End of variables declaration//GEN-END:variables
}