/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmaceuticalManufacturer.Purchase;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmaceuticalManufacturerEnterprise;
import Business.Network.Network;
import Business.Organization.CompanyAdminOrganization;
import Business.Organization.Organization;
import Business.Organization.QuarantineOrganization;
import Business.Pharmaceutical_Manufacturer.MasterOrderCatalog;
import Business.Pharmaceutical_Manufacturer.Order;
import Business.Pharmaceutical_Manufacturer.OrderItem;
import Business.Pharmaceutical_Manufacturer.Product;
import Business.Pharmaceutical_Manufacturer.Supplier;
import Business.Pharmaceutical_Manufacturer.SupplierDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BP_SendOrderWorkRequest;
import Business.WorkQueue.CheckWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.Hospital.HospitalAdminRole.DrugManagementJPanel;

/**
 *
 * @author Jiaqi Wang
 */


public class PurchaseJPanel extends javax.swing.JPanel {

   private JPanel userprocesscontainer;
   private UserAccount account;
   private Enterprise enterprise;
//private SupplierDirectory supplierDir;
//private MasterOrderCatalog moc;
   private EcoSystem system;
private Order order;
private boolean isCheckedOut=false;

    /** Creates new form BrowseProducts */
    public PurchaseJPanel(JPanel upc,UserAccount account,Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.userprocesscontainer=upc;
        this.account=account;
        this.enterprise=enterprise;
        this.system=system;
        populateTable();
        if (!isCheckedOut) 
        order=new Order();
        
ImageIcon ii1=new ImageIcon("src/images/im_drug.png");
      ii1.setImage(ii1.getImage().getScaledInstance(100,100 ,Image.SCALE_DEFAULT ));
//        (width, height,Image.SCALE_DEFAULT )
        lblImage.setSize(100, 100);
        lblImage.setIcon(ii1);
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
        lblImage = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        supJTable = new javax.swing.JTable();
        btnViewProdDetail = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        QuantitySpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        btnAddtoCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnViewItemDetail = new javax.swing.JButton();
        txtModifiedQuantity = new javax.swing.JTextField();
        btnModifyQuan = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        requestJTable = new javax.swing.JTable();
        backJButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("方正粗黑宋简体", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Welcome To the Pharmaceutical Trading Center!!!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 0, 493, 66));
        add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 128, 110));
        add(txtProdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 76, 97, -1));

        btnSearch.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnSearch.setText("Search Product By Name");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 72, -1, -1));

        supJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Product ID", "Current Availability", "Cost Price"
            }
        ));
        jScrollPane1.setViewportView(supJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 130, 561, 94));

        btnViewProdDetail.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnViewProdDetail.setText("View Selected Product's Detail");
        btnViewProdDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProdDetailActionPerformed(evt);
            }
        });
        add(btnViewProdDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("微软雅黑 Light", 3, 14)); // NOI18N
        jLabel3.setText("Sales Price:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 230, -1, -1));
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 231, 54, -1));

        jLabel4.setFont(new java.awt.Font("方正粗黑宋简体", 3, 14)); // NOI18N
        jLabel4.setText(" product catalog");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, -1));
        add(QuantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 231, -1, -1));

        jLabel5.setFont(new java.awt.Font("微软雅黑 Light", 3, 14)); // NOI18N
        jLabel5.setText("Quantity:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 230, -1, -1));

        btnAddtoCart.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnAddtoCart.setText("Add to Cart");
        btnAddtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoCartActionPerformed(evt);
            }
        });
        add(btnAddtoCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 258, -1, -1));

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Item Price", "Item Quantity", "Total Cost"
            }
        ));
        jScrollPane2.setViewportView(orderJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 314, 561, 94));

        jLabel6.setFont(new java.awt.Font("方正粗黑宋简体", 3, 14)); // NOI18N
        jLabel6.setText("Order Request");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, -1, -1));

        btnViewItemDetail.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnViewItemDetail.setText("View Selected Item's Detail");
        btnViewItemDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewItemDetailActionPerformed(evt);
            }
        });
        add(btnViewItemDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 414, 233, -1));
        add(txtModifiedQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 414, 52, 27));

        btnModifyQuan.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnModifyQuan.setText("Modify the Quantity");
        btnModifyQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyQuanActionPerformed(evt);
            }
        });
        add(btnModifyQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 414, -1, -1));

        btnRemoveItem.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnRemoveItem.setText("Remove From Cart");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });
        add(btnRemoveItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 447, 197, -1));

        btnCheckout.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnCheckout.setText("Send Order request");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });
        add(btnCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 447, -1, -1));

        requestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Request Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(requestJTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 561, 92));

        backJButton2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        backJButton2.setText("<< Back");
        backJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton2ActionPerformed(evt);
            }
        });
        add(backJButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        jLabel7.setFont(new java.awt.Font("方正粗黑宋简体", 3, 14)); // NOI18N
        jLabel7.setText("Customer's Temporary shopping cart");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         String productName=txtProdName.getText();
        refreshProductTable(productName);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewProdDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProdDetailActionPerformed
        // TODO add your handling code here:
           int row = supJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, ",Your selection is null,Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        Product p = (Product)supJTable.getValueAt(row, 0);
        ViewProductDetailJPanel vpdJP = new ViewProductDetailJPanel(userprocesscontainer, p);
        userprocesscontainer.add("ViewProductDetailJPanel", vpdJP);
        CardLayout layout = (CardLayout) userprocesscontainer.getLayout();
        layout.next(userprocesscontainer);
        
    }//GEN-LAST:event_btnViewProdDetailActionPerformed

    private void btnAddtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoCartActionPerformed
        // TODO add your handling code here:
         int selectedRow=supJTable.getSelectedRow();
        if(selectedRow<0){
        JOptionPane.showMessageDialog(null, ",Your selection is null,Please Select a row");
        return;
        }
       Product selectedProduct=(Product)supJTable.getValueAt(selectedRow, 0);
       int selection=(Integer)QuantitySpinner.getValue();
       if(selection<=0){
       JOptionPane.showMessageDialog(null, "Quantity cannot be less than  0");
       return;
       }
       try{
           double salesPrice=Double.parseDouble(txtPrice.getText());
           if (salesPrice<=selectedProduct.getPrice()) {
               JOptionPane.showMessageDialog(null, "SalesPrice cannot be less than actual price");
               return;
           }
           if (selection<=selectedProduct.getAvail()) {
               boolean alreadyPresent=false;
               for(OrderItem oi:order.getOrderItemList()){
               if(oi.getProduct()==selectedProduct){
               int oldAvail=selectedProduct.getAvail();
               int newAvail=oldAvail-selection;
               selectedProduct.setAvail(newAvail);
               oi.setQuantity(selection+oi.getQuantity());
               alreadyPresent=true;
               populateTable();
                   refreshOrderTable();
                   break;
               }
               }
               if(!alreadyPresent){
               int oldAvail=selectedProduct.getAvail();
               int newAvail=oldAvail-selection;
               selectedProduct.setAvail(newAvail);
               order.addOrderItem(selectedProduct, selection, salesPrice);
               populateTable();
               refreshOrderTable();
               }
           }
           else{
           JOptionPane.showMessageDialog(null,"Quantuty>Availability","Warning",JOptionPane.WARNING_MESSAGE);
           }
       }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Invalid SalesPrice");
       return;
       }
    }//GEN-LAST:event_btnAddtoCartActionPerformed

    private void btnViewItemDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewItemDetailActionPerformed
        // TODO add your handling code here:
         int row = orderJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Your selection is null,Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
       OrderItem oi = (OrderItem)orderJTable.getValueAt(row, 0);
        ViewOrderItemDetailJPanel vpdJP = new ViewOrderItemDetailJPanel(userprocesscontainer, oi);
      userprocesscontainer.add("ViewOrderItemJPanel", vpdJP);
        CardLayout layout = (CardLayout) userprocesscontainer.getLayout();
        layout.next(userprocesscontainer);        
    }//GEN-LAST:event_btnViewItemDetailActionPerformed

    private void btnModifyQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyQuanActionPerformed
        // TODO add your handling code here:
         int selectedRow=orderJTable.getSelectedRow();
        if (selectedRow<0) {
            JOptionPane.showMessageDialog(null, "Your selection is null,Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
            
        }
        OrderItem oi=(OrderItem)orderJTable.getValueAt(selectedRow, 0);
        int currentAvail=oi.getProduct().getAvail();int oldQty=oi.getQuantity();
        int newQty=Integer.parseInt(txtModifiedQuantity.getText());
        if (newQty>(currentAvail+oldQty)) {
            JOptionPane.showMessageDialog(null, "Invalid!Quantity is more than availability!");
        return;
            
        }
        else{
        if(newQty<=0){
        JOptionPane.showMessageDialog(null, "Quantity should be>0");
        return;
        }
           oi.setQuantity(newQty);
           oi.getProduct().setAvail(currentAvail+(oldQty-newQty));
           refreshOrderTable();
           populateTable();
        }
    }//GEN-LAST:event_btnModifyQuanActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
        // TODO add your handling code here:
         int row = orderJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Your selection is null,Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
       OrderItem oi = (OrderItem)orderJTable.getValueAt(row, 0);
       int oldAvail=oi.getProduct().getAvail();
       int oldQty=oi.getQuantity();
       int newQty=oldAvail+oldQty;
       oi.getProduct().setAvail(newQty);
       order.removeOrderItem(oi);
       JOptionPane.showMessageDialog(null, "OrderItem sucessfully removed from the cart");
       refreshOrderTable();
       populateTable();
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          // TODO add your handling code here:
           if (order.getOrderItemList().size()>0) {
      this.system.getMoc().addOrder(order);
       
      JOptionPane.showMessageDialog(null, "Order placed successfully");
      order=new Order();
      refreshOrderTable();
      populateTable();
      isCheckedOut=true;
        }else{JOptionPane.showMessageDialog(null,"No order Placed");
        return;
        }
    
        
        //Generate order requset between supplier and hospitaladmin
         BP_SendOrderWorkRequest request = new BP_SendOrderWorkRequest();
        request.setSender(account);
      request.setStatus("Order Processing");
  
            Organization org = null;
            for(Network network : system.getNetworkList()){
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                    if (e instanceof PharmaceuticalManufacturerEnterprise){
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            if (o instanceof CompanyAdminOrganization){
                                org = o;
                                break;
                            }
                        }
                        if (org!=null){
                            org.getWorkQueue().getWorkRequestList().add(request);
                            account.getWorkQueue().getWorkRequestList().add(request);
                        }
                    }
                }
            }
        populateRequsetTable();
       
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void backJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton2ActionPerformed

        userprocesscontainer.remove(this);
        CardLayout layout = (CardLayout) userprocesscontainer.getLayout();
        layout.previous(userprocesscontainer);
    }//GEN-LAST:event_backJButton2ActionPerformed

 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner QuantitySpinner;
    private javax.swing.JButton backJButton2;
    private javax.swing.JButton btnAddtoCart;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnModifyQuan;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewItemDetail;
    private javax.swing.JButton btnViewProdDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable orderJTable;
    private javax.swing.JTable requestJTable;
    private javax.swing.JTable supJTable;
    private javax.swing.JTextField txtModifiedQuantity;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProdName;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
    //To change body of generated methods, choose Tools | Templates.
      DefaultTableModel model = (DefaultTableModel)supJTable.getModel();
        model.setRowCount(0);
        for(Supplier s:system.getSupplierDirectory().getSupplierlist()){
        for(Product p : s.getProductCatalog().getProductcatalog()) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2] = p.getPrice();
            row[3]=p.getAvail();
            model.addRow(row);
        
    }
    }
    }
    private void refreshProductTable(String productName) {
       //To change body of generated methods, choose Tools | Templates.
          DefaultTableModel model = (DefaultTableModel)supJTable.getModel();
        model.setRowCount(0);
        for(Supplier s:this.system.getSupplierDirectory().getSupplierlist()){
        for(Product p:s.getProductCatalog().getProductcatalog()){
        if(p.getProdName().equalsIgnoreCase(productName)){
          Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2]=p.getAvail();
            row[3] = p.getPrice();
            model.addRow(row);
        }
    }
}
    }

    private void refreshOrderTable() {
      //To change body of generated methods, choose Tools | Templates.
      DefaultTableModel model = (DefaultTableModel)orderJTable.getModel();
        model.setRowCount(0);
        for(OrderItem oi:order.getOrderItemList()){
        

          Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getSalesPrice();
            row[2] = oi.getQuantity();
            row[3]=oi.getQuantity()*oi.getSalesPrice();
            model.addRow(row);
        }
    }

    private void populateRequsetTable() {
        //To change body of generated methods, choose Tools | Templates.
          DefaultTableModel model = (DefaultTableModel) requestJTable.getModel();
        model.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if (request instanceof BP_SendOrderWorkRequest){
                Object[] row = new Object[2];
                row[0] = request.getRequestDate();
                row[1] = request.getStatus();
                model.addRow(row);
            }
        }
    }
}