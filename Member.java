import java.io.Serializable;
public abstract class Member implements Serializable {

    protected String memberId;
    protected String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Abstract methods
    public abstract int getBorrowingLimit();

    public abstract int getBorrowingDays();

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void displayMember() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Borrowing Limit: " + getBorrowingLimit());
        System.out.println("Borrowing Days: " + getBorrowingDays());
    }
}