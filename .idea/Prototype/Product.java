package Prototype;

public class Product implements CloneableProduct {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public CloneableProduct cloneProduct() {
        return new Product(name, price);
    }

    @Override
    public String toString() {
        return "Product [Name=" + name + ", Price=" + price + "]";
    }
}
