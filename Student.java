public class Student extends Member {

    public Student(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getBorrowingLimit() {
        return 3;
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}