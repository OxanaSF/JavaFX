import java.time.LocalDate;

public class Book extends Product {
    private String isbn;
    private String author;
    private LocalDate publicationDate;

    private static final String DEFAULT_BOOK_CATEGORY = "book";

    public Book(ProductFactory.ProductType type, int id, String name, String description,
                double price, String isbn, String author, LocalDate publicationDate) {
        super(type, id, DEFAULT_BOOK_CATEGORY, name, description, price);


        this.isbn = isbn;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        String dataFromProduct = super.toString();
        dataFromProduct +=
                "ISBN: " + isbn + "\n" +
                        "Author: " + author + "\n" +
                        "Publication date: " + publicationDate + "\n";

        return dataFromProduct;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Book otherBook)
                && super.equals(obj)
                && this.isbn.equals(otherBook.isbn)
                && this.author.equals(otherBook.author)
                && this.publicationDate.isEqual(otherBook.publicationDate);
    }

}
