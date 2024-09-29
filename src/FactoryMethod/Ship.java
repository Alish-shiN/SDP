package FactoryMethod;


public class Ship implements Transport {
    public void deliver() {
        System.out.println("Delivering by ship via sea.");
    }
}
