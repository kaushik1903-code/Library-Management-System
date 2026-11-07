import java.io.Serializable;
import java.time.LocalDate;

public class BorrowRecord implements Serializable {

    private String memberId;
    private String isbn;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;

    public BorrowRecord(String memberId, String isbn,
                        LocalDate issueDate, LocalDate dueDate) {

        this.memberId = memberId;
        this.isbn = isbn;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null;
        this.fine = 0.0;
    }

    public void completeReturn(LocalDate returnDate, double fine) {
        this.returnDate = returnDate;
        this.fine = fine;
    }
    
    public boolean isActive() {
    return returnDate == null;
}

public boolean matches(String memberId, String isbn) {
    return this.memberId.equals(memberId)
            && this.isbn.equals(isbn);
}
 
    public void displayRecord() {
        System.out.println("----------------------------");
        System.out.println("Member ID: " + memberId);
        System.out.println("Book ISBN: " + isbn);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Return Date: " +
                (returnDate == null ? "Not Returned" : returnDate));
        System.out.println("Fine: Rs. " + fine);
    }
}