
package userinterface.PharmaceuticalManufacturer.CompanyAdminRole;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Pharmaceutical_Manufacturer.Supplier;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jiaqi Wang
 */
public class ManageSuppliersJPanel extends javax.swing.JPanel {
  private JPanel userProcessContainer;
    private EcoSystem system;
    private Supplier supplier;
    
    public ManageSuppliersJPanel(JPanel userprocesscontainer, EcoSystem system) {
      initComponents();
        this.userProcessContainer=userprocesscontainer;
        this.system=system;
        

       populateTable();   
       
       txtName.setEnabled(false);
       txtFrom.setEnabled(false);
       
       btnSubmit.setEnabled(false);
       btnUpdate.setEnabled(false); 
    }
  
    public void populateTable(){
         DefaultTableModel model = (DefaultTableModel)tblsup.getModel();
        model.setRowCount(0);
        for (Supplier s:this.system.getSupplierDirectory().getSupplierlist()){
            Object[] row = new Object[2];
            row[0] = s;
            row[1] = s.getCompanyRegistrationPlace();
            model.addRow(row);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRemove = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnAddSupplier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblFrom = new javax.swing.JLabel();
        lnlName = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSuoName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsup = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemove.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnRemove.setText("Remove Supplier");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 269, 195, -1));

        btnView.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnView.setText("View Supplier");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 130, -1));

        btnAddSupplier.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnAddSupplier.setText("Add Supplier");
        btnAddSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplierActionPerformed(evt);
            }
        });
        add(btnAddSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 130, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        jLabel1.setText("Manage Suppliers");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 0, -1, 32));
        add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 222, 152, 27));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 185, 152, 27));

        lblFrom.setFont(new java.awt.Font("微软雅黑 Light", 1, 14)); // NOI18N
        lblFrom.setText("From:");
        add(lblFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 219, 70, 31));

        lnlName.setFont(new java.awt.Font("微软雅黑 Light", 1, 14)); // NOI18N
        lnlName.setText("Name:");
        add(lnlName, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 182, 70, 31));

        btnSubmit.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 268, 99, 30));

        btnUpdate.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 51, 0));
        btnUpdate.setText("Update Supplier");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 269, 160, -1));

        jLabel2.setText("Please enter supplier's name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 110, -1, -1));
        add(txtSuoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 110, 120, -1));

        btnSearch.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 110, -1, -1));

        tblsup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier's Name", "Registration Country"
            }
        ));
        jScrollPane1.setViewportView(tblsup);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 145, 407, 118));

        jButton1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jButton1.setText("Modify ProductCatalog");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 308, -1, -1));

        backJButton.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 471, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = tblsup.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Supplier s = (Supplier) tblsup.getValueAt(row, 0);
        system.getSupplierDirectory().getSupplierlist().remove(s);

        populateTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
      int row = tblsup.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        supplier= (Supplier)tblsup.getValueAt(row, 0);
        
        txtName.setText(supplier.getSuppliername());
        txtFrom.setText(supplier.getCompanyRegistrationPlace());

        
        btnUpdate.setEnabled(true);
        txtName.setEnabled(true);
        txtFrom.setEnabled(true);

    }//GEN-LAST:event_btnViewActionPerformed

    private void btnAddSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplierActionPerformed
       txtName.setText("");
        txtFrom.setText("");
        
        btnSubmit.setEnabled(true);
        txtName.setEnabled(true);
       txtFrom.setEnabled(true);
    }//GEN-LAST:event_btnAddSupplierActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String name = txtName.getText();
        String from=txtFrom.getText();
        
        if (txtName.getText().length()==0 ||txtFrom.getText().length()==0 ){
            JOptionPane.showMessageDialog(null, "Please ensure all fields are entered!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (system.getSupplierDirectory().searchSupplier(name)!=null) {
            JOptionPane.showMessageDialog(null, "Supplier already exist!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
        } 
        Supplier sup=new Supplier();
        sup.setSuppliername(name);
        sup.setCompanyRegistrationPlace(from);
        system.getSupplierDirectory().getSupplierlist().add(sup);
        
        JOptionPane.showMessageDialog(null, "Successfully created!");
       populateTable();
        txtName.setEnabled(false);
        txtFrom.setEnabled(false);
        btnSubmit.setEnabled(false);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String name = txtName.getText();
        String from=txtFrom.getText();
     
        if (txtName.getText().length()==0 || txtFrom.getText().length()==0 )
        {
            JOptionPane.showMessageDialog(null, "Please ensure all fields are entered!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

       supplier.setCompanyRegistrationPlace(from);
       supplier.setSuppliername(name);
        
        JOptionPane.showMessageDialog(null, "Successfully updated!");
       populateTable();
        txtName.setEnabled(false);
        txtFrom.setEnabled(false);
        btnSubmit.setEnabled(false);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String supName = txtSuoName.getText();
        refreshTable(supName);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int row = tblsup.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        supplier= (Supplier)tblsup.getValueAt(row, 0);
        
          ManageProductJPanel mpJP= new  ManageProductJPanel(userProcessContainer,supplier);
        userProcessContainer.add("ManageProductJPanel", mpJP);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAddSupplier;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lnlName;
    private javax.swing.JTable tblsup;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSuoName;
    // End of variables declaration//GEN-END:variables

    private void refreshTable(String supName) {
        DefaultTableModel model = (DefaultTableModel)tblsup.getModel();
        model.setRowCount(0);
        for (Supplier s:system.getSupplierDirectory().getSupplierlist()){
            if (s.getSuppliername().equalsIgnoreCase(supName)){
                Object[] row = new Object[2];
                row[0] = s;
                row[1] = s.getCompanyRegistrationPlace();
                model.addRow(row);
            }
        }
    }
}
