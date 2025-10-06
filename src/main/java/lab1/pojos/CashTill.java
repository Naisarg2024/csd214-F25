package lab1.pojos;

public class CashTill {
    private double runningTotal;

    public void showTotal() {
        System.out.println("Till Total is: $%.2f " + runningTotal);
    }

    public void sellITem(SaleableItem item) {
        if (item == null) {
            System.out.println("No item provided.");
            return;
        }
        System.out.println("Processing...");
        item.sellItem();
        runningTotal += item.getPrice();
        System.out.printf("Added $%.2f to till.%n", item.getPrice());
        showTotal();
        System.out.println("End of sale.");
    }
}
