/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.QuarantineStaffRole;

import Busines.EcoSystem;
import Business.Enterprise.CDC_MedicalTeamEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CDC_StaffOrganization;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.Role.StudentRole;
import Business.University.Student;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CheckWorkRequest;
import Business.WorkQueue.MissingWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PeiLingChiang
 */
public class ManageJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    EcoSystem business;
    
    /**
     * Creates new form ManageJPanel
     */
     public ManageJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
        populateCheckRequestTable();
        populateMissingTable();
        populateMissingRequestTable();
        populateQuarantineTable();
    }
    
    public void populateCheckRequestTable(){
        DefaultTableModel model = (DefaultTableModel)tblCheckRequest.getModel();
        model.setRowCount(0);
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof CheckWorkRequest){
                Object[] row = new Object[3];
                row[0] = request.getRequestDate();
                row[1] = request.getSender();
                row[2] = request.getStatus();
                model.addRow(row);
            }
        }
        tblCheckRequest.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblCheckRequest.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    public void populateMissingTable(){
        
        //find students in quarantine and store in a list
        ArrayList<Student> student_quarantine = new ArrayList();
        for (Student s : business.getStudentDir().getStudentList()){
            //Qurantine students but not come in to quarantine today
            if (s.getContactStatus().equals("quarantine") && !s.getQuarantineStartDate().isEqual(LocalDate.now())){
                student_quarantine.add(s);
            }
        }

        
        //create a list to store student's useraccount
        ArrayList<UserAccount> temp = new ArrayList();
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (o instanceof StudentOrganization){
                temp = o.getUserAccountDirectory().getUserAccountList();
            }
        }

        
        //find students in quarantine who have CheckWorkRequest yesterday, and remove from the list
        //for each student's useraccount in student useraccount list
        for(UserAccount ua : temp){
            if (((Student)ua.getPerson()).getContactStatus().equals("quarantine") 
                && !((Student)ua.getPerson()).getQuarantineStartDate().isEqual(LocalDate.now())){
                for (WorkRequest wr : ua.getWorkQueue().getWorkRequestList()){
                    Date input = wr.getRequestDate();
                    LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    
                    /**
                     * test
                     *
                    System.out.println("ua: "+ua+" original: "+input+" New: "+date);
                    System.out.println("Equal to today? : "+date.isEqual(LocalDate.now()));
                    System.out.println("Equal to yesterday? : "+date.isEqual(LocalDate.now().minusDays(1)));
                    * 
                    **/
                    
                    if (wr instanceof CheckWorkRequest && date.isEqual(LocalDate.now().minusDays(1))){
                        student_quarantine.remove((Student)wr.getSender().getPerson());
                    }
                }
            }
        }

        
        //only students in quarantine who didn't send checkWorkRequest yesterday left in the list
        DefaultTableModel model = (DefaultTableModel)tblMissing1.getModel();
        model.setRowCount(0);
        for (Student s :student_quarantine){
            Object[] row = new Object[1];
            row[0] = s;
            model.addRow(row);
        }
    }
    
    public void populateMissingRequestTable(){
        DefaultTableModel model = (DefaultTableModel)tblMissingRequest.getModel();
        model.setRowCount(0);
        for(WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if (request instanceof MissingWorkRequest){
                Object[] row = new Object[4];
                row[0] = request.getRequestDate();
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
    
    public void populateQuarantineTable(){
        DefaultTableModel model = (DefaultTableModel)tblQuarantine.getModel();
        model.setRowCount(0);
        for(Student s : business.getStudentDir().getStudentList()){

            if (s.getContactStatus().equals("quarantine")){
                Object[] row = new Object[1];
                row[0] = s;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCheckRequest = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuarantine = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMissingRequest = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMissing1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCheckRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Date", "Sender", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblCheckRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 400, 197));

        tblQuarantine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane2.setViewportView(tblQuarantine);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 130, 200));

        jLabel1.setText("Daily Wellness Check DashBoard");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel2.setText("Quarantine Students");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        btnSend.setText("Send Request to CDC");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 170, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, -1));

        tblMissingRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Date", "Student's Name", "Status", "Resolved Date"
            }
        ));
        jScrollPane3.setViewportView(tblMissingRequest);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 750, 170));

        jLabel3.setText("Missing Request Dashboard");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        tblMissing1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane4.setViewportView(tblMissing1);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 120, 200));

        jLabel4.setText("Missing Students");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMissing1.getSelectedRow();
        if (selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else {
            Student student = (Student)tblMissing1.getValueAt(selectedRow, 0);
            student.setContactStatus("losing contact");
            
            //create a missing request
            MissingWorkRequest wr = new MissingWorkRequest();
            wr.setSender(account);
            wr.setStatus("sent");
            wr.setStudent(student);
            
            Organization org = null;
            for(Network network : business.getNetworkList()){
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    if (e instanceof CDC_MedicalTeamEnterprise){
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            if (o instanceof CDC_StaffOrganization){
                                org = o;
                                break;
                            }
                        }
                        if (org!=null){
                            org.getWorkQueue().getWorkRequestList().add(wr);
                            account.getWorkQueue().getWorkRequestList().add(wr);
                        }
                    }
                }
            }
            populateMissingTable();
            populateMissingRequestTable();
        }
    }//GEN-LAST:event_btnSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblCheckRequest;
    private javax.swing.JTable tblMissing1;
    private javax.swing.JTable tblMissingRequest;
    private javax.swing.JTable tblQuarantine;
    // End of variables declaration//GEN-END:variables
}
