package FactoryMethod;

public class WaterDeliveryService extends DeliveryService {
    public Transport createTransport() {
        return new Ship();
    }
}
