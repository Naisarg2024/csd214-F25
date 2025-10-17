package lab2;

import com.github.javafaker.Faker;
import lab2.pojos.*;
import java.time.LocalDate;
import java.util.UUID;


public class Util {
    private static Faker faker = new Faker();
    private static com.github.javafaker.Book fakeBook = faker.book();
    private static com.github.javafaker.Number number = faker.number();
    private static com.github.javafaker.Code code=faker.code();


    public static Book getFakeBook(){
        String title= fakeBook.title();
        double price= number.randomDouble(2, 10, 100);
        int copies= number.numberBetween(1, 20);
        String author= fakeBook.author();
        String isbnStr= code.isbn10().replaceAll("[^0-9]", "");
        long isbn = 0L;
        try {
            isbn = Long.parseLong(isbnStr);
        } catch (NumberFormatException e) {
            // fallback if parsing fails
            isbn = Math.abs(UUID.randomUUID().getMostSignificantBits());
        }
        String description="Book: "+fakeBook.genre();
        return new Book(
                UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                title,
                price,
                copies,
                isbn,
                description,
                author
        );
    }
    public static Magazine getFakeMagazine(){
        String title=fakeBook.title();
        double price=number.randomDouble(2, 10, 100);
        int copies=number.numberBetween(1, 20);
        String author=fakeBook.author();
        String isbnStr = code.isbn10().replaceAll("[^0-9]", ""); // remove non-digits
        long isbn = 0L;
        try {
            isbn = Long.parseLong(isbnStr);
        } catch (NumberFormatException e) {
            // fallback if parsing fails
            isbn = Math.abs(UUID.randomUUID().getMostSignificantBits());
        }
        String description="Magazine: "+fakeBook.genre();
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        return new Magazine(id,
                title,
                price,
                copies,
                isbn,
                description,
                copies,
                LocalDate.now()
        );
    }
    public static DiscMag getFakeDiscMag(){
        Magazine dm = getFakeMagazine();
        var random = new java.util.Random();
        return new DiscMag(
                dm,
                random.nextBoolean()
        );
    }
    public static Ticket getFakeTicket(){
        var random = new java.util.Random();
        return new Ticket(
                "This is a ticket for cool event # "+random.nextInt(),
                Util.getFakeDoubleBetween(1, 100)
        );
    }

    public static int getFakeIntegerBetween(int min, int max) {
        return number.numberBetween(min, max);
    }

    public static double getFakeDoubleBetween(int min, int max) {
        return number.randomDouble(2, 10, 100);
    }
}
