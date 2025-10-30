import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents an Abaya with its unique characteristics and functionality.
 *
 * This class encapsulates the properties of an Abaya, including its unique ID, style,
 * fabric, color, size, and price. It provides methods to calculate the price based on
 * these characteristics and to check the availability of specific sizes and colors.
 *
 *
 * The class ensures that users can select from available options without being misled
 * about the availability of certain features. It includes methods for customization,
 * price calculation, and displaying Abaya details.
 *
 *
 * @author Joory Ahmad Alzahrani

 */
public class Abaya implements Display {

    private int productId;
    private String style;
    private String fabricType;
    private String colour;
    private int size;
    private double price;

    /**
     *Set default attributes for an Abaya object, (Product ID to 0, style to Unknown,
     fabricType to a default fabric “cotton”, colour to default “black”, size to 52, price to 0/
     */
    public Abaya(){
        this.productId = 0;
        this.style = "Unknown";
        this.fabricType = "Uknown";
        this.colour = "Unknown";
        this.size = 0;
        this.price = 0;
    }

    /**
     * Set values for productID, style, fabricType, colour, size, and price respectively.
     *
     * @param productId A unique ID for each Abaya.
     * @param style The style of the Abaya. (Bisht, normal, zipper, buttoned, kloshed, half kloshed, dantel, professional embroidered).
    embroidered).
     * @param fabricType The material used to the Abaya. (Cotton, silk, linen, nidha, chiffon)
     * @param colour Whether the Abaya is black or coloured. (Coloured range: white, beige, brown, navy, dark green, silver, blue, maroon)
     * @param size The available sizes of the Abaya. (52-60, in increments of 2)
     * @param price The cost of the Abaya.
     */
    public Abaya(int productId, String style, String fabricType, String colour, int size, double price) {
        this.productId = productId;
        this.style = style;
        this.fabricType = fabricType;
        this.colour = colour;
        this.size = size;
        this.price = price;
    }

    /**
     * Get the product ID of the Abaya.
     * @return The unique product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Get the style of the Abaya.
     * @return The style of the Abaya.
     */
    public String getStyle() {
        return style;
    }

    /**
     * Get the FabricType of the Abaya.
     * @return The FabricType of the Abaya.
     */
    public String getFabricType() {
        return fabricType;
    }

    /**
     * Get the Colour of the Abaya.
     * @return The Colour of the Abaya.
     */
    public String getColour() {
        return colour;
    }

    /**
     * Get the Size of the Abaya.
     * @return The Size of the Abaya.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the Price of the Abaya.
     * @return The Price of the Abaya.
     */

    public double getPrice() {
        return price;
    }

    /**
     * Set the product ID of the Abaya.
     * @param productId A unique product ID.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Set the style of the Abaya.
     * @param style The style of the Abaya.
     */
    public void setStyle(String style) {
      this.style = style; 
    }

    /**
     * Set the fabric type of the Abaya.
     * @param fabricType The fabric type of the Abaya.
     */
    public void setFabricType(String fabricType) {
     this.fabricType = fabricType; 
    }

    /**
     * Set the color of the Abaya.
     * @param colour The colour of the Abaya.
     */
    public void setColour(String colour) {
       this.colour = colour;
    }

    /**
 * Sets the size of the Abaya.
 * This method updates the size attribute of the Abaya object.
 *
 * @param size The size of the Abaya to be set. This should be an integer value
 *             representing one of the standard Abaya sizes (e.g., 52, 54, 56, 58, or 60).
 */
public void setSize(int size) {
   this.size = size;
}

    /**
 * Sets the price of the Abaya.
 * This method updates the price of the Abaya to the specified value.
 *
 * @param price The new price to set for the Abaya. This should be a positive double value
 *              representing the price in the applicable currency (SAR).
 */
public void setPrice(double price) {
    this.price = price;
}


