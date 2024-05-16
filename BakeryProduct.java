// Abstract class representing a bakery product
public abstract class BakeryProduct {
    private String name;
    private double price;
    private int quantity;

    public BakeryProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    // Abstract method to display details of the bakery product
    public abstract void display();
}
