import java.util.*;
public class Admin implements Login {
    private String adminPassword;
    private Scanner scanner;
    private boolean isLoggedIn;
    // Constructor to initialize the admin with a password
    public Admin(String adminPassword) {
        this.adminPassword = adminPassword;
        this.scanner = new Scanner(System.in);
        this.isLoggedIn = false;
    }
    // Method to authenticate the admin with a provided password
    public boolean authenticate(String inputPassword) {
        boolean authenticated = inputPassword.equals(adminPassword);
        if (authenticated) {
            isLoggedIn = true;
        }
        return authenticated;
    }
    // Method to authenticate the admin using user input
    public boolean authenticate() {
        System.out.print("Enter admin password: ");
        String inputPassword = scanner.nextLine();
        return authenticate(inputPassword);
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    // Method to run the admin authentication process
    public void run() {
        boolean authenticated = false;
        while (!authenticated) {
            authenticated = authenticate();
            if (!authenticated) {
                System.out.println("Incorrect password. Please try again.");
            }
        }
        System.out.println("Successfully logged in as admin.");
    }
}