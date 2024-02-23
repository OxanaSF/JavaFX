import java.time.LocalDate;

public class ProductFactory {

    public enum ProductType {
        BOOK("book", true),
        AUDIO_BOOK("audiobook", true),
        E_BOOK("ebook", true);

        private String displayProduct;
        private boolean isBook;

        private ProductType(String displayProduct, boolean isBook) {
            this.displayProduct = displayProduct;
            this.isBook = isBook;
        }


        public String getProductType(String displayProduct) {
            return displayProduct;
        }

        public boolean isBook() {
            return isBook;
        }
    }

    public static Product createProduct(
            ProductType type,
            int id,
            String name,
            String description,
            Double price,
            String isbn,
            String author,
            LocalDate publicationDate,
            String narrator,
            double listeningLength,
            String linkToRead,
            String fileSize
    ) {
        Product product = null;
        if (type.equals(ProductType.BOOK)) {
            if (isbn != null && author != null && publicationDate != null) {
                product = new Book(type, id, name, description, price, isbn, author, publicationDate);
            }
        } else if (type.equals(ProductType.AUDIO_BOOK)) {
            if (narrator != null && listeningLength > 0) {
                product = new AudioBook(type, id, name, description, price, isbn, author,
                        publicationDate, listeningLength);
            }
        } else if (type.equals(ProductType.E_BOOK)) {
            if (linkToRead != null && fileSize != null) {
                product = new EBook(type, id, name, description, price, isbn, author,
                        publicationDate, fileSize);
            }
        }
        return product;
    }
}
