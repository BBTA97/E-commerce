package FactoryMethodPattern;

/*
 * Factory สำหรับอ็อบเจกต์ Shipment
 */

public class ShipmentFactory {
    public Shipment createShipment(String type){
        //return StandardShipment/ExpressShipment ตาม type ที่ส่งเข้ามา ("STANDARD" หรือ "EXPRESS")
        if("STANDARD".equalsIgnoreCase(type)){
            return new StandardShipment();
        }else if("EXPRESS".equalsIgnoreCase(type)){
            return new ExpressShipment();
        }
        throw new IllegalArgumentException("Unknow shipment type "+ type);
    }
}
