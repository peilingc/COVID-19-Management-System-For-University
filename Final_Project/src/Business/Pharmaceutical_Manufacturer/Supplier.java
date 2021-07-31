
package Business.Pharmaceutical_Manufacturer;

import Business.Person.Person;

/**
 *
 * @author Jiaqi Wang
 */

public class Supplier {
    private String suppliername;
    private String CompanyRegistrationPlace;
    private ProductCatalog productCatalog;

    public Supplier() {
        productCatalog = new ProductCatalog();
    }

    public Supplier(String name,String CompanyRegistrationPlace) {
        this.CompanyRegistrationPlace = CompanyRegistrationPlace;
    }
    
    public String getCompanyRegistrationPlace() {
        return CompanyRegistrationPlace;
    }

    public void setCompanyRegistrationPlace(String CompanyRegistrationPlace) {
        this.CompanyRegistrationPlace = CompanyRegistrationPlace;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    @Override
    public String toString() {
        return suppliername ;
    }  
    
}
