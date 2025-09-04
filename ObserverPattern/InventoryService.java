package ObserverPattern;
import DataModels.*;

/*
 * Concrete Observer: ระบบจัดการคลังสินค้า
 */

public class InventoryService implements OrderObserver{
    @Override
    public void update(Order order) {
        System.err.println("[Inventory Service] Stock has been updated for order: "+ order.orderId());
    }
    
}
