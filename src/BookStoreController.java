import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookStoreController extends Application {
    private BookStoreView bookStoreView;

    public BookStoreController() {
        bookStoreView = new BookStoreView(); // the view
        bookStoreView.setAddProductAction(this::addProduct);
        bookStoreView.setDisplayProductsAction(this::displayProducts);
    }


    @Override
    public void start(Stage primaryStage) {
        BookStoreController controller = new BookStoreController();

        Scene scene = new Scene(controller.bookStoreView.getParent(), 450, 500, Color.TRANSPARENT);
        primaryStage.setTitle("Product Data Processing System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    private void addProduct(ActionEvent event) {
        System.out.println("Clicked ADD");
        String errorMessage = "";
        try {
            int id = Integer.parseInt(bookStoreView.getIdField());
            System.out.println("Parsed ID: " + id);
            String name = bookStoreView.getNameField();
            String description = bookStoreView.getDescriptionField();
            double price = Double.parseDouble(bookStoreView.getPriceField());
            System.out.println("Parsed price: " + price);
            String isbn = bookStoreView.getIsbnField();
            String author = bookStoreView.getAuthorField();
            LocalDate publicationDate = LocalDate.parse(bookStoreView.getPublicationDateField());


            if (name.isEmpty() || description.isEmpty() || isbn.isEmpty() ||
                    author.isEmpty() || publicationDate == null) {
                errorMessage = "Fields can't be empty";
                throw new IllegalArgumentException();
            }

            ProductFactory.ProductType type = bookStoreView.getSelectedProductType();

            Product product = null;

            switch (type) {
                case BOOK:
                    product = new Book(type, id, name, description, price, isbn, author, publicationDate);
                    break;
                case AUDIO_BOOK:
                    double listeningLength = Double.parseDouble(bookStoreView.getListeningLengthField());
                    System.out.println("Parsed  listeningLength: " + listeningLength);
                    product = new AudioBook(type, id, name, description, price, isbn, author, publicationDate, listeningLength);
                    break;
                case E_BOOK:
                    String fileSize = bookStoreView.getFileSizeField();
                    System.out.println("Parsed  fileSize: " + fileSize);
                    product = new EBook(type, id, name, description, price, isbn, author, publicationDate, fileSize);
                    break;
            }
            bookStoreView.showSuccessAlert("Book successfully added!");
            bookStoreView.clearInputs();


        } catch (NumberFormatException e) {
            errorMessage = "Invalid Number: " + e.getMessage();
            showAlert(errorMessage);
        } catch (DateTimeException e) {
            errorMessage = "Invalid Date: " + e.getMessage();
            showAlert(errorMessage);
        } catch (IllegalArgumentException e) {
            showAlert(errorMessage);
        } finally {
            bookStoreView.hideResultText();
        }
    }


    private void displayProducts(ActionEvent event) {

        ArrayList<Product> productList = Product.getProductList();
        String output = "";
        for (Product p : productList) {
            output += p.toString();
        }
        bookStoreView.displayResultText("Books: ", output);

    }

    private void showAlert(String errorMessage) {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error");
        error.setHeaderText(null);
        error.setContentText(errorMessage);
        error.showAndWait();
    }

}
