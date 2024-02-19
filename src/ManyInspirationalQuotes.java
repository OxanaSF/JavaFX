import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;

import java.util.ArrayList;
import java.util.Random;

public class ManyInspirationalQuotes extends Application {
    private Label quoteInputFieldLabel, generateQuoteLabel;
    private TextField quoteInputField;
    private Button addQuoteBtn, generateQuoteBtn;
    private Text quoteTextToAdd, quoteTextToGenerate;
    private ArrayList<String> quotesList;


    @Override
    public void start(Stage primaryStage) {
        quotesList = new ArrayList<>();
        quotesList.add("When you have a dream, you've got to grab it and never let go.");
        quotesList.add("Nothing is impossible. The word itself says 'I'm possible!'");
        quotesList.add("The bad news is time flies. The good news is you're the pilot.");

        BorderPane borderPane = new BorderPane();
        VBox boxPane = new VBox();
        borderPane.setCenter(boxPane);

        boxPane.setSpacing(20.00);
        boxPane.setAlignment(Pos.CENTER);
        boxPane.setMaxSize(350.00, 300);


        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(38, 80, 115), null, null);
        Background background = new Background(backgroundFill);
        borderPane.setBackground(background);

        quoteInputFieldLabel = new Label("Enter an Inspirational Quote");
        quoteInputFieldLabel.setTextFill(Color.rgb(241, 250, 218));
        quoteInputFieldLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 21px; -fx-letter-spacing: 2px;");
        boxPane.getChildren().add(quoteInputFieldLabel);

        quoteInputField = new TextField();
        quoteInputField.setOnAction(this::processQuoteTextField);
        quoteInputField.setStyle("-fx-border-color: rgb(45, 149, 150); -fx-background: rgb(154, 208, 194); " +
                "-fx-background-radius: 5px; -fx-border-radius: 5px; -fx-padding: 5px;");
        boxPane.getChildren().add(quoteInputField);

        addQuoteBtn = new Button("ADD QUOTE");
        addQuoteBtn.setOnAction(this::processQuoteTextField);
        addQuoteBtn.setStyle("-fx-font-weight: bold; -fx-text-fill: rgb(38, 80, 115); -fx-background-color: lightgray; -fx-padding: 10 20 10 20;");
        addQuoteBtn.setMaxWidth(350.00);
        boxPane.getChildren().add(addQuoteBtn);

        quoteTextToAdd = new Text("");
        boxPane.getChildren().add(quoteTextToAdd);

        generateQuoteLabel = new Label("Generate an Inspiration Quote");
        generateQuoteLabel.setTextFill(Color.rgb(241, 250, 218));
        generateQuoteLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 21px; -fx-letter-spacing: 2px;");
        boxPane.getChildren().add(generateQuoteLabel);


        generateQuoteBtn = new Button("GENERATE QUOTE");
        generateQuoteBtn.setOnAction(this::generateRandomeQuote);
        boxPane.getChildren().add(generateQuoteBtn);
        generateQuoteBtn.setStyle("-fx-font-weight: bold; -fx-text-fill: rgb(38, 80, 115); -fx-background-color: lightgray; -fx-padding: 10 20 10 20;");
        generateQuoteBtn.setMaxWidth(350.00);

        quoteTextToGenerate = new Text("");
        quoteTextToGenerate.setStyle("-fx-border-color: rgb(45, 149, 150); -fx-background: rgb(154, 208, 194);");
        boxPane.getChildren().add(quoteTextToGenerate);

        Scene scene = new Scene(borderPane, 640, 480, Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void processQuoteTextField(ActionEvent event) {
        String quote = quoteInputField.getText();
        quotesList.add(quote);
        if (!quote.isEmpty()) {
            String userInputText = "Added: " + quote;
            quoteTextToAdd.setText(userInputText);
            quoteTextToAdd.setStyle("-fx-fill: rgb(154, 208, 194); -fx-font-size: 16px;");
        } else {
            String userInputText = "Not added yet!";
            quoteTextToAdd.setText(userInputText);
            quoteTextToAdd.setStyle("-fx-fill: red; -fx-font-size: 14px;");
        }
        quoteInputField.clear();

    }

    public void generateRandomeQuote(ActionEvent event) {
        quoteTextToAdd.setText("");
        Random random = new Random();
        int size = quotesList.size();
        int randomIndex = random.nextInt(size);
        System.out.println(randomIndex);
        String randomeQuote = quotesList.get(randomIndex);
        quoteTextToGenerate.setText(randomeQuote);
        quoteTextToGenerate.setStyle("-fx-fill: rgb(154, 208, 194); -fx-font-size: 22px;");
        ;
    }

    public static void main(String[] args) {
        launch();
    }

}