package lab1.pojos;

public class Book extends Publication{
    public String author;

    public Book() {}
    public Book(String author, String title, double price, int copies) {
        super(title, price, copies);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", price=" + getPrice() +
                ", copies=" + getCopies() +
                '}';
    }

    @Override
    public void edit() {
        System.out.println("Editing Book - functionality will be implemented here...");
    }

    @Override
    public void initialize() {
        System.out.println("Initializing Book - functionality will be implemented here...");
    }

    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
            System.out.println("Sold 1 book: " + getTitle() + " by " + author);
        } else {
            System.out.println("Book out of stock: " + getTitle());
        }
    }
}
