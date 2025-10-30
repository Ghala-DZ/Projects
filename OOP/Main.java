import java.util.*;

/**
 * Main class for the Abaya shopping application.
 * This class contains the entry point of the program and manages the overall flow of the application.
 *
 * @author Joory Abdullah Alzahrani
 */
public class Main {
    public static final Random random = new Random();

    /**
     * The main method that runs the Abaya shopping application.
     * It handles customer information, shopping cart management, and order processing.
     *
     *
     */
    public static void main(String[] args) {
        Display.displayWelcomeMessage();
        Scanner scanner = new Scanner(System.in);

        Customer customer = Customer.getCustomerInfo(scanner);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(idRandomizer());

        ArrayList<Abaya> abayaArrayList = Abaya.customizeAbayas(scanner);

        Customer.processCustomerChanges(scanner, abayaArrayList);

        shoppingCart.setItems(abayaArrayList);
        shoppingCart.setTotalPrice(shoppingCart.calculateTotalPrice());

        shoppingCart.handleShoppingCartActions(scanner);

        if (!shoppingCart.getItems().isEmpty()) {
            Order.processCheckout(scanner, customer, shoppingCart);
            Order.handleOrderActions(scanner, customer);
        }

        scanner.close();
    }

    /**
     * Generates a random ID number between 100000 and 999999.
     *
     * @return A random integer ID
     */
    public static int idRandomizer() {
        return 100000 + random.nextInt(900000);
    }

    /**
     * Validates user input to ensure it contains only letters.
     *
     * @param scanner The Scanner object to read user input
     * @return A validated string containing only letters
     */
    public static String validateStringInput(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.matches("[a-zA-Z]+")) {
                return input;
            } else {
                System.out.println("Please enter a string (letters only):");
            }
        }
    }
}