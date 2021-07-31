
package Business.Pharmaceutical_Manufacturer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jiaqi Wang
 */
public class SupplierDirectory {

    private List<Supplier> supplierList;
    public SupplierDirectory() {
    
        supplierList = new ArrayList<Supplier>();
    }
    
    public List<Supplier> getSupplierlist(){
        return supplierList;
    }
    
    public void addSupplier(Supplier s)
    {
        this.supplierList.add(s);
    }
    
    public void removeSupplier(Supplier s){
        supplierList.remove(s);
    }
    
    public Supplier searchSupplier(String keyword){
        for (Supplier supplier : supplierList) {

            if(supplier.getSuppliername().equals(keyword)){

                return supplier;
            }
        }
        return null;
    }
}
