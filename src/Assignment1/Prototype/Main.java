package Prototype;

public class Main {
    public static void main(String[] args) {
        Product originalProduct = new Product("Laptop", 1500.0);
        Product clonedProduct = (Product) originalProduct.cloneProduct();

        System.out.println(originalProduct);
        System.out.println(clonedProduct);
    }
}
