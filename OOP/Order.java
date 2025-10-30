import java.util.Date;
import java.util.Scanner;

/**
 * Represents an order in the system.
 * This class manages order details, including customer information, shopping cart, payment details, and order status.
 *
 * @author Ghala Marzouq Alsaedi
 */
public class Order {

    private int orderID;
    private Customer customer;
    private ShoppingCart shoppingCart;
    private Payment paymentDetails;
    private Date orderDate;
    private String orderStatus;

    /**
     * Default constructor for Order.
     * Initializes an order with default values.
     */
    public Order() {
        this.orderID = 0;
        this.customer = null;
        this.shoppingCart = new ShoppingCart();
        this.paymentDetails = null;
        this.orderDate = new Date();
        this.orderStatus = "Pending";
    }

    /**
     * Parameterized constructor for Order.
     *
     * @param orderID         The unique identifier for the order
     * @param customer        The customer associated with the order
     * @param shoppingCart    The shopping cart containing items for the order
     * @param paymentDetails  The payment details for the order
     * @param orderDate       The date when the order was placed
     */
    public Order(int orderID, Customer customer, ShoppingCart shoppingCart, Payment paymentDetails, Date orderDate) {
        this.orderID = orderID;
        this.customer = customer;
        this.shoppingCart = shoppingCart;
        this.paymentDetails = paymentDetails;
        this.orderDate = orderDate;
        this.orderStatus = "Pending";
    }

