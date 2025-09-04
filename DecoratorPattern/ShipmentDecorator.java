package DecoratorPattern;
import FactoryMethodPattern.*;

/*
 * Abstract Decorator สำหรับห่อหุ่ม Shipment
 */

abstract class ShipmentDecorator implements Shipment{
    protected Shipment wrappedShipment;

    public ShipmentDecorator(Shipment shipment){
        this.wrappedShipment = shipment;
    }

    @Override
    public String getInfo() {
        return wrappedShipment.getInfo();
    }

    @Override
    public double getCost() {
        return wrappedShipment.getCost();
    }
}