    /**
 * Compares this Abaya object with another object for equality.
 * Two Abaya objects are considered equal if they have the same color, product ID, size, style, and fabric type.
 *
 * @param otherAbaya The object to compare with this Abaya object. It should be an instance of the Abaya class
 *                   or a subclass of Abaya for a meaningful comparison.
 * @return boolean True if the specified object is equal to this Abaya object, false otherwise.
 *                 The comparison returns true if:
 *                 - The objects are the same instance (reference equality)
 *                 - The other object is an instance of Abaya and all the following are true:
 *                   - The colors are equal (case-insensitive)
 *                   - The product IDs are equal
 *                   - The sizes are equal
 *                   - The styles are equal (case-insensitive)
 *                   - The fabric types are equal (case-insensitive)
 */
@Override
public boolean equals(Object otherAbaya) {
    if (this == otherAbaya) {
        return true;
    }
    if (!(otherAbaya instanceof Abaya)) {
        return false;
    }
    Abaya otherProduct = (Abaya) otherAbaya;
    return getColour().equalsIgnoreCase(otherProduct.getColour()) &&
            getProductId() == otherProduct.getProductId() &&
            getSize() == otherProduct.getSize() &&
            getStyle().equalsIgnoreCase(otherProduct.getStyle()) &&
            getFabricType().equalsIgnoreCase(otherProduct.getFabricType());
}


    /**
 * Generates a string representation of the Abaya object.
 * This method provides a formatted string containing all the details of the Abaya,
 * including its product ID, style, fabric type, colour, size, and price.
 *
 * @return A formatted string containing all the details of the Abaya object.
 *         The string includes:
 *         - Product ID (as an integer)
 *         - Style (as a string)
 *         - Fabric type (as a string)
 *         - Colour (as a string)
 *         - Size (as an integer)
 *         - Price (as a double, in SAR)
 *         Each detail is presented on a separate line with appropriate labels.
 */
@Override
public String toString() {
    return String.format(
            "Product ID          : #%-19d\n" +
                    "Style               : %-20s\n" +
                    "Fabric              : %-20s\n" +
                    "Colour              : %-20s\n" +
                    "Size                : %-20d\n" +
                    "Price               : %.2f SAR\n",
            getProductId(), getStyle(), getFabricType(), getColour(), getSize(), getPrice()
    );
}

    /**
 * Calculates the price of the Abaya based on its style, fabric, and colour.
 * This method determines the base price according to the fabric type, then
 * adjusts it based on the style and colour of the Abaya.
 *
 * The method uses the following attributes of the Abaya:
 * - fabricType: Determines the initial base price
 * - style: May add an additional cost to the base price
 * - colour: Adds a small additional cost if not black
 *
 * @return The calculated price of the Abaya as a double value. If an error occurs
 *         during calculation (e.g., unknown fabric type, style, or color),
 *         it returns the partial calculation up to the point of error and
 *         prints an error message.
 *
 * @throws IllegalStateException if an unknown fabric type, style, or color is encountered.
 *         The exception is caught internally, and an error message is printed.
 */
public double calculatePrice() {
    double basePrice = 0;

    try {
        basePrice = switch (fabricType.toLowerCase()) {
            case "cotton" -> 250;
            case "silk", "linen", "nidha" -> 300;
            case "chiffon" -> 200;
            default -> throw new IllegalStateException("Unknown fabric type: " + fabricType);
        };

        switch (style.toLowerCase()) {
            case "bisht":
                basePrice += 50;
                break;
            case "normal":
                break;
            case "zipper":
                basePrice += 20;
                break;
            case "buttoned":
                basePrice += 50;
                break;
            case "kloshed":
                basePrice += 80;
                break;
            case "half kloshed":
                basePrice += 60;
                break;
            case "dantel":
            case "professional":
                basePrice += 100;
                break;
            default:
                throw new IllegalStateException("Unknown style: " + style);
        }

        if (!colour.equalsIgnoreCase("black")) {
            String[] ColorsWithoutBlack = {"white", "beige", "brown", "navy", "dark green", "silver", "blue", "maroon"};
            boolean validColor = false;
            for (String color : ColorsWithoutBlack) {
                if (colour.equalsIgnoreCase(color)) {
                    basePrice += 10;
                    validColor = true;
                    break;
                }
            }
            if (!validColor) {
                throw new IllegalStateException("Unknown color: " + colour);
            }
        }

        this.price = basePrice;
        return basePrice;
    } catch (IllegalStateException e) {
        System.out.println("Error calculating price: " + e.getMessage());
        return basePrice;
    }
}


    /**
 * Checks if an Abaya is available in a specific size.
 * This method verifies if the given size is one of the standard sizes available for Abayas.
 *
 * @param size The size to check for availability. This should be an integer
 *             representing one of the standard Abaya sizes (52, 54, 56, 58, or 60).
 * @return true if the specified size is available, false otherwise.
 *         Returns true if the size matches one of the predefined available sizes,
 *         and false if it doesn't match any of them.
 */
public boolean isAvailableInSize(int size){
    int[] AvailableInSize = {52, 54, 56, 58, 60};

    for (int i = 0; i < AvailableInSize.length; i++){
        if(AvailableInSize[i] == size){
            return true;
        }
    }

    return false;
}


