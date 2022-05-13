import java.util.Scanner;

public class Lab4c {
    public static void main (String[] args) {

        // Declaring all variables
        Scanner input = new Scanner(System.in);
        String usertemp = "0";
        double temp = 0;
        char unit = '0';
        boolean run = true;
        boolean override = false;
        double result = 0;
        boolean debug = false;

        while (run == true) {
            System.out.println("Give a temp to be converted followed by F (For fahrenheit) or C (For celsius) or Q to quit");
            // Makes it so that it only shows the example the first time the program is run since
            if (unit == '0')
                System.out.println("Example: 100f converts to celsius");
            usertemp = input.nextLine();

            // Checks for close program condition
            if (usertemp.contains("q")) {
                run = false;
                System.out.println("Closing program...");
                break;
            }

            // Sets last char of usertemp to unit and sets it to be lowercase
            unit = Character.toLowerCase(usertemp.charAt(usertemp.length() - 1));

            // Checks if unit is valid

            if (unit == 'f' || unit == 'c') {
                try {
                    usertemp = usertemp.replaceAll("([a-z])", "");
                    temp = Double.parseDouble(usertemp);
                } catch(Exception e) {
                    System.out.println("ERROR: Invalid input given, try again...");
                    override = true;
                }
            }

            // Override prevents a crash from occurring when an issue is detected
            if (override == false) {
                switch (unit) {
                    // Valid input
                    case 'f':
                        result = ((temp - 32.0)* 5/9);
                        result = Math.round(result * 100.0) / 100.0;
                        System.out.println("Result: " + result + "c");
                        break;
                    case 'c':
                        result = (temp * 1.8)+32;
                        result = Math.round(result * 100.0) / 100.0;
                        System.out.println("Result: " + result + "f");
                        break;
                    // Invalid input
                    default:
                        System.out.println("Invalid input given, try again...");
                        // Prevents example message from showing up again potentially
                        unit = '1';
                        break;
                }
            } else if (debug == true)
                System.out.println("Overrided");
            override = false;
        }
    }
}
