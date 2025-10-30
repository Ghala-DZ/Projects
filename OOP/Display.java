/**
 * Interface for displaying various messages and UI elements in the Abaya shopping application.
 *
 * @author Joory Abdullah Alzahrani
 */
public interface Display {
    /**
     * Displays an overview of the shopping process.
     *
     * @param i The step number in the shopping process
     */
    void displayOverview(int i);
    
    /**
     * Prints a divider line to the console.
     */
    static void printDivider() {
        System.out.println(getDivider());
    }
    
    /**
     * Returns a string representation of a divider line.
     *
     * @return A string of dashes used as a divider
     */
    static String getDivider() {
        return "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------—";
    }

    /**
     * Returns a string representation of a space (two newlines).
     *
     * @return A string with two newline characters
     */
    static String getSpace() {
        return "\n\n";
    }

    /**
     * Prints a space (two newlines) to the console.
     */
    static void printSpace(){
        System.out.println(getSpace());
    }

    /**
     * Returns a string representation of a double divider line.
     *
     * @return A string of equal signs used as a double divider
     */
    static String getDoubleDivider() {
        return "============================================================================================================================================================================";
    }

    /**
     * Prints a double divider line to the console.
     */
    static void printDoubleDivider() {
        System.out.println(getDoubleDivider());
    }

    /**
     * Displays the welcome message for Layali Abayas.
     */
    static void displayWelcomeMessage() {
        Display.printDivider();
        System.out.println(" __          __  _                            _          _                       _ _            _                           _ \n" +
                " \\ \\        / / | |                          | |        | |                     | (_)     /\\   | |                         | |\n" +
                "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___   | |     __ _ _   _  __ _| |_     /  \\  | |__   __ _ _   _  __ _ ___| |\n" +
                "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |    / _` | | | |/ _` | | |   / /\\ \\ | '_ \\ / _` | | | |/ _` / __| |\n" +
                "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |___| (_| | |_| | (_| | | |  / ____ \\| |_) | (_| | |_| | (_| \\__ \\_|\n" +
                "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |______\\__,_|\\__, |\\__,_|_|_| /_/    \\_\\_.__/ \\__,_|\\__, |\\__,_|___(_)\n" +
                "                                                                      __/ |                                  __/ |            \n" +
                "                                                                     |___/                                  |___/            ");

        String welcome = "Welcome to Layali Abayas!";
        System.out.printf("\n%80s\n%n", welcome);
        Display.printDivider();

        String storeDescription = "At Layali Abayas, we offer a unique selection of high-quality fabrics and stylish " +
                "designs of Abayas. Our store is dedicated to helping you design your own custom abayas that " +
                "perfectly reflect your taste. Experience luxury at affordable prices, and enjoy the personalized " +
                "service that makes your shopping experience truly special. Start your selection with us now!";

        String[] lines = storeDescription.split("(?<=\\G.{70})");
        for (String line : lines) {
            System.out.printf("%80s%n", line);
        }

        Display.printDivider();
    }

    /**
     * Displays a message when the user decides to leave without completing a purchase.
     */
    static void displaySadToSeeYouMessage() {
        System.out.println(" \"                                                                                                                                          \\n\" +\n" +
                "                \"                                                                                                                                          \\n\" +\n" +
                "                \"                                                                                                                                          \\n\" +\n" +
                "                \"                                                                                                                                          \\n\" +\n" +
                "                \"                                                                                                                                          \\n\" +\n" +
                "                \"                                                                                                                                          \\n\" +\n" +
                "                \"                                                                                                                                          \\n\" +\n" +
                "                \"███████  █████  ██████      ████████  ██████      ███████ ███████ ███████     ██    ██  ██████  ██    ██      ██████   ██████          ██ \\n\" +\n" +
                "                \"██      ██   ██ ██   ██        ██    ██    ██     ██      ██      ██           ██  ██  ██    ██ ██    ██     ██       ██    ██     ██ ██  \\n\" +\n" +
                "                \"███████ ███████ ██   ██        ██    ██    ██     ███████ █████   █████         ████   ██    ██ ██    ██     ██   ███ ██    ██        ██  \\n\" +\n" +
                "                \"     ██ ██   ██ ██   ██        ██    ██    ██          ██ ██      ██             ██    ██    ██ ██    ██     ██    ██ ██    ██     ██ ██  \\n\" +\n" +
                "                \"███████ ██   ██ ██████         ██     ██████      ███████ ███████ ███████        ██     ██████   ██████       ██████   ██████          ██ \\n\" +\n" +
                "                \"                                                                                                                                          \\n\" +\n" +
                "                \"                     ");
    }

    /**
     * Displays a thank you message after a successful purchase.
     */
    static void displayThankYouMessage() {
        System.out.println("\n" +
                "  ________                __      __  __               ______              _____ __                      _             __   \n" +
                " /_  __/ /_  ____ _____  / /__    \\ \\/ /___  __  __   / ____/___  _____   / ___// /_  ____  ____  ____  (_)___  ____ _/ /   \n" +
                "  / / / __ \\/ __ `/ __ \\/ //_/     \\  / __ \\/ / / /  / /_  / __ \\/ ___/   \\__ \\/ __ \\/ __ \\/ __ \\/ __ \\/ / __ \\/ __ `/ /    \n" +
                " / / / / / / /_/ / / / / ,<        / / /_/ / /_/ /  / __/ / /_/ / /      ___/ / / / / /_/ / /_/ / /_/ / / / / / /_/ /_/     \n" +
                "/_/ /_/ /_/\\__,_/_/ /_/_/|_|      /_/\\____/\\__,_/  /_/    \\____/_/      /____/_/ /_/\\____/ .___/ .___/_/_/ /_/\\__, (_)      \n" +
                "                                                                                        /_/   /_/            /____/         \n");

        System.out.println("Thank you for shopping with Layali Abayas!");
    }

    /**
     * Displays a goodbye message when the user exits the application.
     */
    static void displayByeByeMessage() {
        System.out.println("\n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n" +
                "██████  ██    ██ ███████     ██████  ██    ██ ███████ ██                                                                 \n" +
                "██   ██  ██  ██  ██          ██   ██  ██  ██  ██      ██                                                                 \n" +
                "██████    ████   █████       ██████    ████   █████   ██                                                                 \n" +
                "██   ██    ██    ██          ██   ██    ██    ██                                                                         \n" +
                "██████     ██    ███████     ██████     ██    ███████ ██                                                                 \n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n" +
                " ██████  ██████  ███    ███ ███████      █████   ██████   █████  ██ ███    ██     ███████  ██████   ██████  ███    ██ ██ \n" +
                "██      ██    ██ ████  ████ ██          ██   ██ ██       ██   ██ ██ ████   ██     ██      ██    ██ ██    ██ ████   ██ ██ \n" +
                "██      ██    ██ ██ ████ ██ █████       ███████ ██   ███ ███████ ██ ██ ██  ██     ███████ ██    ██ ██    ██ ██ ██  ██ ██ \n" +
                "██      ██    ██ ██  ██  ██ ██          ██   ██ ██    ██ ██   ██ ██ ██  ██ ██          ██ ██    ██ ██    ██ ██  ██ ██    \n" +
                " ██████  ██████  ██      ██ ███████     ██   ██  ██████  ██   ██ ██ ██   ████     ███████  ██████   ██████  ██   ████ ██ \n" +
                "                                                                                                                         \n" +
                "                                                                                                                         \n");
    }
}