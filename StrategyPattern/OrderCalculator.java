package StrategyPattern;
import DataModels.*;

/*
 * รับกลยุทธ์เข้าไปแล้วคำนวณราคาสุดท้าย
 */

public class OrderCalculator {
    public double calculateFinalPrice(Order order, DiscountStrategy strategy){
        return strategy.applyDiscount(order);
    }
}
