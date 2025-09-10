package org.example;

import java.util.ArrayList;

public class BookStore {

    final private ArrayList<Book> books = new ArrayList<Book>();

    /**
     * Displays menu to the user, representing functionality of the program
     */
    public void showMenu() {
        System.out.println("----------------");
        System.out.println("1. Add Book");
        System.out.println("2. Edit Books");
        System.out.println("3. Delete Book");
        System.out.println("4. List Books");
        System.out.println("5. Exit Store");
        System.out.println("---------------");
    }

    /**
     * Add the book object to the ArrayList for future manipulations / traversal.
     *
     * @param book The book object containing all the info i.e title, author, isbn, pages
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Lets user edit information about the book object, i.e title, author, isbn, pages only when
     * reference of the book to be edited is already present in the ArrayList.
     *
     * @param oldTitle The title of the book through which we check in the book-list & allow further manipulations
     * @param newTitle String representing the new title of the book after edit
     * @param newAuthor String representing the new author-name of the book after edit
     * @param newIsbn Integer representing the new ISBN Code of the book after edit
     * @param newPages Integer representing the update no.of pages of the book after edit
     */
    public void editBook(String oldTitle, String newTitle, String newAuthor, int newIsbn, int newPages) {
        for (Book b : books) {
            if (b.getTitle().trim().equalsIgnoreCase(oldTitle)) { // ignoring the case
                // using setters in the Book class
                b.setTitle(newTitle);
                b.setAuthor(newAuthor);
                b.setIsbn(newIsbn);
                b.setPages(newPages);

                System.out.println("Book edited successfully!");
                return;
            }
        }
        System.out.println("No book found with the title: " + oldTitle);
    }

    /**
     * Check the book if its available in the list or not, useful when editing books, to just stop at the beginning instead
     * of asking every changes and then throwing the error.
     *
     * @param title the title of the book to search
     * @return boolean value indicating whether a particular book-title was found.
     */
    public boolean findBook (String title) {
        for (Book b : books) {
            if (b.getTitle().trim().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lets user remove a particular book if already present in the list.
     *
     * @param title used to match the requested book to be deleted from the list.
     */
    public void deleteBook(String title) {
        for (Book b : books) {
            if (b.getTitle().trim().equalsIgnoreCase(title)) { // ignoring the case
                books.remove(b);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    /**
     * Lists all the available books in the ArrayList in a formatted way.
     */
    public void listBooks() {
        if(books.isEmpty()) {
            System.out.println("No books found!");
        }
        System.out.printf("Available Books: %d\n", books.size());
        System.out.printf("%-25s %-20s %-10s %-10s%n", "Title", "Author", "ISBN Code", "Pages");
        System.out.println("------------------------------------------------------------------");

        for (Book book : books) {
            System.out.printf("%-25s %-20s %-10d %-10d%n", book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPages());
        }
    }
}


