// Represents a perishable product with a name, price, and quantity
class PerishableProduct {
    private String name;
    private double price;
    private int quantity;

    public PerishableProduct(String name, double price, int quantity) {
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

  // toString method to return a string representation of the perishable product
    public String toString() {
        return "PerishableProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

// Represents a non-perishable product with a name, price, and quantity
class NonPerishableProduct {
    private String name;
    private double price;
    private int quantity;

    public NonPerishableProduct(String name, double price, int quantity) {
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


    public String toString() {
        return "NonPerishableProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
// Represents a drink product with a name, price, and quantity
class DrinkProduct {
    private String name;
    private double price;
    private int quantity;

    public DrinkProduct(String name, double price, int quantity) {
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

    public String toString() {
        return "DrinkProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
// Represents a bakery product with a name, price, and quantity
class BakeryProduct {
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


    public String toString() {
        return "BakeryProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
