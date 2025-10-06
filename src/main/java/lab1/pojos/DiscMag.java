package lab1.pojos;
import java.time.LocalDate;
public class DiscMag extends Magazine{
    private boolean hasDisc;

    public DiscMag() {}

    public DiscMag(boolean hasDisc, int orderQty, LocalDate currentIssue, String title, double price, int copies) {
        super(orderQty,currentIssue,title,price,copies);
        this.hasDisc = hasDisc;
    }

    public boolean isHasDisc() { return hasDisc; }
    public void setHasDisc(boolean hasDisc) { this.hasDisc = hasDisc; }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Editing DiscMag - functionality will be implemented here...");
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Initializing DiscMag - functionality will be implemented here...");
    }

    @Override
    public void sellItem() {
        super.sellItem();
        System.out.println("Includes disc: " + hasDisc);
    }
}
