import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a shopping cart for managing Abaya items.
 * This class provides functionality for adding, removing, and managing Abaya items in a cart,
 * as well as calculating the total price of items in the cart.
 *
 * @author Ghala Marzouq Alsaedi
 */
public class ShoppingCart {

    private int cartID;
    private List<Abaya> items;
    private double totalPrice;

    /**
     * Constructs a new ShoppingCart with default values.
     */
    public ShoppingCart() {
        this.cartID = 0;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    /**
     * Constructs a new ShoppingCart with specified values.
     *
     * @param cartID     The ID of the shopping cart.
     * @param items      The list of Abaya items in the cart.
     * @param totalPrice The total price of items in the cart.
     * @throws IllegalArgumentException if items is null or totalPrice is negative.
     */
    public ShoppingCart(int cartID, List<Abaya> items, double totalPrice) {
        if (items == null || totalPrice < 0) {
            throw new IllegalArgumentException("Invalid input: Items cannot be null, and totalPrice cannot be negative.");
        }
        this.cartID = cartID;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    /**
     * Gets the ID of the shopping cart.
     *
     * @return The cart ID.
     */
    public int getCartID() {
        return cartID;
    }

    /**
     * Sets the ID of the shopping cart.
     *
     * @param cartID The new cart ID.
     */
    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    /**
     * Gets the list of Abaya items in the cart.
     *
     * @return The list of items in the cart.
     */
    public List<Abaya> getItems() {
        return items;
    }

    /**
     * Sets the list of Abaya items in the cart.
     *
     * @param items The new list of items.
     * @throws NullPointerException if items is null.
     */
    public void setItems(List<Abaya> items) {
        if (items == null) {
            throw new NullPointerException("Items list cannot be null.");
        }
        this.items = items;
    }

    /**
     * Gets the total price of items in the cart.
     *
     * @return The total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of items in the cart.
     *
     * @param totalPrice The new total price.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Removes an Abaya item from the cart.
     *
     * @param item The Abaya item to remove.
     * @throws IllegalArgumentException if the item is null or not found in the cart.
     */
    public void removeItem(Abaya item) {
        if (item == null) {
            throw new IllegalArgumentException(" Error: Item cannot be null ");
        }
        if (!items.remove(item)) {
            throw new IllegalArgumentException(" Error: Item is not found in the cart ");
        }
        calculateTotalPrice();
    }

    /**
     * Clears all items from the cart and resets the total price.
     */
    public void clearCart() {
        if (!getItems().isEmpty()) {
            getItems().clear();
            setTotalPrice(0.0);
            System.out.println("Shopping cart has been cleared.");
        } else {
            System.out.println("The cart is already empty.");
        }
    }

    /**
     * Calculates and updates the total price of items in the cart.
     *
     * @return The calculated total price.
     */
    public double calculateTotalPrice() {
        totalPrice = 0;
        for (Abaya item : getItems()) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * Returns a string representation of the shopping cart.
     *
     * @return A formatted string containing cart details and items.
     */
    @Override
    public String toString() {
        String result = Display.getDoubleDivider() +
                String.format("%50s\n", "Shopping Cart Overview") +
                Display.getDoubleDivider() +
                String.format("%-20s | %-50s\n", "Cart ID", getCartID()) +
                String.format("%-20s | %-50d\n", "Number of Items", items.size()) +
                String.format("%-20s | %-50s\n", "Total Price", String.format("%.2f SAR", getTotalPrice())) +
                Display.getDoubleDivider() +
                String.format("%50s\n", "Items in Cart") +
                Display.getDoubleDivider();

        for (int i = 0; i < items.size(); i++) {
            Abaya abaya = items.get(i);
            abaya.displayOverview(i);
        }

        result += Display.getDivider();
        return result;
    }

    /**
     * Compares this ShoppingCart with another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart cart = ((ShoppingCart) obj);
        return (this.cartID == cart.cartID);
    }

    /**
     * Handles user interactions for shopping cart actions.
     * This method provides a menu-driven interface for users to perform various actions on their shopping cart,
     * such as removing items, clearing the cart, or proceeding to checkout.
     *
     * @param scanner A Scanner object to read user input from the console.
     */
    public void handleShoppingCartActions(Scanner scanner) {
        boolean continueActions;
        do {
            int choice;
            do {
                System.out.println(Display.getDivider() +
                        String.format("%50s\n", "\nShopping Cart Actions") +
                        Display.getDivider() +
                        String.format("%-20s | %-50s\n", "\nOption 1", "Remove an Abaya from the cart") +
                        String.format("%-20s | %-50s\n", "Option 2", "Clear the entire cart") +
                        String.format("%-20s | %-50s\n", "Option 3", "End shopping cart actions and proceed to checkout.") +
                        Display.getDivider());
                System.out.print("Enter your choice (1-3): ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    scanner.next();
                }
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } while (choice < 1 || choice > 3);

            switch (choice) {
                case 1:
                    if (!getItems().isEmpty()) {
                        boolean validProductId = false;
                        while (!validProductId) {
                            System.out.println(Display.getDivider() +
                                    String.format("%50s\n", "Remove Abaya") +
                                    Display.getDivider() +
                                    String.format("%-20s | %-50s\n", "Action", "Enter the product ID of the Abaya to remove") +
                                    Display.getDivider());
                            int productId = scanner.nextInt();
                            scanner.nextLine();

                            Abaya abayaToRemove = null;
                            for (Abaya abaya : getItems()) {
                                if (abaya.getProductId() == productId) {
                                    abayaToRemove = abaya;
                                    break;
                                }
                            }

                            if (abayaToRemove != null) {
                                removeItem(abayaToRemove);
                                System.out.println(Display.getDivider() +
                                        String.format("%50s\n", "Abaya removed from the cart") +
                                        Display.getDivider());
                                validProductId = true;
                            } else {
                                System.out.println(Display.getDivider() +
                                        String.format("%50s\n", "Invalid product ID. Please try again") +
                                        Display.getDivider());
                            }
                        }
                    } else {
                        System.out.println(Display.getDivider() +
                                String.format("%50s\n", "The cart is empty. No Abaya to remove") +
                                Display.getDivider());
                    }
                    break;
                case 2:
                    clearCart();
                    break;
                case 3:
                    return;
            }

            System.out.println("\nUpdated Shopping Cart:");
            System.out.println(this);

            System.out.println("\nWould you like to continue taking actions on the shopping cart? (yes/no)");
            String continueResponse = scanner.nextLine().toLowerCase();
            continueActions = continueResponse.equalsIgnoreCase("yes") || continueResponse.equalsIgnoreCase("y");

        } while (continueActions);

        System.out.println(Display.getDivider() +
                String.format("%50s\n", "Shopping Cart Actions Completed") +
                Display.getDivider());
    }
}