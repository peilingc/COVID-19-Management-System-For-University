/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CDC.StaffRole;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CDC_AnalystOrganization;
import Business.Organization.Organization;
import Business.University.Student;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoundDeadWorkRequest;
import Business.WorkQueue.MissingWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jiaqi Wang
 * @author PeiLingChiang
 */
public class CDC_StaffWorkAreaJPanel extends javax.swing.JPanel {
private JPanel upc;
private UserAccount account;
private Organization organization;
private Enterprise enterprise;
private EcoSystem system;
private ArrayList<WorkRequest> Cur_WRList= new ArrayList();
    /**
     * Creates new form CDC_StaffWorkAreaJPanel
     */
    public CDC_StaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.upc=userProcessContainer;
        this.account=account;
        this.organization=organization;
        this.enterprise=enterprise;
        this.system=system;
        populateMissingRequestTable();
    }
    
    private void populateMissingRequestTable(){
        DefaultTableModel model = (DefaultTableModel)tblMissingRequest.getModel();
        model.setRowCount(0);
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof MissingWorkRequest && request.getStatus().equalsIgnoreCase("sent")){
                Cur_WRList.add(request);
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = ((MissingWorkRequest) request).getStudent();
                row[2] = request.getStatus();
                row[3] = request.getResolveDate();
                model.addRow(row);
            }
        }
        tblMissingRequest.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblMissingRequest.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblMissingRequest.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    private void populateRefreshTable(){
        DefaultTableModel model = (DefaultTableModel)tblMissingRequest.getModel();
        model.setRowCount(0);
        for(WorkRequest request : Cur_WRList){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = ((MissingWorkRequest) request).getStudent();
            row[2] = request.getStatus();
            row[3] = request.getResolveDate();
            model.addRow(row);
        }
        tblMissingRequest.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblMissingRequest.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblMissingRequest.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
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
        btnView = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        statusCombobox = new javax.swing.JComboBox<>();
        btnNavigate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMissingRequest = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Investigation of Lost Students");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 15, 377, 49));

        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 160, -1));

        btnConfirm.setText("Confirm Latest Status");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 160, -1));

        statusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Found Dead", "Restore Contact", "Need Hospitalization" }));
        statusCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboboxActionPerformed(evt);
            }
        });
        add(statusCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 204, -1));

        btnNavigate.setText("Navigate Me There");
        btnNavigate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavigateActionPerformed(evt);
            }
        });
        add(btnNavigate, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 160, -1));

        tblMissingRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

// <<<<<<< HEAD
            },
            new String [] {
                "Request Date", "Student's name", "Status", "Resolved Date"
            }
        ));
        jScrollPane2.setViewportView(tblMissingRequest);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 134, 650, 192));

        jLabel2.setText("Missing Request Dashboard");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));
/** =======
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNavigate, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(statusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirm)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnNavigate))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm))
                .addGap(0, 62, Short.MAX_VALUE))
        );
>>>>>>> origin/main **/
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int row = tblMissingRequest.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Student s = (Student)tblMissingRequest.getValueAt(row, 1);
        ViewStudentDetailJPanel vsdJP = new ViewStudentDetailJPanel(upc,s);
        upc.add("ViewStudentDetailJPanel", vsdJP);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        int row = tblMissingRequest.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Student s = (Student)tblMissingRequest.getValueAt(row, 1);
        MissingWorkRequest mwr = (MissingWorkRequest)tblMissingRequest.getValueAt(row, 0);
        if (statusCombobox.getSelectedItem().toString().equalsIgnoreCase("Found dead")){
            s.setContactStatus("");
            s.setTestingStatus("dead");
            mwr.setResolveDate(new Date());
            mwr.setStatus("dead");
            
            //send dead request to CDC_AnalystOrg
            FoundDeadWorkRequest wr = new FoundDeadWorkRequest();
            wr.setMessage(s.getName());
            
            Organization org = null;
            for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (o instanceof CDC_AnalystOrganization){
                    org = o;
                    break;
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(wr);
            }
            populateRefreshTable();
        }
        else if (statusCombobox.getSelectedItem().toString().equalsIgnoreCase("Restore Contact")){
            s.setContactStatus("quarantine");
            s.setQuarantineStartDate(LocalDate.now());
            mwr.setResolveDate(new Date());
            mwr.setStatus("contacted");
            populateRefreshTable();
        }
        else if (statusCombobox.getSelectedItem().toString().equalsIgnoreCase("Need Hospitalization")){
            //if students are going to hospital, set Contact Status to hospital, and change his Registering Status
            s.setContactStatus("hospital");
            s.setRegisteringStatus("Registering");
            mwr.setResolveDate(new Date());
            mwr.setStatus("hospital");
            populateRefreshTable();
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnNavigateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavigateActionPerformed
        // TODO add your handling code here:
        int row = tblMissingRequest.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Student s = (Student)tblMissingRequest.getValueAt(row, 1);
        String address = s.getAddress();
        String zipcode = s.getZipcode();
       
        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.BROWSE)) {
            System.out.println("Desktop does not support browse mode.");
        } 
        else {
            try { 
                address = address.replaceAll(" ", "%20");
                URI uri = new URI("https://www.google.com/maps/dir/?api=1&origin=Boston%20Medical%20Center&destination="+address+"%20"+zipcode+"&travelmode=driving");
                desktop.browse(uri);
            } 
            catch (IOException e) {
                e.printStackTrace();
    
            } 
            catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }  
    }//GEN-LAST:event_btnNavigateActionPerformed

    private void statusComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboboxActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        Cur_WRList.clear();
        DefaultTableModel model = (DefaultTableModel)tblMissingRequest.getModel();
        model.setRowCount(0);
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof MissingWorkRequest && request.getStatus().equalsIgnoreCase("sent")){
                Cur_WRList.add(request);
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = ((MissingWorkRequest) request).getStudent();
                row[2] = request.getStatus();
                row[3] = request.getResolveDate();
                model.addRow(row);
            }
        }
        tblMissingRequest.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblMissingRequest.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblMissingRequest.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnNavigate;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> statusCombobox;
    private javax.swing.JTable tblMissingRequest;
    // End of variables declaration//GEN-END:variables

}    

