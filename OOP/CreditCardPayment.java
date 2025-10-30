import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * CreditCardPayment class represents a specific type of payment made via credit card.
 * It extends the base Payment class and adds additional attributes and behavior
 * specific to credit card transactions such as card number, cardholder name,
 * expiration date, and CVV.
 *
 * @author Rawan Alzahrani
 */
public class CreditCardPayment extends Payment {

    private String cardNumber;
    private String cardHolderName;
    private Date expiryDate;
    private int cvv;

    /**
     * Default constructor for the CreditCardPayment class.
     * Initializes the card number, card holder name, expiry date, and CVV to default values.
     */
    public CreditCardPayment() {
        super();
        this.cardNumber = "0000 0000 0000 0000";
        this.cardHolderName = "Unknown";
        this.expiryDate = new Date();
        this.cvv = 0;
    }

    /**
     * Parameterized constructor for the CreditCardPayment class.
     *
     * @param cardNumber      The credit card number as a string.
     * @param cardHolderName  The name of the cardholder.
     * @param expiryDate      The expiration date of the credit card.
     * @param cvv             The CVV (security code) of the credit card.
     * @param paymentID       The unique ID of the payment.
     * @param amount          The amount of the payment.
     * @param paymentDate     The date the payment was made.
     */
    public CreditCardPayment(String cardNumber, String cardHolderName, Date expiryDate, int cvv, int paymentID, double amount, Date paymentDate) {
        super(amount, paymentDate);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Generates a receipt for the payment.
     *
     * @return The receipt details including masked credit card information.
     */
    @Override
    public String generateReceipt() {
        return super.toString() + "\nPayment via Credit Card ending with: " + getMaskedNumber();
    }

    /**
     * Validates the credit card payment details.
     *
     * @return true if the payment is valid, false otherwise.
     */
    @Override
    public boolean validatePayment() {
        try {
            if (cardNumber.length() != 16) {
                throw new IllegalArgumentException("Card number must be 16 digits.");
            }
            if (expiryDate == null) {
                throw new NullPointerException("Expiry date cannot be null.");
            }
            if (cvv < 100 || cvv > 999) {
                throw new IllegalArgumentException("CVV must be a 3-digit number.");
            }
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Validation error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Masks the credit card number, showing only the last 4 digits.
     *
     * @return The masked credit card number.
     */
    public String getMaskedNumber() {
        if (getCardNumber().length() != 16) {
            return "Invalid card number";
        }
        return "**** **** **** " + getCardNumber().substring(12);
    }

    /**
     * Provides a string representation of the CreditCardPayment object.
     *
     * @return A string representation of the credit card payment details.
     */
    @Override
    public String toString() {
        return Display.getDoubleDivider() +
               String.format("%50s\n", "\nCredit Card Payment Details\n") +
               Display.getDoubleDivider() +
               String.format("%-20s | %-50s\n", "\nPayment ID", getPaymentID()) +
               String.format("%-20s | %-50s\n", "Amount", String.format("SAR %.2f", getAmount())) +
               String.format("%-20s | %-50s\n", "Payment Date", getPaymentDate()) +
               String.format("%-20s | %-50s\n", "Card Holder", getCardHolderName()) +
               String.format("%-20s | %-50s\n", "Card Number", getMaskedNumber()) +
               String.format("%-20s | %-50s\n", "Expiry Date", getExpiryDate()) +
               String.format("%-20s | %-50s\n", "CVV", "***") +
               Display.getDoubleDivider();
    }

    /**
     * Compares this CreditCardPayment object with another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        CreditCardPayment that = (CreditCardPayment) obj;
        return getCardNumber().equals(that.getCardNumber()) && getCvv() == that.getCvv();
    }

    /**
     * Processes the credit card payment.
     *
     * @param scanner The Scanner object for user input.
     * @param customer The Customer making the payment.
     * @param shoppingCart The ShoppingCart containing items to be paid for.
     */
    public static void processPayment(Scanner scanner, Customer customer, ShoppingCart shoppingCart) {
        boolean validPayment = false;
        ArrayList<Order> orderHistory = new ArrayList<>();

        while (!validPayment) {
            Display.printDivider();
            System.out.println("\t\tEnter payment details:\t\t");

            CreditCardPayment creditCardPayment = CreditCardPayment.getCreditCardDetails(scanner, shoppingCart.getTotalPrice());

            if (creditCardPayment.validatePayment()) {
                System.out.println("Credit Card Credentials are correct: " + creditCardPayment.processPayment());
                Order order = Order.createOrder(customer, shoppingCart, creditCardPayment);
                Order.displayOrderConfirmation(customer, order, shoppingCart, creditCardPayment);
                orderHistory.add(order);
                customer.setOrderHistory(orderHistory);
                validPayment = true;
            } else {
                System.out.println("Invalid credit card details. Please re-enter your payment information.");
            }
        }
    }

    /**
     * Gets the expiry date from user input.
     *
     * @param scanner The Scanner object for user input.
     * @return The parsed expiry date.
     */
    public static Date getExpiryDate(Scanner scanner) {
        while (true) {
            try {
                String dateInput = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
                dateFormat.setLenient(false);
                return dateFormat.parse(dateInput);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use MM/yy.");
            }
        }
    }

    /**
     * Gets credit card details from user input.
     *
     * @param scanner The Scanner object for user input.
     * @param totalPrice The total price of the purchase.
     * @return A new CreditCardPayment object with the entered details.
     */
    public static CreditCardPayment getCreditCardDetails(Scanner scanner, double totalPrice) {
        System.out.println("1. Enter Card Number: ");
        String cardNumber = scanner.nextLine();
        System.out.println("2. Enter Card holder name: ");
        String cardHolderName = scanner.nextLine();
        System.out.println("3. Enter Card expiry date (MM/yy): ");
        Date expiryDate = getExpiryDate(scanner);
        System.out.println("4. Enter CVV: ");
        int cvv = Integer.parseInt(scanner.nextLine());

        CreditCardPayment creditCardPayment = new CreditCardPayment(cardNumber, cardHolderName, expiryDate, cvv, Main.idRandomizer(), totalPrice, new Date());
        creditCardPayment.setPaymentID(Main.idRandomizer());
        creditCardPayment.setAmount(totalPrice);
        creditCardPayment.setPaymentDate(new Date());
        return creditCardPayment;
    }
}