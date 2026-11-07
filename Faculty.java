public class Faculty extends Member {

    public Faculty(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getBorrowingLimit() {
        return 5;
    }

    @Override
    public int getBorrowingDays() {
        return 30;
    }
}