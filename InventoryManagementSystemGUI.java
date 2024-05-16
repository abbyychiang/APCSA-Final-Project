// Importing necessary Java Swing classes for GUI components
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// InventoryManagementSystemGUI class, extending JFrame to create a GUI application
public class InventoryManagementSystemGUI extends JFrame {

    // Declaration of instance variables
    private List<BakeryProduct> bakeryProducts;
    private ProductModule productModule;
    private Admin admin;
    private Cart cart;
    private List<Map<String, Integer>> purchaseHistory;

    // GUI components
    private JPanel mainPanel;
    private JTextArea inventoryTextArea;
    private JTextArea cartTextArea;
    private JButton viewInventoryButton;
    private JButton addToCartButton;
    private JButton checkoutButton;
    private JButton addProductButton;
    private JButton updateProductButton;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Constants for login attempts
    private final int MAX_ATTEMPTS = 5;
    private int attemptsRemaining = MAX_ATTEMPTS;

    // Constructor for the GUI
    public InventoryManagementSystemGUI() {
        // Initializing instance variables
        productModule = new ProductModule();
        admin = new Admin("admin123");
        cart = new Cart(productModule);
        purchaseHistory = new ArrayList<>();

        // Setting up JFrame properties
        setTitle("Inventory Management System for Trader Joes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating the main panel and setting its layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        // Creating JTextAreas for inventory and cart display, adding them to ScrollPanes for scrollability
        inventoryTextArea = new JTextArea();
        inventoryTextArea.setEditable(false);
        JScrollPane inventoryScrollPane = new JScrollPane(inventoryTextArea);

        cartTextArea = new JTextArea();
        cartTextArea.setEditable(false);
        JScrollPane cartScrollPane = new JScrollPane(cartTextArea);

        // Adding inventory and cart panels to the main panel
        mainPanel.add(inventoryScrollPane);
        mainPanel.add(cartScrollPane);

        // Creating buttons for various operations
        viewInventoryButton = new JButton("View Inventory");
        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");
        addProductButton = new JButton("Add Product");
        updateProductButton = new JButton("Update Product");

        // Adding action listeners to the buttons to perform operations
        viewInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayInventory();
            }
        });
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
        updateProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProduct();
            }
        });

        // Creating panel for buttons and setting its layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));

        // Adding buttons to the button panel
        buttonPanel.add(viewInventoryButton);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(addProductButton);
        buttonPanel.add(updateProductButton);

        // Creating login components and panel for admin login
        passwordLabel = new JLabel("Admin Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(2, 2));
        adminPanel.add(passwordLabel);
        adminPanel.add(passwordField);
        adminPanel.add(new JLabel());
        adminPanel.add(loginButton);

        // Adding panels to the JFrame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.EAST);
        getContentPane().add(adminPanel, BorderLayout.SOUTH);

        // Setting background colors for components
        mainPanel.setBackground(new Color(240, 240, 240));
        inventoryTextArea.setBackground(new Color(255, 255, 255));
        cartTextArea.setBackground(new Color(255, 255, 255));
        viewInventoryButton.setBackground(new Color(102, 153, 255));
        addToCartButton.setBackground(new Color(51, 204, 102));
        checkoutButton.setBackground(new Color(255, 102, 102));
        addProductButton.setBackground(new Color(255, 204, 51));
        updateProductButton.setBackground(new Color(153, 102, 255));

        // Initializing bakery products and displaying inventory
        bakeryProducts = new ArrayList<>();
        bakeryProducts.add(new Cake("Chocolate Cake", 10.99, 20, "Chocolate"));
        bakeryProducts.add(new Cake("Vanilla Cake", 8.99, 15, "Vanilla"));
        bakeryProducts.add(new Cookie("Chocolate Chip Cookie", 1.99, 50, "Chocolate Chip"));
        bakeryProducts.add(new Cookie("Sugar Cookie", 0.99, 30, "Sugar"));
        displayInventory();
    }

    // Method to display inventory in the JTextArea
    private void displayInventory() {
        // StringBuilder to construct the inventory text
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory:\n");

        int totalQuantity = 0;
        double totalPrice = 0.00;

        // Iterating over each product in the productModule and appending its details to the StringBuilder
        for (Map.Entry<String, Double> entry : productModule.getProductPrices().entrySet()) {
            String productName = entry.getKey();
            double price = entry.getValue();
            int quantity = productModule.getQuantities().getOrDefault(productName, 0);
            sb.append(productName).append(" - $").append(price).append(" - Quantity: ").append(quantity).append("\n");

            totalQuantity += quantity;
            totalPrice += price * quantity;
        }

        // Appending total quantity and total price to the StringBuilder
        sb.append("Total Quantity in Inventory: ").append(totalQuantity).append("\n");
        sb.append("Total Price of Inventory: $").append(totalPrice).append("\n");

        // Setting the text of the inventoryTextArea to the StringBuilder content
        inventoryTextArea.setText(sb.toString());
    }

    // Method to add a product to the cart
    private void addToCart() {
        String productName = JOptionPane.showInputDialog("Enter product name:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));

        if (productModule.getProductPrices().containsKey(productName)) {
            int availableQuantity = productModule.getQuantities().getOrDefault(productName, 0);
            if (availableQuantity >= quantity) {
                cart.addItem(productName, quantity);
                updateCart();
            } else {
                JOptionPane.showMessageDialog(this, "Not enough quantity available for " + productName +
                        ". Available quantity: " + availableQuantity, "Quantity Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Product not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to update the cart display
    private void updateCart() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart:\n");
        Iterator<Map.Entry<String, Integer>> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            sb.append(itemName).append(" - Quantity: ").append(quantity).append("\n");
        }
        cartTextArea.setText(sb.toString());
    }

    // Method to checkout, calculate total value, and display it
    private void checkout() {
        double totalValue = cart.calculateTotalValue();
        JOptionPane.showMessageDialog(this, "Total Value: $" + totalValue, "Checkout", JOptionPane.INFORMATION_MESSAGE);
        cart = new Cart(productModule); // Resetting the cart
        updateCart(); // Updating the cart display
    }

    // Method to handle admin login
    private void login() {
        String password = new String(passwordField.getPassword());
        if (admin.authenticate(password)) {
            // If login successful, enable buttons for inventory management
            viewInventoryButton.setEnabled(true);
            addToCartButton.setEnabled(true);
            checkoutButton.setEnabled(true);
            addProductButton.setEnabled(true);
            updateProductButton.setEnabled(true);

            JOptionPane.showMessageDialog(this, "Successfully logged in!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            attemptsRemaining--;
            if (attemptsRemaining <= 0) {
                JOptionPane.showMessageDialog(this, "Maximum attempts reached. Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect password. " + attemptsRemaining + " attempts remaining.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to add a product to the inventory (admin only)
    private void addProduct() {
        if (!admin.isLoggedIn()) {
            JOptionPane.showMessageDialog(this, "Please log in as an admin to add a product.", "Admin Login Required", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String productName = JOptionPane.showInputDialog("Enter product name:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price:"));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter product quantity:"));

        productModule.addProduct(productName, price, quantity);
        displayInventory(); // Updating the inventory display
    }

    // Method to update a product in the inventory (admin only)
    private void updateProduct() {
        if (!admin.isLoggedIn()) {
            JOptionPane.showMessageDialog(this, "Please log in as an admin to update a product.", "Admin Login Required", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String productName = JOptionPane.showInputDialog("Enter product name to update:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter updated price:"));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter updated quantity:"));

        productModule.updateProduct(productName, price, quantity);
        displayInventory(); // Updating the inventory display
    }

    // Main method to create and display the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InventoryManagementSystemGUI gui = new InventoryManagementSystemGUI();
                gui.setVisible(true);
            }
        });
    }
}
