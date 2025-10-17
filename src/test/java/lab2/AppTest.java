package lab2;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    private String runAppWithScript(String script, boolean seed) {
        ByteArrayInputStream in = new ByteArrayInputStream((script + System.lineSeparator()).getBytes());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buf);

        App app = new App(in, out); // uses the (InputStream, PrintStream) constructor
        if (seed) app.populate();   // seed items for list/sell/delete tests

        app.run();
        return buf.toString();
    }

    @Test
    void deleteItem_flow_removesFirstItem() {
        // 3 = Delete → "1" = delete first item → 99 quit
        String script = String.join(System.lineSeparator(), "3", "1", "99");
        String output = runAppWithScript(script, true);

        assertTrue(output.contains("Delete an item"),"Should enter delete screen\n---OUTPUT---\n" + output);
        assertTrue(output.contains("Deleted: "),"Should confirm deletion\n---OUTPUT---\n" + output);
    }

    @Test
    void addTicket_flow_addsAndListsTicket() {
        // Add → Ticket → enter id, desc, price → back → List Tickets → exit list → quit
        String script = String.join(System.lineSeparator(),
                "1",        // Add Items
                "4",        // Add a Ticket
                "12345",    // promptTicket(): id (int)
                "JUnit Test Ticket", // description
                "7.50",     // price
                "99",       // exit add menu
                "5", "5",   // List → Tickets
                "99",       // exit list menu
                "99"        // Quit
        );

        String output = runAppWithScript(script, false);
        assertTrue(output.contains("JUnit Test Ticket"),"Ticket description should appear\n---OUTPUT---\n" + output);
    }

    @Test
    void listAfterPopulate_showsAllSeededItems() {
        // 5 = List items → 1 = All → 99 exit listing → 99 quit
        String script = String.join(System.lineSeparator(), "5", "1", "99", "99");
        String output = runAppWithScript(script, true);

        // Check the titles you seeded in App.populate()
        assertTrue(output.contains("Scientific Breakthroughs"),"---OUTPUT---\n" + output);
        assertTrue(output.contains("Sample Magazine"),"---OUTPUT---\n" + output);
        assertTrue(output.contains("Sample DiscMag"),"---OUTPUT---\n" + output);
        assertTrue(output.contains("Sample Event Ticket - Live Concert"),"---OUTPUT---\n" + output);
    }
}
