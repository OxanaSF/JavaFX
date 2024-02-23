import java.time.LocalDate;

public class AudioBook extends Book {
    private double listeningLength;

    public AudioBook(ProductFactory.ProductType type, int id, String name,
                     String description, double price, String isbn,
                     String author, LocalDate publicationDate, double listeningLength) {
        super(type, id, name, description, price, isbn, author, publicationDate);
        this.listeningLength = listeningLength;
    }

    public double getListeningLength() {
        return listeningLength;
    }

    public void setListeningLength(double listeningLength) {
        this.listeningLength = listeningLength;
    }

    @Override
    public String toString() {
        String dataFromProduct = super.toString();
        dataFromProduct += "Listening Length: " + listeningLength + "\n";

        return dataFromProduct;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof AudioBook otherBook)
                && super.equals(obj)
                && this.listeningLength == otherBook.listeningLength;
    }

    public void play() {
        System.out.println("Is playing " + getName());
    }

    public void stopPlay() {
        System.out.println("Stopped playing: " + getName());
    }
}
