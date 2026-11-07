import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.io.*;
import java.nio.file.*;

public class Library implements Serializable {

    private HashMap<String, Book> books = new HashMap<>();

    private HashMap<String, Member> members = new HashMap<>();

    private HashMap<String, List<String>> borrowedBooks = new HashMap<>();

    private HashMap<String, LocalDate> dueDates = new HashMap<>();

    private ArrayList<BorrowRecord> history = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {

        if (books.containsKey(book.getISBN())) {
            System.out.println("Book already exists!");
            return;
        }

        books.put(book.getISBN(), book);
        System.out.println("Book added successfully!");
    }

    // Register a member
public void registerMember(Member member) {

    String memberId = member.getMemberId();

    if (members.containsKey(memberId)) {
        System.out.println("Member ID already exists!");
        return;
    }

    members.put(memberId, member);

    borrowedBooks.put(memberId, new ArrayList<>());

    System.out.println("Member registered successfully!");
}

    // Search for a book
    public void searchBook(String isbn) {

        Book book = books.get(isbn);

        if (book == null) {
            System.out.println("Book not found!");
        } else {
            book.displayBook();
        }
    }

    // Issue a book
    public void issueBook(String memberId, String isbn) {

        Member member = members.get(memberId);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            System.out.println("Invalid member or book!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available!");
            return;
        }

        List<String> issued = borrowedBooks.get(memberId);

        if (issued.size() >= member.getBorrowingLimit()) {
            System.out.println("Borrowing limit reached!");
            return;
        }

        book.setAvailable(false);

        issued.add(isbn);

        LocalDate dueDate = LocalDate.now()
                .plusDays(member.getBorrowingDays());

        dueDates.put(memberId + "_" + isbn, dueDate);

        BorrowRecord record = new BorrowRecord( memberId, isbn, LocalDate.now(), dueDate);
        history.add(record);

        System.out.println("Book issued successfully!");
        System.out.println("Due Date: " + dueDate);
    }
// Return a book with a specified return date
public void returnBook(String memberId, String isbn,
                       LocalDate returnDate) {

    Member member = members.get(memberId);
    Book book = books.get(isbn);

    if (member == null || book == null) {
        System.out.println("Invalid member or book!");
        return;
    }

    List<String> issued = borrowedBooks.get(memberId);

    if (!issued.contains(isbn)) {
        System.out.println("This book was not borrowed by this member!");
        return;
    }

    LocalDate dueDate = dueDates.get(memberId + "_" + isbn);

    if (returnDate.isBefore(dueDate)) {
        System.out.println("Invalid return date!");
        return;
    }

    double fine = FineCalculator.calculateFine(
            member, dueDate, returnDate);

    // Update the borrowing history
for (int i = history.size() - 1; i >= 0; i--) {

    BorrowRecord record = history.get(i);

    if (record.matches(memberId, isbn) && record.isActive()) {

        record.completeReturn(returnDate, fine);
        break;
    }
}

    issued.remove(isbn);
    dueDates.remove(memberId + "_" + isbn);

    book.setAvailable(true);

    System.out.println("Book returned successfully!");
    System.out.println("Due Date: " + dueDate);
    System.out.println("Return Date: " + returnDate);
    System.out.println("Fine: Rs. " + fine);
}

// Normal return using today's date
public void returnBook(String memberId, String isbn) {
    returnBook(memberId, isbn, LocalDate.now());
}
 // Display all books
    public void displayAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book book : books.values()) {
            System.out.println("--------------------");
            book.displayBook();
        }
    }
// Display borrowing history
public void displayHistory() {

    if (history.isEmpty()) {
        System.out.println("No borrowing history available!");
        return;
    }

    System.out.println("\n===== BORROWING HISTORY =====");

    for (BorrowRecord record : history) {
        record.displayRecord();
    }
}
// Save library data permanently
public void saveData() {

    try {
        Files.createDirectories(Paths.get("data"));

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("data/library.dat"));

        out.writeObject(this);
        out.close();

        System.out.println("Library data saved!");

    } catch (IOException e) {
        System.out.println("Error saving library data!");
        e.printStackTrace();
    }
}

// Load previously saved library data
public static Library loadData() {

    try {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("data/library.dat"));

        Library library = (Library) in.readObject();
        in.close();

        System.out.println("Previous library data loaded!");
        return library;

    } catch (FileNotFoundException e) {
        System.out.println("Starting a new library system!");
        return new Library();

    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error loading library data!");
        e.printStackTrace();
        return new Library();
    }
}
}