    /**
 * Checks if a specified colour is available for the Abaya.
 * This method verifies if the given colour is either "black" or one of the predefined
 * colours available for Abayas.
 *
 * @param colour The colour to check for availability. This should be a String
 *               representing the colour name (e.g., "black", "white", "beige", etc.).
 * @return true if the specified colour is available for Abayas, false otherwise.
 *         Returns true for "black" and any colour in the predefined list of available colours.
 */
public boolean isAvailableInColour(String colour) {
    if(colour.equalsIgnoreCase("black"))
        return true;

    String[] ColorsWithoutBlack = {"white", "beige", "brown", "navy", "dark green", "silver", "blue", "maroon"};
    for(int i = 0; i < ColorsWithoutBlack.length; i++){
        if(ColorsWithoutBlack[i].equalsIgnoreCase(colour)){
            return true;
        }
    }
    return false;
}

    /**
 * Checks if a specified fabric type is available for the Abaya.
 * This method verifies if the given fabric type is one of the predefined available fabrics.
 *
 * @param fabricType The fabric type to check for availability. This should be a String
 *                   representing one of the Abaya fabric types (e.g., "cotton", "silk", etc.).
 * @return true if the specified fabric type is available, false otherwise.
 */
public boolean isAvailableInFabric(String fabricType) {
    String[] availableFabrics = {"cotton", "silk", "linen", "nidha", "chiffon"};
    for (String fabric : availableFabrics) {
        if (fabric.equalsIgnoreCase(fabricType)) {
            return true;
        }
    }
    return false;
}

    /**
 * Checks if a specified style is available for the Abaya.
 * This method verifies if the given style is one of the predefined available styles.
 *
 * @param style The style to check for availability. This should be a String
 *              representing one of the Abaya styles (e.g., "bisht", "normal", "zipper", etc.).
 * @return true if the specified style is available, false otherwise.
 */
public boolean isAvailableInStyle(String style) {
    String[] availableStyles = {"bisht", "normal", "zipper", "buttoned", "kloshed", "half kloshed", "dantel", "professional"};
    for (String availableStyle : availableStyles) {
        if (availableStyle.equalsIgnoreCase(style)) {
            return true;
        }
    }
    return false;
}


    /**
 * Displays a formatted menu of available fabric types for Abayas.
 * This method prints a table to the console showing different fabric types,
 * their descriptions, and their corresponding base prices.
 * The table includes information for Cotton, Silk, Linen, Nidha, and Chiffon fabrics.
 * 
 * The method uses System.out.printf for formatted output and calls
 * Display.printDivider() to separate each row in the table.
 * 
 * This method does not take any parameters and does not return any value.
 * It simply prints the fabric menu to the console.
 */
public static void displayFabricMenu() {
    System.out.print("\n\n\t\tFabric Selection Menu:\n");
    System.out.printf("%-15s | %-80s | %-12s\n", "Fabric Type", "Description", "Base Price");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Cotton", "Cotton fabric is breathable, soft, and comfortable, ideal for everyday wear and hot climates.", "250");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Silk", "Silk fabric is smooth, luxurious, and perfect for special occasions or high-end abayas.", "300");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Linen", "Linen fabric is lightweight, durable, and breathable, making it ideal for warm weather.", "300");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Nidha", "Nidha fabric is soft and elegant, often used in premium abayas for its smooth texture and flowy appearance.", "300");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Chiffon", "Chiffon fabric is lightweight, sheer, and gives the abaya a delicate, flowing appearance.", "200");
    Display.printDivider();
}


    /**
 * Displays a formatted menu of available Abaya styles.
 * This method prints a table to the console showing different Abaya styles,
 * their descriptions, and their corresponding base prices.
 * The table includes information for Bisht, Normal, Zipper, Buttoned, Kloshed,
 * Half Kloshed, Dantel, and Professional styles.
 * 
 * The method uses System.out.printf for formatted output and calls
 * Display.printDivider() to separate each row in the table.
 * 
 * This method does not take any parameters and does not return any value.
 * It simply prints the style menu to the console.
 */
