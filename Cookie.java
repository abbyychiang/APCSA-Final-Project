// Represents a type of bakery product called Cookie, extending BakeryProduct
public class Cookie extends BakeryProduct {
    private String type;

    public Cookie(String name, double price, int quantity, String type) {
        super(name, price, quantity);
        this.type = type;
    }


    public void display() {
        System.out.println("Cookie: " + getName() + ", Type: " + type + ", Price: $" + getPrice() + ", Quantity: " + getQuantity());
    }
}