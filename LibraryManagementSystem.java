import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String isbn;
    private String title;
    private String author;

    // Constructor
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("ISBN: " + isbn + ", Title: " + title + ", Author: " + author);
    }
}

// Main class
public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    // Add a book
    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        books.add(new Book(isbn, title, author));
        System.out.println("Book added successfully!");
    }

    // View all books
    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
        } else {
            System.out.println("\nList of Books:");
            for (Book book : books) {
                book.displayBook();
            }
        }
    }

    // Search book by title
    private static void searchBook() {
        System.out.print("Enter Title to Search: ");
        String title = scanner.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(title) || book.getIsbn().contains(title)) {
                book.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Update book
    private static void updateBook() {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.print("Enter new Title: ");
                String newTitle = scanner.nextLine();
                System.out.print("Enter new Author: ");
                String newAuthor = scanner.nextLine();
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("Book updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Delete book
    private static void deleteBook() {
        System.out.print("Enter ISBN of the book to delete: ");
        String isbn = scanner.nextLine();
        boolean found = false;

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }
}
