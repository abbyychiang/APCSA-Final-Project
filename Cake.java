// Represents a type of bakery product called Cake, extending BakeryProduct
public class Cake extends BakeryProduct {
    private String flavor;

    public Cake(String name, double price, int quantity, String flavor) {
        super(name, price, quantity);
        this.flavor = flavor;
    }

   
    public void display() {
        System.out.println("Cake: " + getName() + ", Flavor: " + flavor + ", Price: $" + getPrice() + ", Quantity: " + getQuantity());
    }
}
