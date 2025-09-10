package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String title, updatedTitle, author;
        int isbn, pages, userChoice;
        boolean flag = true; // to loop until false

        BookStore bookStore = new BookStore();
        Book book;

        Scanner input = new Scanner(System.in);

        // Loop block:
        while (flag) {

            bookStore.showMenu(); // display the menu

            System.out.println("Enter your choice please: ");

            if (input.hasNextInt()) {
                userChoice = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                input.nextLine(); // clear the wrong input
                continue;
            }
            switch (userChoice)
            {
                    case 1:
                        System.out.print("Enter title: ");
                        title = input.nextLine();
                        System.out.print("Enter author: ");
                        author = input.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = input.nextInt();
                        System.out.print("Enter pages: ");
                        pages = input.nextInt();
                        book = new Book(title, author, isbn, pages); // initializing new instance of the book using constructor.
                        bookStore.addBook(book);
                        System.out.println("Book added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter title of the book to edit: ");
                        title = input.nextLine();
                        if(bookStore.findBook(title)) { // verify if the book is present or not pre-hand.
                            System.out.print("Enter new title: ");
                            updatedTitle = input.nextLine();
                            System.out.print("Enter new author name: ");
                            author = input.nextLine();
                            System.out.print("Enter new isbn: ");
                            isbn = input.nextInt();
                            System.out.print("Enter updated number of pages: ");
                            pages = input.nextInt();
                            bookStore.editBook(title, updatedTitle, author, isbn, pages);
                        } else {
                            System.out.println("Book not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter title to delete: ");
                        title = input.nextLine();
                        bookStore.deleteBook(title);
                        break;
                    case 4:
                        bookStore.listBooks();
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        flag = false; // terminates the loop
                        break;
                    default:
                        System.out.println("Invalid choice. Try again");
            }
        }
    }
}


