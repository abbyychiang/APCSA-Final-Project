import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Bakery implements Iterable<BakeryProduct> {
    private List<BakeryProduct> products; 

  
    public Bakery() {
        products = new ArrayList<>();
    }


    public void addProduct(BakeryProduct product) {
        products.add(product); 
    }

    // Method required by the Iterable interface to obtain an iterator over the bakery products
    public Iterator<BakeryProduct> iterator() {
        return products.iterator(); // Return an iterator for the products list
    }

   
    public static void main(String[] args) {
        Bakery bakery = new Bakery();
        bakery.addProduct(new Cake("Chocolate Cake", 10.99, 20, "Chocolate"));
        bakery.addProduct(new Cake("Vanilla Cake", 8.99, 15, "Vanilla"));
        bakery.addProduct(new Cookie("Chocolate Chip Cookie", 1.99, 50, "Chocolate Chip"));
        bakery.addProduct(new Cookie("Sugar Cookie", 0.99, 30, "Sugar"));

        // Using the iterator to iterate over the bakery products
        Iterator<BakeryProduct> iterator = bakery.iterator();
        while (iterator.hasNext()) {
            BakeryProduct product = iterator.next();
            product.display(); // Display each bakery product
        }
    }
}
