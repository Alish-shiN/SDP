package FactoryMethod;

public abstract class DeliveryService {
    public abstract Transport createTransport();

    public void deliver() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

