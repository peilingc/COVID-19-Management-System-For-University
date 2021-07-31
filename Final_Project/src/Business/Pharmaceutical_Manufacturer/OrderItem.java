
package Business.Pharmaceutical_Manufacturer;

import Business.Pharmaceutical_Manufacturer.Product;

/**
 *
 * @author Jiaqi Wang
 */
public class OrderItem {
    private int quantity;
    private double salesPrice;
    private Product product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return product.getProdName();
    }
    
}
