import java.util.*;

public class ProductModule {
    private Map<String, Double> prices;
    private Map<String, Integer> quantities;
    private List<PerishableProduct> perishableProducts;
    private List<NonPerishableProduct> nonPerishableProducts;
    private List<DrinkProduct> drinkProducts;
    private List<BakeryProduct> bakeryProducts;
    private List<Cookie> cookies;

    public ProductModule() {
        prices = new HashMap<>();
        quantities = new HashMap<>();
        perishableProducts = new ArrayList<>();
        nonPerishableProducts = new ArrayList<>();
        drinkProducts = new ArrayList<>();
        bakeryProducts = new ArrayList<>();
        cookies = new ArrayList<>();

        prices.put("Greek Chick Peas", 5.99);
        prices.put("Rolled Corn Tortilla Chips with Chili and Lime", 4.49);
        prices.put("Cauliflower Gnocchi", 6.99);
        prices.put("Apple", 2.99);
        prices.put("Banana", 2.99);
        prices.put("Melon", 2.99);
        prices.put("Lettuce", 2.99);
        prices.put("Tomato", 2.99);

        quantities.put("Greek Chick Peas", 50);
        quantities.put("Rolled Corn Tortilla Chips with Chili and Lime", 30);
        quantities.put("Cauliflower Gnocchi", 20);
        quantities.put("Apple", 100);
        quantities.put("Banana", 150);
        quantities.put("Melon", 50);
        quantities.put("Lettuce", 75);
        quantities.put("Tomato", 80);

        // adding cookies
        Cookie chocolateChipCookie = new Cookie("Chocolate Chip Cookie", 1.99, 50, "Chocolate Chip");
        Cookie oatmealRaisinCookie = new Cookie("Oatmeal Raisin Cookie", 1.49, 30, "Oatmeal Raisin");
        Cookie sugarCookie = new Cookie("Sugar Cookie", 1.29, 40, "Sugar");

        cookies.add(chocolateChipCookie);
        cookies.add(oatmealRaisinCookie);
        cookies.add(sugarCookie);

        // adding cakes or other bakery items
        Cake birthdayCake = new Cake("Birthday Cake", 19.99, 10, "Vanilla");
        Cake chocolateCake = new Cake("Chocolate Cake", 24.99, 15, "Chocolate");
        Cake carrotCake = new Cake("Carrot Cake", 18.99, 12, "Carrot");

        bakeryProducts.add(birthdayCake);
        bakeryProducts.add(chocolateCake);
        bakeryProducts.add(carrotCake);
    }

    public void addProductPrice(String productName, double productPrice) {
        prices.put(productName, productPrice);
    }

    public Map<String, Integer> getQuantities() {
        return quantities;
    }

    public void addProduct(String productName, double price, int quantity) {
        prices.put(productName, price);
        quantities.put(productName, quantity);
    }

    public void updateProduct(String productName, double price, int quantity) {
        if (prices.containsKey(productName)) {
            prices.put(productName, price);
            quantities.put(productName, quantity);
        } else {
            System.out.println("Product not found.");
        }
    }

    public double getProductPrice(String productName) {
        return prices.getOrDefault(productName, 0.0);
    }

    public Map<String, Double> getProductPrices() {
        return prices;
    }

    public void addPerishableProduct(PerishableProduct product) {
        perishableProducts.add(product);
    }

    public void addNonPerishableProduct(NonPerishableProduct product) {
        nonPerishableProducts.add(product);
    }

    public void addDrinkProduct(DrinkProduct product) {
        drinkProducts.add(product);
    }

    public void addBakeryProduct(BakeryProduct product) {
        bakeryProducts.add(product);
    }

    public void addCookie(Cookie cookie) {
        cookies.add(cookie);
    }

    public double calculateTotalQuantityAndValue() {
        double totalValue = 0.0;
        int totalQuantity = 0;

        for (Map.Entry<String, Integer> entry : quantities.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            double price = prices.getOrDefault(productName, 0.0);
            totalValue += price * quantity;
            totalQuantity += quantity;
        }

        return totalValue;
    }
}
