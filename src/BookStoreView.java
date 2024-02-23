import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.event.*;


public class BookStoreView {
    BorderPane borderPane;
    private Label idLabel, nameLabel, descriptionLabel, priceLabel, isbnLabel, authorLabel, resultDisplayLabel,
            publicationDateLabel, listeningLengthLabel, fileSizeLabel;
    private Text bookStoreNameText, welcomeText, productDetails;
    private TextField idField, nameField, priceField, isbnField, authorField,
            publicationDateField, listeningLengthField, fileSizeField;
    private TextArea descriptionArea, resultDisplay;
    private RadioButton bookRadioButton, audioBookRadioButton, eBookRadioButton;
    private VBox idBox, nameBox, descriptionBox, priceBox, isbnBox, authorBox, publicationDateBox,
            listeningLengthBox, fileSizeBox;
    private Button addProductButton, displayProductsButton;


    private final static Font LABEL_FONT = Font.font(15);
    private static final Color LABEL_TEXT_COLOR = Color.rgb(243, 250, 250);
    private static final double INPUT_BOX_SPACING = 10.0;

    public BookStoreView() {

        borderPane = new BorderPane();
        VBox vMiddleVBox = new VBox();
        vMiddleVBox.setPadding(new Insets(40));
        vMiddleVBox.setSpacing(40);
        VBox vLeftBoxPane = new VBox();

        ScrollPane scroller = new ScrollPane(vMiddleVBox);
        scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        borderPane.setLeft(vLeftBoxPane);
        borderPane.setCenter(scroller);

        vLeftBoxPane.setAlignment(Pos.CENTER);
        vLeftBoxPane.setSpacing(40);
        vLeftBoxPane.setBackground(new Background(new BackgroundFill(Color.rgb(
                243, 250, 250), null, null)));


        vMiddleVBox.setBackground(new Background(new BackgroundFill(Color.rgb(
                214, 39, 56), null, null)));

        bookStoreNameText = new Text("Book Store");
        bookStoreNameText.setFont(Font.font(36));
        bookStoreNameText.setFill(Color.rgb(38, 74, 102));
        vLeftBoxPane.getChildren().add(bookStoreNameText);


        Image bgImage = new Image("file:images/bg_bookstore.jpg");
        ImageView imageView = new ImageView(bgImage);
        imageView.setFitWidth(240);
        imageView.setFitHeight(250);
        vLeftBoxPane.getChildren().add(imageView);


        welcomeText = new Text("Welcome to the Book Store input system!\n Provide the book data below.");
        welcomeText.setFont(Font.font((26)));
        welcomeText.setFill(Color.rgb(243, 250, 250));
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        vMiddleVBox.getChildren().add(welcomeText);


        productDetails = new Text("Select product type: ");
        productDetails.setFont(Font.font(18));
        productDetails.setFill(Color.rgb(243, 250, 250));
        ToggleGroup productChoiceGroup = new ToggleGroup();
        bookRadioButton = new RadioButton("Book");
        bookRadioButton.setFont(LABEL_FONT);
        bookRadioButton.setTextFill(LABEL_TEXT_COLOR);
        bookRadioButton.setSelected(true);
        bookRadioButton.setOnAction(this::handleBookFieldsVisability);
        bookRadioButton.setToggleGroup(productChoiceGroup);
        audioBookRadioButton = new RadioButton("Audio Book");
        audioBookRadioButton.setFont(LABEL_FONT);
        audioBookRadioButton.setTextFill(LABEL_TEXT_COLOR);
        audioBookRadioButton.setOnAction(this::handleAudioBookFieldsVisability);
        audioBookRadioButton.setToggleGroup(productChoiceGroup);
        eBookRadioButton = new RadioButton("E Book");
        eBookRadioButton.setFont(LABEL_FONT);
        eBookRadioButton.setTextFill(LABEL_TEXT_COLOR);
        eBookRadioButton.setOnAction(this::handleEBookFieldsVisability);
        eBookRadioButton.setToggleGroup(productChoiceGroup);
        VBox radioButtonsBox = new VBox(10);
        radioButtonsBox.getChildren().addAll(bookRadioButton, audioBookRadioButton, eBookRadioButton);
        vMiddleVBox.getChildren().addAll(productDetails, radioButtonsBox);


        idLabel = new Label("Enter the ID:");
        idLabel.setFont(LABEL_FONT);
        idLabel.setTextFill(LABEL_TEXT_COLOR);
        idField = new TextField();
        idBox = new VBox(idLabel, idField);
        idBox.setSpacing(INPUT_BOX_SPACING);
        idBox.setAlignment(Pos.CENTER_LEFT);
        vMiddleVBox.getChildren().add(idBox);


        nameLabel = new Label("Enter the Name:");
        nameLabel.setFont(LABEL_FONT);
        nameLabel.setTextFill(LABEL_TEXT_COLOR);
        nameField = new TextField();
        nameBox = new VBox(nameLabel, nameField);
        nameBox.setSpacing(INPUT_BOX_SPACING);
        nameBox.setAlignment(Pos.CENTER_LEFT);
        vMiddleVBox.getChildren().add(nameBox);


        descriptionLabel = new Label("Enter the Description:");
        descriptionLabel.setFont(LABEL_FONT);
        descriptionLabel.setTextFill(LABEL_TEXT_COLOR);
        descriptionArea = new TextArea();
        descriptionBox = new VBox(descriptionLabel, descriptionArea);
        descriptionBox.setSpacing(INPUT_BOX_SPACING);
        descriptionBox.setAlignment(Pos.CENTER_LEFT);
        vMiddleVBox.getChildren().add(descriptionBox);


        priceLabel = new Label("Enter the Price:");
        priceLabel.setFont(LABEL_FONT);
        priceLabel.setTextFill(LABEL_TEXT_COLOR);
        priceField = new TextField();
        priceBox = new VBox(priceLabel, priceField);
        priceBox.setSpacing(INPUT_BOX_SPACING);
        priceBox.setAlignment(Pos.CENTER_LEFT);
        vMiddleVBox.getChildren().add(priceBox);


        isbnLabel = new Label("Enter the ISBN:");
        isbnLabel.setFont(LABEL_FONT);
        isbnLabel.setTextFill(LABEL_TEXT_COLOR);
        isbnField = new TextField();
        isbnBox = new VBox(isbnLabel, isbnField);
        isbnBox.setSpacing(INPUT_BOX_SPACING);
        isbnBox.setAlignment(Pos.CENTER_LEFT);
        vMiddleVBox.getChildren().add(isbnBox);


        authorLabel = new Label("Enter the Author:");
        authorLabel.setFont(LABEL_FONT);
        authorLabel.setTextFill(LABEL_TEXT_COLOR);
        authorField = new TextField();
        authorBox = new VBox(authorLabel, authorField);
        authorBox.setSpacing(INPUT_BOX_SPACING);
        authorBox.setAlignment(Pos.CENTER_LEFT);
        vMiddleVBox.getChildren().add(authorBox);


        publicationDateLabel = new Label("Enter the Publication Date (yyyy-mm-dd):");
        publicationDateLabel.setFont(LABEL_FONT);
        publicationDateLabel.setTextFill(LABEL_TEXT_COLOR);
        publicationDateField = new TextField();
        publicationDateBox = new VBox(publicationDateLabel, publicationDateField);
        publicationDateBox.setSpacing(INPUT_BOX_SPACING);
        publicationDateBox.setAlignment(Pos.CENTER_LEFT);
        vMiddleVBox.getChildren().add(publicationDateBox);
        listeningLengthLabel = new Label("Enter the Listening Length if it's an audio book:");
        listeningLengthLabel.setFont(LABEL_FONT);
        listeningLengthLabel.setTextFill(LABEL_TEXT_COLOR);
        listeningLengthField = new TextField();
        listeningLengthBox = new VBox(listeningLengthLabel, listeningLengthField);
        listeningLengthBox.setSpacing(INPUT_BOX_SPACING);
        listeningLengthBox.setAlignment(Pos.CENTER_LEFT);
        listeningLengthBox.setDisable(true);
        vMiddleVBox.getChildren().add(listeningLengthBox);


        fileSizeLabel = new Label("Enter the File Size if it's an  e-book:");
        fileSizeLabel.setFont(LABEL_FONT);
        fileSizeLabel.setTextFill(LABEL_TEXT_COLOR);
        fileSizeField = new TextField();
        fileSizeBox = new VBox(fileSizeLabel, fileSizeField);
        fileSizeBox.setSpacing(INPUT_BOX_SPACING);
        fileSizeBox.setAlignment(Pos.CENTER_LEFT);
        fileSizeBox.setDisable(true);
        vMiddleVBox.getChildren().add(fileSizeBox);


        addProductButton = new Button("Add Book");
        displayProductsButton = new Button("Show Product Data");
        vMiddleVBox.getChildren().addAll(addProductButton, displayProductsButton);

        resultDisplayLabel = new Label("LABEL PLACEHOLDER");
        resultDisplayLabel.setFont(LABEL_FONT);
        resultDisplayLabel.setTextFill(LABEL_TEXT_COLOR);
        resultDisplayLabel.setVisible(false);
        resultDisplay = new TextArea("RESULT DISPLAY PLACEHOLDER");
        resultDisplay.setVisible(false);
        resultDisplay.setEditable(false);
        VBox resultBox = new VBox(resultDisplayLabel, resultDisplay);
        resultBox.setAlignment(Pos.CENTER);
        resultBox.setSpacing(10);
        vMiddleVBox.getChildren().add(resultBox);
    }

