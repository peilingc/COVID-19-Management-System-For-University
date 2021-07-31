package Business.Pharmaceutical_Manufacturer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jiaqi Wang
 */
public class TotalPurchaseCatalog {    
    private SupplierDirectory supplierDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    
    public TotalPurchaseCatalog(){
    supplierDirectory=new SupplierDirectory();
    masterOrderCatalog=new MasterOrderCatalog();
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }
    
}
