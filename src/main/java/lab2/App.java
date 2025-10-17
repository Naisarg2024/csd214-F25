package lab2;

import lab2.pojos.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // fields / menu
    private final String menu =
            "\n***********************\n"
                    + " 1. Add Items\n"
                    + " 2. Edit Items\n"
                    + " 3. Delete Items\n"
                    + " 4. Sell item(s)\n"
                    + " 5. List items\n"
                    + "99. Quit\n"
                    + "***********************\n"
                    + "Enter choice: ";

    private final List<SaleableItem> saleableItems = new ArrayList<>();
    private int currentItem = 0;

    private Scanner input;
    private final PrintStream out;

    // Constructors
    public App() {
        this(System.in, System.out);
        populate();
    }
    public App(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.out = out;
    }

    public void run() {
        boolean running = true;
        while (running) {
            out.print(menu);
            String choice = input.nextLine().trim();
            switch (choice) {
                case "1" -> addItem();
                case "2" -> editItem();
                case "3" -> deleteItem();
                case "4" -> sellItem();
                case "5" -> listAny();
                case "99" -> {
                    out.println("Exiting...");
                    running = false;
                }
                default -> out.println("Invalid choice, (valid options are 1 to 5 and 99 to quit)");
            }
        }
    }

    // helpers
    public boolean findItemExists(SaleableItem probe) {
        return saleableItems.stream().anyMatch(it -> it.equals(probe));
    }

    public SaleableItem findItem(SaleableItem probe) {
        return saleableItems.stream().filter(it -> it.equals(probe)).findFirst().orElse(null);
    }

    public void editItem() {
        if (saleableItems.isEmpty()) {
            out.println("No items to edit.");
            return;
        }
        out.println("Edit an item");
        printIndexedList(saleableItems);
        out.print("Choose an item to edit or 99 to exit: ");
        String pick = input.nextLine().trim();
        if ("99".equals(pick)) return;

        int idx = parseIndex(pick, saleableItems.size());
        if (idx == -1) { out.println("Invalid selection."); return; }
        currentItem = idx;
        SaleableItem sel = saleableItems.get(idx);

        if (sel instanceof Editable editable) {
            editItem(editable);
            out.println("Item updated.");
        } else {
            out.println("This item type is not editable.");
        }
    }

    public void editItem(Editable editable) {
        editable.edit();
    }

    public void deleteItem() {
        if (saleableItems.isEmpty()) {
            out.println("No items to delete.");
            return;
        }
        out.println("Delete an item");
        printIndexedList(saleableItems);
        out.print("Choose an item to delete or 99 to exit: ");
        String pick = input.nextLine().trim();
        if ("99".equals(pick)) return;

        int idx = parseIndex(pick, saleableItems.size());
        if (idx == -1) { out.println("Invalid selection."); return; }
        SaleableItem removed = saleableItems.remove(idx);
        out.println("Deleted: " + removed);
    }

    public void populate() {
        saleableItems.add(new Book(
                java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                "Scientific Breakthroughs",
                19.99,
                5,
                443728495,
                "Book: Sci-Fi Book",
                "Naisarg Patel"
        ));
        saleableItems.add(new Magazine(
                java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                "Sample Magazine",
                6.99,
                8,
                1234567890,
                "Magazine: Tech Monthly",
                10,                        // orderQty
                java.time.LocalDate.now()  // currentIssue
        ));
        saleableItems.add(new DiscMag(
                new Magazine(
                        java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                        "Sample DiscMag",
                        9.99,
                        3,
                        968464728,
                        "Magazine with disc: Science Today",
                        7,
                        java.time.LocalDate.now()
                ),
                true // hasDisc
        ));
        saleableItems.add(new Ticket(
                java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                "Sample Event Ticket - Live Concert",
                12.50
        ));
    }

    public void listAny() {
        out.println("All Items");
        out.println("-----------");
        boolean listing = true;
        while (listing) {
            out.println("\nList");
            out.println("1. All");
            out.println("2. Books");
            out.println("3. Magazines");
            out.println("4. DiscMags");
            out.println("5. Tickets");
            out.println("99. Exit");
            String c = input.nextLine().trim();
            switch (c) {
                case "1" -> listI(null);
                case "2" -> listI(Book.class);
                case "3" -> listI(Magazine.class);
                case "4" -> listI(DiscMag.class);
                case "5" -> listI(Ticket.class);
                case "99" -> listing = false;
                default -> out.println("Invalid choice (valid options are 1..5, 99 to exit).");
            }
        }
    }

    public SaleableItem getItem(SaleableItem probe) {
        return findItem(probe);
    }

    public void sellItem() {
        if (saleableItems.isEmpty()) {
            out.println("No items to sell.");
            return;
        }
        out.println("Sell an item");
        printIndexedList(saleableItems);
        out.print("Choose an item to sell or 99 to exit: ");
        String pick = input.nextLine().trim();
        if ("99".equals(pick)) return;

        int idx = parseIndex(pick, saleableItems.size());
        if (idx == -1) { out.println("Invalid selection."); return; }

        SaleableItem sel = saleableItems.get(idx);
        CashTill till = new CashTill();
        till.sellITem(sel);
    }

    public void listI(Object typeOrNull) {
        int i = 1;
        for (SaleableItem it : saleableItems) {
            if (typeOrNull == null
                    || (typeOrNull instanceof Class<?> c && c.isInstance(it))) {
                out.printf("%d. %s%n%n", i, it);
            }
            i++;
        }
    }

    public void addItem() {
        boolean back = false;
        while (!back) {
            out.println("\nAdd an item");
            out.println("1. Add a Book");
            out.println("2. Add a Magazine");
            out.println("3. Add a DiscMag");
            out.println("4. Add a Ticket");
            out.println("99. Exit");
            out.print("Enter choice: ");
            String c = input.nextLine().trim();
            switch (c) {
                case "1" -> addItem(new Book());
                case "2" -> addItem(new Magazine());
                case "3" -> addItem(new DiscMag());
                case "4" -> {
                    Ticket t = promptTicket();
                    saleableItems.add(t);
                    out.println("Added: " + t);
                }
                case "99" -> back = true;
                default -> out.println("Invalid choice (valid options are 1 to 4 and 99 to exit)");
            }
        }
    }

    public void addItem(SaleableItem item) {
        if (item instanceof Editable editable) {
            editable.initialize();
            saleableItems.add(item);
            out.println("Added: " + item);
        } else if (item != null) {
            saleableItems.add(item);
            out.println("Added: " + item);
        } else {
            out.println("No item to add.");
        }
    }

    // small utilities
    private void printIndexedList(List<SaleableItem> list) {
        for (int i = 0; i < list.size(); i++) {
            out.printf("%d. %s%n%n", (i + 1), list.get(i));
        }
    }

    private int parseIndex(String s, int size) {
        try {
            int idx = Integer.parseInt(s) - 1;
            if (idx >= 0 && idx < size) return idx;
        } catch (NumberFormatException ignored) {}
        return -1;
    }

    private Ticket promptTicket() {
        out.print("Enter ticket id (int): ");
        int id = Integer.parseInt(input.nextLine().trim());
        out.print("Enter description: ");
        String desc = input.nextLine().trim();
        out.print("Enter price: ");
        double price = Double.parseDouble(input.nextLine().trim());
        return new Ticket(id, desc, price);
    }
}
