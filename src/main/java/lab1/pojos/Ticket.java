package lab1.pojos;

public class Ticket implements SaleableItem, Serializable{
    private int id;
    private String description;
    private double price;

    public Ticket() {}
    public Ticket(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void sellItem() {
        System.out.println("Sold ticket: " + description + " for $" + price);
    }
}
