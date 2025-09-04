package ObserverPattern;
import java.util.ArrayList;
import DataModels.*;

/*
 * Subject (Pulisher) ที่คอยแจ้งข่าว
 */

public class OrderProcessor {
    private final ArrayList<OrderObserver> observers = new ArrayList<>();

    public void register(OrderObserver observer){
        observers.add(observer);
    }
    public void unregister(OrderObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(Order order){
        for(OrderObserver observer : observers){
            observer.update(order);
        }
    }
    public void processOrder(Order order){
        System.out.println("\n Processing order "+ order.orderId() +"...");
        //ตรรกะการประมวลผลคำสั่งอื่นๆ
        System.out.println("Order processed successfully.");

        //แจ้งเตือนผู้ติดตามทั้งหมด
        notifyObservers(order);
    }
}