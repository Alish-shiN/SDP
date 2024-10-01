package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new WaterDeliveryService();
        deliveryService.deliver();
    }
}
