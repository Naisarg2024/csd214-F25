package lab1.pojos;

import java.time.LocalDate;

public class Magazine extends Publication{

    private int orderQty;
    private LocalDate currentIssue;

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty){
        this.orderQty = orderQty;
    }

    public LocalDate getCurrentIssue(){
        return currentIssue;
    }

    public void setCurrentIssue(LocalDate currentIssue){
        this.currentIssue = currentIssue;
    }

    public Magazine() {}

    public Magazine(int orderQty, LocalDate currentIssue, String title, double price, int copies){
        super(title, price, copies);
        this.currentIssue = currentIssue;
        this.orderQty = orderQty;
    }

    public void edit(){
        System.out.println("Editing Magazine - functionality will be implemented here...");
    }

    @Override
    public void initialize(){
        System.out.println("Initializing Magazine - functionality will be implemented here...");
    }

    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies()-1);
            System.out.println("Sold 1 copy of "+ getTitle() + " magazine!");
        } else {
            System.out.println(getTitle() + " magazine is currently out of stock!");
        }
    }
}
