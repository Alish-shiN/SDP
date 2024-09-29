package FactoryMethod;

public class AirDeliveryService extends DeliveryService {
    public Transport createTransport() {
        return new Drone();
    }
}