public static void displayStyleMenu() {
    System.out.print("\n\n\t\tStyle Selection Menu:\n");
    System.out.printf("%-15s | %-80s | %-12s\n", "Style Type", "Description", "Base Price");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Bisht", "The Bisht abaya is characterized by wide sleeves and a loose design, giving it a luxurious, elegant, and modest appearance.", "50         ");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Normal", "Standard abaya with no additional features.", "0          ");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Zipper", "Abaya with a zipper.", "20         ");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Buttoned", "Abaya with buttons.", "50         ");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Kloshed", "The klosh abaya is an elegant abaya characterized by a wide design that starts fitted at the shoulders and gradually widens towards the bottom.", "80         ");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Half Kloshed", "The half klosh abaya combines elements of both fitted and wide designs.", "60         ");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Dantel", "The dantel abaya is characterized by the addition of delicate lace fabric to its design.", "100        ");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Professional", "The professional abaya is designed with simplicity and elegance, making it ideal for formal and work environments.", "100        ");
    Display.printDivider();
}

        /**
 * Displays a menu of available colors for Abayas.
 * This method prints a formatted table showing various color options,
 * their descriptions, and the price adjustments associated with each color.
 * The table includes information for Black, White, Beige, Brown, Navy,
 * Dark Green, Silver, Blue, and Maroon colors.
 * 
 * The method uses System.out.printf for formatted output and calls
 * Display.printDivider() to separate each row in the table.
 * 
 * This method does not take any parameters and does not return any value.
 * It simply prints the color menu to the console.
 */
public static void displayColoursMenu(){
    System.out.print("\n\n\t\tColor Selection Menu:\n");
    System.out.printf("%-15s | %-80s | %-12s\n", "Color Type", "Description", "Price Adjustment");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Black", "A classic color that adds elegance and versatility.", "0");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "White", "A classic and timeless choice, white gives a fresh and clean look.", "+10");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Beige", "A neutral color that pairs well with many fabrics.", "+10");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Brown", "A warm, earthy color that adds richness and depth.", "+10");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Navy", "A dark blue that is professional and sophisticated.", "+10");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Dark Green", "A deep green that evokes nature and tranquility.", "+10");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Silver", "A metallic hue that adds elegance and modernity.", "+10");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Blue", "A calming and cool color that is versatile.", "+10");
    Display.printDivider();

    System.out.printf("%-15s | %-80s | %-12s\n", "Maroon", "A rich, dark red that adds warmth and sophistication.", "+10");
    Display.printDivider();
}

 /**
 * Displays an overview of the Abaya object in the shopping cart.
 * This method is responsible for formatting and printing the details of an Abaya
 * in a structured manner. If it's the first item (index 0), it also prints a header.
 *
 * @param index The position of the Abaya in the shopping cart list. 
 *              Used to determine if a header should be printed and to number the Abaya.
 */
@Override
public void displayOverview(int index) {
    if (index == 0) {
        Display.printDoubleDivider();
        System.out.printf("%-40s\n", "Abayas in Shopping Cart");
        Display.printDoubleDivider();
    }

    Display.printDivider();
    System.out.println("Abaya #" + (index + 1));
    System.out.println(this);
    Display.printDivider();
}

 /**
 * Allows users to customize multiple Abayas and adds them to a list.
 * This method guides the user through the customization process for each Abaya,
 * allowing them to specify fabric, style, color, and size. It continues to prompt
 * for customizations until the user chooses to stop.
 *
 * @param scanner A Scanner object to read user input from the console.
 * @return An ArrayList of customized Abaya objects. Each Abaya in the list
 *         represents a fully customized Abaya with all attributes set and price calculated.
 */
public static ArrayList<Abaya> customizeAbayas(Scanner scanner) {
    System.out.println("Thank you for inputting your information. You may now start customizing your brand new Abaya!");
    ArrayList<Abaya> abayaArrayList = new ArrayList<>();
    boolean continueCustomizing = true;

    while (continueCustomizing) {
        Abaya abaya = new Abaya();
        abaya.setProductId(Main.idRandomizer());
        customizeSingleAbaya(scanner, abaya); // Pass the abaya object to the method

        abaya.setPrice(abaya.calculatePrice());
        abayaArrayList.add(abaya);

        for (int i = 0; i < abayaArrayList.size(); i++) {
            abayaArrayList.get(i).displayOverview(i);
        }

        System.out.println("Would you like to continue customizing another Abaya? (yes/no)");
        String userChoice = scanner.nextLine().toLowerCase();

        if (!userChoice.equals("yes")) {
            continueCustomizing = false;
            System.out.println("Your Abaya customizations have been saved.");
        }
    }

    return abayaArrayList;
}

    /**
     * Customizes a single Abaya based on user input.
     *
     * @param scanner The Scanner object for user input.
     * @param abaya The Abaya object to customize.
     */
