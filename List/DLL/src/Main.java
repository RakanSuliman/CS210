import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DLL dll = new DLL(); // Create a new doubly linked list
        Scanner scanner = new Scanner(System.in); //  Scanner for user input
        Random random = new Random(); // Random number generator
        int choice; // Variable to store user input choice

        do {
            // Display the menu options
            System.out.println("\nChoose an option:");
            System.out.println("1 - Insert");
            System.out.println("2 - Remove");
            System.out.println("3 - Search");
            System.out.println("4 - Print");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt(); // Read user input choice

                switch (choice) {
                    case 1:
                        // User choose either manually or random number
                        try {
                            System.out.println("Choose insertion type:");
                            System.out.println("1 - Manual Input");
                            System.out.println("2 - Random Numbers");
                            System.out.print("Enter your choice: ");
                            int insertChoice = scanner.nextInt();

                            if (insertChoice == 1) {
                                // Manual insertion
                                System.out.print("Enter the value to insert: ");
                                int insertValue = scanner.nextInt();
                                System.out.print("Enter the position to insert (0 for beginning): ");
                                int position = scanner.nextInt();
                                dll.insert(insertValue, position);
                                System.out.println("Inserted " + insertValue + " at position " + position);
                            } else if (insertChoice == 2) {
                                // Random number insertion
                                System.out.print("Enter the number of random elements to insert: ");
                                int size = scanner.nextInt();
                                System.out.print("Enter the range of random numbers (e.g., 100 for numbers between 0 and 99): ");
                                int range = scanner.nextInt();

                                for (int i = 0; i < size; i++) {
                                    int randomValue = random.nextInt(range); // Generate a random number within the range
                                    dll.insert(randomValue, i); // Insert at the current index
                                }
                                System.out.println(size + " random numbers inserted.");
                            } else {
                                System.out.println("Invalid choice for insertion type.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error during insertion: " + e.getMessage());
                        }
                        break;

                    case 2:
                        // Remove operation
                        try {
                            System.out.print("Enter the value to remove: ");
                            int removeValue = scanner.nextInt();
                            boolean removed = dll.remove(removeValue);
                            if (removed) {
                                System.out.println("Removed " + removeValue + " from the list.");
                            } else {
                                System.out.println("Value " + removeValue + " not found in the list.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error during removal: " + e.getMessage());
                        }
                        break;

                    case 3:
                        // Search operation
                        try {
                            System.out.print("Enter the value to search: ");
                            int searchValue = scanner.nextInt();
                            Node foundNode = dll.search(searchValue);
                            if (foundNode != null) {
                                System.out.println("Value " + searchValue + " found in the list.");
                            } else {
                                System.out.println("Value " + searchValue + " not found in the list.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error during search: " + e.getMessage());
                        }
                        break;

                    case 4:
                        // Print operation
                        try {
                            System.out.println("Current List:");
                            System.out.println(dll);
                        } catch (Exception e) {
                            System.out.println("Error during printing: " + e.getMessage());
                        }
                        break;

                    case 0:
                        // Exit operation
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        // Handle invalid input
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (Exception e) {
                // Handle input errors and any unexpected exceptions
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear the scanner buffer to avoid infinite loops on invalid input
                choice = -1; // Reset choice to avoid exiting the loop accidentally
            }

        } while (choice != 0); // FLAG

        scanner.close();
    }
}
