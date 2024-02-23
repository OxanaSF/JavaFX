import java.time.LocalDate;

public class EBook extends Book {
    private String fileSize;


    public EBook(ProductFactory.ProductType type, int id, String name, String description,
                 double price, String isbn, String author, LocalDate publicationDate, String fileSize) {
        super(type, id, name, description, price, isbn, author, publicationDate);
        this.fileSize = fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        String dataFromProduct = super.toString();
        dataFromProduct += "File size: " + fileSize + "\n";

        return dataFromProduct;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof EBook otherBook)
                && super.equals(obj)
                && this.fileSize.equals(otherBook.fileSize);
    }

    public void download() {
        System.out.println("Downloading book: " + getName());
    }
}
