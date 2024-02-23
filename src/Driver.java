import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();


        LocalDate bookPublicationDate33 = LocalDate.of(1973, 4, 2);


        // Interactive Driver part 1 START
        ArrayList<Book> books = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        boolean keepCreatingProducts = true;
        System.out.print("Welcome!");

        while (keepCreatingProducts) {
            System.out.print("You are at the beginning of creating product");

            boolean keepEntering1 = true;
            ProductFactory.ProductType type = null;

            while (keepEntering1) {
                System.out.println("Enter product details:");
                System.out.println("Select # for product type:");
                System.out.println("1 (Book)");
                System.out.println("2 (Audio Book)");
                System.out.println("3 (E-Book)");
                System.out.print("Enter choice: ");

                try {
                    int productChoice = Integer.parseInt(scan.nextLine());

                    switch (productChoice) {
                        case 1:
                            type = ProductFactory.ProductType.BOOK;
                            keepEntering1 = false;
                            break;
                        case 2:
                            type = ProductFactory.ProductType.AUDIO_BOOK;
                            keepEntering1 = false;
                            break;
                        case 3:
                            type = ProductFactory.ProductType.E_BOOK;
                            keepEntering1 = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }

            }

            int id = validateIntegerInput(scan, "Product ID: ");

            boolean availability;
            while (true) {
                System.out.print("Availability (true/false): ");
                String availabilityInput = scan.nextLine().toLowerCase();

                switch (availabilityInput) {
                    case "true":
                        availability = true;
                        break;
                    case "false":
                        availability = false;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 'true' or 'false'.");
                        continue;
                }

                break;
            }

            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Description: ");
            String description = scan.nextLine();

            double price = validateDoubleNumericInput(scan, "Price: ");

            String isbn = "";
            String author = "";
            String publisher = "";
            String genre = "";
            String language = "";
            LocalDate publicationDate = null;

            Book newBook = null;

            System.out.print("ISBN: ");
            isbn = scan.nextLine();

            System.out.print("Author: ");
            author = scan.nextLine();


            boolean validDate = false;

            while (!validDate) {
                try {
                    System.out.print("Publication Date (yyyy-mm-dd): ");
                    String dateInput = scan.nextLine();
                    publicationDate = LocalDate.parse(dateInput);
                    validDate = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
                }
            }

            switch (type) {
                case BOOK:
                    newBook = new Book(type, id, name, description, price, isbn, author, publicationDate);
                    break;
                case AUDIO_BOOK:
                    double listeningLength = validateDoubleNumericInput(scan, "Listening Length: ");

                    newBook = new AudioBook(type, id, name, description, price,
                            isbn, author, publicationDate, listeningLength);
                    break;
                case E_BOOK:
                    System.out.print("File Size: ");
                    String fileSize = scan.nextLine();


                    newBook = new EBook(type, id, name, description, price,
                            isbn, author, publicationDate, fileSize);
                    break;

            }

            System.out.println(newBook);

            books.add(newBook);
            System.out.println("Book added successfully!");

            String tryYesNoInput = "";
            boolean validYesNoInput = false;

            while (!validYesNoInput) {
                System.out.println("Do you want to enter another book? (yes/no)");
                tryYesNoInput = scan.nextLine().toLowerCase();

                if (tryYesNoInput.equals("yes") || tryYesNoInput.equals("no")) {
                    validYesNoInput = true;
                } else {
                    System.out.println("Invalid input. Please enter yes or no.");
                }
            }

            if (tryYesNoInput.equals("no")) {
                keepEntering1 = false;
                break;
            }

        }

        // Interactive Driver part 1 END


    }

    public static double validateDoubleNumericInput(Scanner scan, String userInput) {
        boolean validInput = false;
        double value = 0.0;

        while (!validInput) {
            try {
                System.out.print(userInput);
                value = Double.parseDouble(scan.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return value;
    }

    public static int validateIntegerInput(Scanner scan, String userInput) {
        boolean validInput = false;
        int value = 0;

        while (!validInput) {
            try {
                System.out.print(userInput);
                value = Integer.parseInt(scan.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return value;
    }


}