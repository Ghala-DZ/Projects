import java.util.Date;
import java.util.Random;

/**
 * Abstract class representing a Payment.
 * This class provides a structure for different types of payments.
 * It includes attributes like paymentID, amount, paymentDate, and status.
 *
 * @author Rawan Alzahrani
 */
@SuppressWarnings("UnreachableCode")
public abstract class Payment {
    private int paymentID;
    private double amount;
    private Date paymentDate;
    private String status;

    /**
     * Default constructor for the Payment class.
     * Initializes a payment with default values.
     */
    public Payment() {
        this.paymentID = Main.idRandomizer();
        this.amount = 0.0;
        this.paymentDate = new Date();
        this.status = "Pending";
    }

    /**
     * Parameterized constructor for the Payment class.
     *
     * @param amount The amount of the payment.
     * @param paymentDate The date of the payment.
     */
    public Payment(double amount, Date paymentDate) {
        Random random = new Random();
        this.paymentID = Main.idRandomizer();
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = "Pending";
    }

    /**
     * Processes the payment.
     *
     * @return A string indicating the payment is being processed.
     */
    public String processPayment() {
        return "Processing...";
    }

    /**
     * Generates a payment receipt.
     *
     * @return A string representing the generated receipt.
     */
    public abstract String generateReceipt();

    /**
     * Validates the payment details.
     *
     * @return True if the payment is valid, false otherwise.
     */
    public abstract boolean validatePayment();

    /**
     * Gets the payment ID.
     *
     * @return The payment ID.
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * Sets the payment ID.
     *
     * @param paymentID The new payment ID.
     */
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * Gets the payment amount.
     *
     * @return The payment amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the payment amount.
     *
     * @param amount The new payment amount.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the payment date.
     *
     * @return The payment date.
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the payment date.
     *
     * @param paymentDate The new payment date.
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * Gets the status of the payment.
     *
     * @return The payment status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the payment.
     *
     * @param status The new payment status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the payment details.
     *
     * @return A formatted string containing payment details.
     */
    @Override
    public String toString() {
        return Display.getDivider() +
               String.format("%50s\n", "\nPayment Details\n") +
               Display.getDivider() +
               String.format("%-20s | %-50s\n", "Payment ID", "#" + getPaymentID()) +
               String.format("%-20s | %-50s\n", "Amount", String.format("SAR %.2f", getAmount())) +
               String.format("%-20s | %-50s\n", "Payment Date", getPaymentDate()) +
               String.format("%-20s | %-50s\n", "Status", getStatus()) +
               Display.getDivider();
    }

    /**
     * Checks if this payment is equal to another object.
     *
     * @param obj The object to compare with.
     * @return True if the payments are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment payment = (Payment) obj;
        return paymentID == payment.paymentID && Double.compare(payment.amount, amount) == 0;
    }
}