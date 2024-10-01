package FactoryMethod;

public class LandDeliveryService extends DeliveryService {
    public Transport createTransport() {
        return new Truck();
    }
}
