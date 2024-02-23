import java.util.ArrayList;

public abstract class Product {
    private ProductFactory.ProductType type;
    private int id;
    private String category;
    private String name;
    private String description;
    private double price;

    private static int numProducts = 0;
    private static ArrayList<Product> productList = new ArrayList<>();

    public Product(ProductFactory.ProductType type,
                   int id,
                   String category,
                   String name,
                   String description,
                   double price) {
        this.type = type;
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;

        productList.add(this);
        Product.numProducts++;
    }

    public static ArrayList<Product> getProductList() {
        return productList;
    }

    public static int getNumProducts() {
        return Product.numProducts;
    }

    public ProductFactory.ProductType getType() {
        return type;
    }

    public void setType(ProductFactory.ProductType type) {
        this.type = type;
    }

    public static void setNumProducts(int numProducts) {
        Product.numProducts = numProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Type: " + type + "\n" +
                "Id: " + id + "\n" +
                "Category: " + category + "\n" +
                "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Price: " + price + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Product otherProduct)
                && this.type.equals(otherProduct.type)
                && this.id == otherProduct.id
                && this.category.equals(otherProduct.category)
                && this.name.equals(otherProduct.name)
                && this.description.equals(otherProduct.description)
                && this.price == otherProduct.price;
    }


}