public static void customizeSingleAbaya(Scanner scanner, Abaya abaya) {
    Display.printDivider();

    Abaya.displayFabricMenu();
    boolean validFabric = false;
    while (!validFabric) {
        System.out.println("\n\nEnter the fabric you would like for your Abaya: ");
        String fabricType = scanner.nextLine().toLowerCase();

        if (abaya.isAvailableInFabric(fabricType)) {
            abaya.setFabricType(fabricType);
            validFabric = true;
            System.out.println("Fabric set successfully.");
        } else {
            System.out.println("Invalid fabric. Please try again.");
        }
    }

    Abaya.displayStyleMenu();
    boolean validStyle = false;
    while (!validStyle) {
        System.out.println("\n\nEnter the style you would like for your Abaya: ");
        String style = scanner.nextLine().toLowerCase();

        if (abaya.isAvailableInStyle(style)) {
            abaya.setStyle(style);
            validStyle = true;
            System.out.println("Style set successfully.");
        } else {
            System.out.println("Invalid style. Please try again.");
        }
    }

    Abaya.displayColoursMenu();
    boolean validColour = false;
    while (!validColour) {
        System.out.println("\n\nEnter the color you would like for your Abaya: ");
        String colour = scanner.nextLine().toLowerCase();

        if (abaya.isAvailableInColour(colour)) {
            abaya.setColour(colour);
            validColour = true;
            System.out.println("Color set successfully.");
        } else {
            System.out.println("Invalid color. Please try again.");
        }
    }

    System.out.println("Please enter the size of the Abaya (52, 54, 56, 58, 60): ");
    boolean validSize = false;
    while (!validSize) {
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (abaya.isAvailableInSize(size)) {
            abaya.setSize(size);
            validSize = true;
            System.out.println("Size set successfully.");
        } else {
            System.out.println("Invalid size. Please try again.");
        }
    }
}


    /**
     * Changes a specific feature of the Abaya based on user input.
     *
     * @param scanner The Scanner object for user input.
     */
  public void changeAbayaFeature(Scanner scanner) {
    System.out.println("What feature would you like to change for this Abaya? (fabric/style/size/colour)");
    String feature = scanner.nextLine().toLowerCase();

    if (feature.equalsIgnoreCase("fabric")) {
        boolean validFabric = false;
        while (!validFabric) {
            displayFabricMenu();
            System.out.println("Please enter the name of the fabric you would like to change your abaya to: ");
            String newFabric = scanner.nextLine().toLowerCase();

            if (isAvailableInFabric(newFabric)) {
                setFabricType(newFabric);
                validFabric = true;
                System.out.println("Fabric change confirmed!");
            } else {
                System.out.println("Invalid fabric. Please try again.");
            }
        }
    } else if (feature.equalsIgnoreCase("style")) {
        boolean validStyle = false;
        while (!validStyle) {
            displayStyleMenu();
            System.out.println("Please enter the name of the style you would like to change your abaya to: ");
            String newStyle = scanner.nextLine().toLowerCase();

            if (isAvailableInStyle(newStyle)) {
                setStyle(newStyle);
                validStyle = true;
                System.out.println("Style change confirmed!");
            } else {
                System.out.println("Invalid style. Please try again.");
            }
        }
    } else if (feature.equalsIgnoreCase("size")) {
        boolean validSize = false;
        while (!validSize) {
            System.out.println("Enter the size you would like to change this Abaya to: ");
            int newSize = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (isAvailableInSize(newSize)) {
                setSize(newSize);
                validSize = true;
                System.out.println("Size change confirmed!");
            } else {
                System.out.println("Invalid size. Please try again.");
            }
        }
    } else if (feature.equalsIgnoreCase("colour") || feature.equalsIgnoreCase("color")) {
        boolean validColour = false;
        while (!validColour) {
            displayColoursMenu();
            System.out.println("Please enter the name of the colour you would like to change your abaya to: ");
            String newColor = scanner.nextLine().toLowerCase();

            if (isAvailableInColour(newColor)) {
                setColour(newColor);
                validColour = true;
                System.out.println("Color change confirmed!");
            } else {
                System.out.println("Invalid color. Please try again.");
            }
        }
    } else {
        System.out.println("Invalid feature selected. Please enter one of the following: fabric, style, size, colour.");
    }
}
    }