    public Parent getParent() {
        return borderPane;
    }


    public ProductFactory.ProductType getSelectedProductType() {
        if (bookRadioButton.isSelected()) {
            System.out.println(("BOOK selected"));
            return ProductFactory.ProductType.BOOK;
        } else if (audioBookRadioButton.isSelected()) {
            System.out.println(("AUDIO BOOK IS SELECTED"));
            return ProductFactory.ProductType.AUDIO_BOOK;
        } else {
            System.out.println(("E BOOK IS SELECTED"));
            return ProductFactory.ProductType.E_BOOK;
        }
    }

    private void handleBookFieldsVisability(ActionEvent event) {
        setFieldsEnabled(true);
        listeningLengthBox.setDisable(false);
        fileSizeBox.setDisable(false);
        getSelectedProductType();
    }


    private void handleAudioBookFieldsVisability(ActionEvent event) {
        setFieldsEnabled(true);
        listeningLengthBox.setDisable(false);
        fileSizeBox.setDisable(true);
        getSelectedProductType();
    }

    private void handleEBookFieldsVisability(ActionEvent event) {
        setFieldsEnabled(true);
        listeningLengthBox.setDisable(true);
        fileSizeBox.setDisable(false);
        getSelectedProductType();
    }

    public void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void setFieldsEnabled(boolean enable) {
        idBox.setDisable(!enable);
        nameBox.setDisable(!enable);
        descriptionBox.setDisable(!enable);
        priceBox.setDisable(!enable);
        isbnBox.setDisable(!enable);
        authorBox.setDisable(!enable);
        publicationDateBox.setDisable(!enable);
        listeningLengthBox.setDisable(!enable);
        fileSizeBox.setDisable(!enable);
    }


