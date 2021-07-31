
package Business.Pharmaceutical_Manufacturer;

import Business.Pharmaceutical_Manufacturer.Order;
import java.util.ArrayList;

/**
 *
 * @author Jiaqi Wang
 */
public class MasterOrderCatalog {
    private ArrayList<Order>orderCatalog;
    public MasterOrderCatalog(){
        orderCatalog=new ArrayList<Order>();       
}

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    public Order addOrder(Order o){
    
    orderCatalog.add(o);
    return o;
    }
    
}