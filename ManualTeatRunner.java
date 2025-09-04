import java.util.List;
import DataModels.*;
import DecoratorPattern.*;
import FactoryMethodPattern.*;
import ObserverPattern.*;
import StrategyPattern.*;

public class ManualTeatRunner {
    public static void main(String[] args) {
        System.out.println("--- E-commerce System Simulation ---");

        // --- 1. Setup ---
        Product laptop = new Product("P001","Laptop",30000.0);
        Product mouse = new Product("P002","Mouse",800.0);
        Order myOrder = new Order("ORD-001", List.of(laptop, mouse), "customer@example.com");

        OrderCalculator calculator = new OrderCalculator();
        ShipmentFactory shipmentFactory = new ShipmentFactory();
        OrderProcessor orderProcessor = new OrderProcessor();

        InventoryService inventoryService = new InventoryService();
        EmailService emailService = new EmailService();
        orderProcessor.register(inventoryService);
        orderProcessor.register(emailService);

        System.out.println("\n--- 2. Testing Strategy Pattern (Discount) ---");
        double originalPrice = myOrder.getTotalPrice();
        System.out.println("Original Price: "+originalPrice);

        DiscountStrategy temPercentOff = new PercentageDiscount(10);
        double priceAfterPercentage = calculator.calculateFinalPrice(myOrder, temPercentOff);
        System.out.println("Price with 10% discount: "+priceAfterPercentage);

        DiscountStrategy fiveHundredOff = new FixedDiscount(500);
        double priceAfterFixed = calculator.calculateFinalPrice(myOrder, fiveHundredOff);
        System.out.println("Price with 500 THB discount: "+priceAfterFixed);

        System.out.println("\n--- 3. Testing Factory and Decorator Pattern (Shipment) ---");
        // สร้างการจัดส่งแบบมาตรฐาน
        Shipment standardShipment = shipmentFactory.createShipment("STANDARD");
        System.out.println("Base Shipment: " + standardShipment.getInfo() + ", Cost: " + standardShipment.getCost());

        // "ห่อ" ด้วยบริการห่อของขวัญ
        Shipment giftWrapped = new GiftWrapDecorator(standardShipment);
        System.out.println("Decorated: " + giftWrapped.getInfo() + ", Cost: " + giftWrapped.getCost());

        // "ห่อ" ทับด้วยบริการประกันสินค้า
        Shipment fullyLoaded = new InsuranceDecorator(giftWrapped, myOrder);
        System.out.println("Fully Decorated: " + fullyLoaded.getInfo() + ", Cost: " + fullyLoaded.getCost());

        System.out.println("\n--- 4. Printing Final Summary ---");
        double finalPrice = priceAfterPercentage; //สมมติว่าใช้ส่วนลด 10%
        double totalCost = finalPrice + fullyLoaded.getCost();
        System.out.println("Final price after discount: "+ finalPrice);
        System.out.println("Final shipment cost: "+ fullyLoaded.getCost());
        System.out.println("TOTAL TO PAY: "+totalCost);

        //--- 5. Testing Observer Pattern (Processing Order) ---
        orderProcessor.processOrder(myOrder);
    }
}