    public void displayResultText(String label, String output) {
        resultDisplayLabel.setVisible(true);
        resultDisplayLabel.setText(label);
        resultDisplay.clear();
        resultDisplay.setVisible(true);
        resultDisplay.setText(output);
    }

    public void hideResultText() {
        resultDisplay.clear();
        resultDisplay.setVisible(false);
        resultDisplayLabel.setVisible(false);
    }


    public void clearInputs() {
        idField.clear();
        nameField.clear();
        descriptionArea.clear();
        priceField.clear();
        isbnField.clear();
        authorField.clear();
        publicationDateField.clear();
        listeningLengthField.clear();
        fileSizeField.clear();

    }


    public void setAddProductAction(EventHandler<ActionEvent> handler) {

        addProductButton.setOnAction(handler);
    }

    public void setDisplayProductsAction(EventHandler<ActionEvent> handler) {
        displayProductsButton.setOnAction(handler);
    }


    public String getIdField() {
        return idField.getText();
    }

    public void setIdField(String text) {
        idField.setText(text);
    }

    public String getNameField() {

        return nameField.getText();
    }

    public void setNameField(String text) {

        nameField.setText(text);
    }

    public String getDescriptionField() {

        return descriptionArea.getText();
    }

    public void setDescriptionField(String text) {

        descriptionArea.setText(text);
    }

    public String getPriceField() {

        return priceField.getText();
    }

    public void setPriceField(String text) {

        priceField.setText(text);
    }

    public String getIsbnField() {

        return isbnField.getText();
    }

    public void setIsbnField(String text) {

        isbnField.setText(text);
    }

    public String getAuthorField() {

        return authorField.getText();
    }

    public void setAuthorField(String text) {

        authorField.setText(text);
    }


    public String getPublicationDateField() {

        return publicationDateField.getText();
    }

    public void setPublicationDateField(String text) {

        publicationDateField.setText(text);
    }

    public String getListeningLengthField() {

        return listeningLengthField.getText();
    }

    public void setListeningLengthField(String text) {

        listeningLengthField.setText(text);
    }

    public String getFileSizeField() {

        return fileSizeField.getText();
    }

    public void setFileSizeField(String text) {

        fileSizeField.setText(text);
    }


}