import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a customer in the shopping system.
 * This class holds customer details (ID, name, phone, address) and provides
 * methods to manage a shopping cart, including adding/removing items, viewing
 * contents, and checking out.
 *
 * @author Aisha Aladwani
 */
public class Customer {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private int customerId;
    private ShoppingCart shoppingCart;
    private ArrayList<Order> orderHistory;

    /**
     * Constructs a Customer with default values.
     */
    public Customer() {
        this.firstName = "DefaultFirstName";
        this.lastName = "DefaultLastName";
        this.phoneNumber = "0000000000";
        this.address = "Default Address";
        this.customerId = 0;
        this.shoppingCart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    /**
     * Constructs a Customer with the given details.
     *
     * @param firstName    the first name of the customer
     * @param lastName     the last name of the customer
     * @param phoneNumber  the customer's phone number
     * @param address      the customer's address
     * @param customerId   the unique ID for the customer
     * @param shoppingCart the shopping cart of the customer
     * @param orderHistory the order history of the customer
     */
    public Customer(String firstName, String lastName, String phoneNumber, String address, int customerId, ShoppingCart shoppingCart, ArrayList<Order> orderHistory) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerId = customerId;
        this.shoppingCart = shoppingCart;
        this.orderHistory = orderHistory;
    }

    /**
     * Gets the first name of the customer.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the customer.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the phone number of the customer.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phoneNumber the phone number to set
     * @throws IllegalArgumentException if the phone number format is invalid
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\+966\\d{9}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number format. It should be +966 followed by 9 digits.");
        }
    }

    /**
     * Gets the address of the customer.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the customer ID.
     *
     * @return the customer ID
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId the customer ID to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the shopping cart of the customer.
     *
     * @return the shopping cart
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the shopping cart of the customer.
     *
     * @param shoppingCart the shopping cart to set
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Gets the order history of the customer.
     *
     * @return the order history
     */
    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Sets the order history of the customer.
     *
     * @param orderHistory the order history to set
     */
    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    /**
     * Gets the full name of the customer.
     *
     * @return the full name
     */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Compares this Customer object with another object for equality.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return this.getCustomerId() == other.getCustomerId();
    }

    /**
     * Returns a string representation of the Customer object.
     *
     * @return a string representation of the customer
     */
    @Override
    public String toString() {
        return Display.getDivider() +
                String.format("%50s\n", "\nCustomer Details") +
                Display.getDivider() +
                String.format("%-20s | %-50s\n", "\nCustomer ID", "#" + getCustomerId()) +
                String.format("%-20s | %-50s\n", "Full Name", getFullName()) +
                String.format("%-20s | %-50s\n", "Address", getAddress()) +
                String.format("%-20s | %-50s\n", "Phone Number", getPhoneNumber()) +
                Display.getDivider();
    }

    /**
     * Gets customer information from user input.
     *
     * @param scanner the Scanner object for user input
     * @return a new Customer object with the input information
     */
    public static Customer getCustomerInfo(Scanner scanner) {
        System.out.println("\t\tTo start your selection process, please enter your necessary information:\t\t\n\n");

        System.out.println("Enter your first name:");
        String firstName = Main.validateStringInput(scanner);

        System.out.println("Enter your last name:");
        String lastName = Main.validateStringInput(scanner);

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setCustomerId(Main.idRandomizer());

        return customer;
    }

    /**
     * Processes customer changes to their Abaya selections.
     *
     * @param scanner        the Scanner object for user input
     * @param abayaArrayList the list of Abaya objects
     */
    public static void processCustomerChanges(Scanner scanner, ArrayList<Abaya> abayaArrayList) {
        Display.printDivider();
        System.out.println("Here is an overview of your current Abaya selections and customizations: ");
        for (int i = 0; i < abayaArrayList.size(); i++) {
            abayaArrayList.get(i).displayOverview(i);
        }

        System.out.println("Would you like to make any changes to your currently customized Abayas? (yes/no)");
        String userChanges = scanner.nextLine().toLowerCase();

        while (userChanges.equalsIgnoreCase("yes")) {
            System.out.println("Enter the product ID of the Abaya you would like to make changes to.");
            int productId = scanner.nextInt();
            scanner.nextLine();

            boolean found = false;

            for (int i = 0; i < abayaArrayList.size(); i++) {
                if (abayaArrayList.get(i).getProductId() == productId) {
                    found = true;
                    abayaArrayList.get(i).displayOverview(i);
                    abayaArrayList.get(i).changeAbayaFeature(scanner);
                }
            }
            if (!found) {
                System.out.println("Error: the product ID you have entered is unavailable. Please try again.");
            }

            System.out.println("Would you like to make changes to another Abaya? (yes/no)");
            userChanges = scanner.nextLine().toLowerCase();
        }
        Display.printDivider();
        System.out.println("Customization changes completed. Saving selections to your shopping cart.");
        Display.printDivider();
    }

    /**
     * Gets delivery information from the customer.
     *
     * @param scanner  the Scanner object for user input
     * @param customer the Customer object to update
     */
    public static void getDeliveryInformation(Scanner scanner, Customer customer) {
        Display.printDivider();
        System.out.println("\t\tEnter delivery information:\t\t");
        System.out.println("1. Enter home address: ");
        String address = scanner.nextLine();
        customer.setAddress(address);

        System.out.println("1. Enter Phone number: ");
        String phoneNumber = validatePhoneNumber(scanner);
        customer.setPhoneNumber(phoneNumber);
    }

    /**
     * Validates the phone number input.
     *
     * @param scanner the Scanner object for user input
     * @return a validated phone number
     */
    public static String validatePhoneNumber(Scanner scanner) {
        String phoneNumber;
        boolean isFirstAttempt = true;
        do {
            if (!isFirstAttempt) {
                System.out.println("Invalid phone number. Please enter 9 digits.");
            }
            System.out.print("Enter phone number: +966 ");
            phoneNumber = scanner.nextLine().trim();
            isFirstAttempt = false;
        } while (!phoneNumber.matches("\\d{9}"));
        return "+966" + phoneNumber;
    }
}