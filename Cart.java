import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {
    private ProductModule productModule; // Reference to the product module for price lookup
    private Map<String, Integer> items; // Map to store items and their quantities

    // Constructor to initialize the cart with a product module
    public Cart(ProductModule productModule) {
        this.productModule = productModule;
        items = new HashMap<>(); // Initializing the items map
    }

    // Add an item to the cart with the specified quantity
    public void addItem(String itemName, Integer quantity) {
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity); // Increment quantity if item already exists
    }

    // Remove an item from the cart with the specified quantity
    public void removeItem(String itemName, Integer quantity) {
        if (items.containsKey(itemName)) { // Check if item exists in the cart
            int newQuantity = items.get(itemName) - quantity; // Calculate new quantity after removal
            if (newQuantity <= 0) {
                items.remove(itemName); // Remove item if quantity becomes zero or negative
            } else {
                items.put(itemName, newQuantity); // Update quantity in the cart
            }
        }
    }

    // Get the items in the cart
    public Map<String, Integer> getItems() {
        return items; // Return the items map
    }

    // Calculate the total value of items in the cart
    public Double calculateTotalValue() {
        Double totalValue = 0.0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            Integer quantity = entry.getValue();
            totalValue += productModule.getProductPrice(itemName) * quantity; // Calculate total value by multiplying price and quantity
        }
        return totalValue; // Return the total value
    }

    // Get an iterator for iterating over items in the cart
    public Iterator<Map.Entry<String, Integer>> iterator() {
        return items.entrySet().iterator(); // Return an iterator for the items map
    }
}