    /**
     * Gets the order ID.
     *
     * @return The order ID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Sets the order ID.
     *
     * @param orderID The order ID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Gets the customer associated with the order.
     *
     * @return The customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer for the order.
     *
     * @param customer The customer to set
     * @throws IllegalArgumentException if the customer is null
     */
    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException(" customer cannot be null ");
        }
        this.customer = customer;
    }

    /**
     * Gets the shopping cart associated with the order.
     *
     * @return The shopping cart
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the shopping cart for the order.
     *
     * @param shoppingCart The shopping cart to set
     * @throws IllegalArgumentException if the shopping cart is null
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            throw new IllegalArgumentException(" shopping Cart cannot be null ");
        }
        this.shoppingCart = shoppingCart;
    }

    /**
     * Gets the payment details for the order.
     *
     * @return The payment details
     */
    public Payment getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the payment details for the order.
     *
     * @param paymentDetails The payment details to set
     * @throws IllegalArgumentException if the payment details are null
     */
    public void setPaymentDetails(Payment paymentDetails) {
        if (paymentDetails == null) {
            throw new IllegalArgumentException("payment Details cannot be null ");
        }
        this.paymentDetails = paymentDetails;
    }

    /**
     * Gets the date when the order was placed.
     *
     * @return The order date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date for the order.
     *
     * @param orderDate The order date to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the current status of the order.
     *
     * @return The order status
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the status of the order.
     *
     * @param orderStatus The order status to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Cancels the order if it's not already completed or shipped.
     *
     * @throws IllegalArgumentException if the order is completed or shipped
     */
    public void cancelOrder() {
        if ("Completed".equals(this.orderStatus) || "shipped".equals(this.orderStatus)) {
            throw new IllegalArgumentException("cannot cancel completed or shipped order");
        }
        this.orderStatus = "Cancelled";
    }

    /**
     * Updates the status of the order.
     *
     * @param newStatus The new status to set
     * @throws IllegalArgumentException if the new status is invalid
     */
    public void updateStatus(String newStatus) {
        if (newStatus == null ||
                !(newStatus.equals("pending") ||
                        newStatus.equals("shipped") ||
                        newStatus.equals("completed"))) {
            throw new IllegalArgumentException("invalid status: " + newStatus);
        }
        this.orderStatus = newStatus;
    }

    /**
     * Returns a string representation of the order.
     *
     * @return A formatted string containing order details
     */
    @Override
    public String toString() {
        return Display.getDoubleDivider() +
               String.format("%50s\n", "\nOrder Overview") +
               Display.getDoubleDivider() +"\n" +
               String.format("%-20s | %-50s\n", "Order ID", getOrderID()) +
               String.format("%-20s | %-50s\n", "Order Date", getOrderDate()) +
               String.format("%-20s | %-50s\n", "Order Status", getOrderStatus()) +
               Display.getDoubleDivider();
    }

    /**
     * Checks if this order is equal to another object.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Order)) {
            return false;
        }
        Order order = ((Order) obj);
        return (this.orderID == order.orderID);
    }

    /**
     * Processes the checkout for an order.
     *
     * @param scanner      The Scanner object for user input
     * @param customer     The customer making the order
     * @param shoppingCart The shopping cart containing items for the order
     */
    public static void processCheckout(Scanner scanner, Customer customer, ShoppingCart shoppingCart) {
        System.out.println("Proceeding to checkout...");
        Customer.getDeliveryInformation(scanner, customer);

        Display.printDivider();
        System.out.println("Currently, the only method of payment available is through credit card. Would you like to proceed?(yes/no)");

        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            CreditCardPayment.processPayment(scanner, customer, shoppingCart);
        } else {
            System.out.println("Payment process canceled.");
            Display.displaySadToSeeYouMessage();
        }
    }

    /**
     * Creates a new order.
     *
     * @param customer          The customer making the order
     * @param shoppingCart      The shopping cart containing items for the order
     * @param creditCardPayment The credit card payment details
     * @return A new Order object
     */
    public static Order createOrder(Customer customer, ShoppingCart shoppingCart, CreditCardPayment creditCardPayment) {
        Order order = new Order(Main.idRandomizer(), customer, shoppingCart, creditCardPayment, new Date());
        order.setOrderStatus("Confirmed");
        return order;
    }

    /**
     * Displays the order confirmation details.
     *
     * @param customer          The customer who placed the order
     * @param order             The order to display
     * @param shoppingCart      The shopping cart associated with the order
     * @param creditCardPayment The credit card payment details
     */
    public static void displayOrderConfirmation(Customer customer, Order order, ShoppingCart shoppingCart, CreditCardPayment creditCardPayment) {
        Display.printDivider();
        System.out.println("\t\tOrder Confirmation\t\t");

        System.out.println(customer.toString());
        System.out.println(order.toString());

        for (Abaya abaya : shoppingCart.getItems()) {
            abaya.displayOverview(shoppingCart.getItems().indexOf(abaya));
        }
        System.out.println("Total Price: SAR " + order.getShoppingCart().getTotalPrice());
        Display.printSpace();

        System.out.print(order.getPaymentDetails().toString());

        System.out.println("\nShipment Confirmation: " + order.getOrderStatus());
        System.out.println("Your order will be shipped to: " + customer.getAddress());
        System.out.println("Contact Phone: " + customer.getPhoneNumber());
        System.out.println("Estimated delivery: 3-5 business days");
        Display.printDoubleDivider();
        Display.displayThankYouMessage();
    }

    /**
     * Handles order-related actions for a customer.
     *
     * @param scanner  The Scanner object for user input
     * @param customer The customer performing the actions
     */
    public static void handleOrderActions(Scanner scanner, Customer customer) {
        while (true) {
            Display.printDivider();
            System.out.println("\t\tOrder Management\t\t");
            Display.printDivider();
            System.out.println("1. View Order History");
            System.out.println("2. Cancel an Order");
            System.out.println("3. Exit Order Management");
            System.out.print("Enter your choice (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.print("Please enter your Customer ID for verification: ");
            int enteredCustomerId = scanner.nextInt();
            scanner.nextLine();

            if (enteredCustomerId != customer.getCustomerId()) {
                System.out.println("Invalid Customer ID. Access denied.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (customer.getOrderHistory().isEmpty()) {
                        System.out.println("No orders found in your history.");
                    } else {
                        System.out.println("Order History:");
                        for (Order order : customer.getOrderHistory()) {
                            System.out.println(order.toString());
                        }
                    }
                    break;

                case 2:
                    if (customer.getOrderHistory().isEmpty()) {
                        System.out.println("No orders available to cancel.");
                    } else {
                        System.out.println("Enter the Order ID you wish to cancel:");
                        int orderIdToCancel = scanner.nextInt();
                        scanner.nextLine();

                        boolean found = false;
                        for (Order order : customer.getOrderHistory()) {
                            if (order.getOrderID() == orderIdToCancel) {
                                found = true;
                                try {
                                    order.updateStatus("Cancelled");
                                    order.cancelOrder();
                                    System.out.println("Order " + order.getOrderID() +": " +order.getOrderStatus()+ " successfully.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Order not found with ID: " + orderIdToCancel);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting Order Management.");
                    Display.displayByeByeMessage();
                    return;
            }
        }
    }
}