package lab1.pojos;

import java.util.Objects;

public abstract class Publication extends Editable implements SaleableItem {
    private String title;
    private double price;
    private int copies;

    public Publication() {

    }

    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Publication-> [" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Double.compare(that.price, price) == 0 &&
                copies == that.copies &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {return Objects.hash(title, price, copies);}

}
