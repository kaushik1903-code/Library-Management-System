import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {

    public static double calculateFine(
            Member member,
            LocalDate dueDate,
            LocalDate returnDate) {

        if (!returnDate.isAfter(dueDate)) {
            return 0;
        }

        long overdueDays = ChronoUnit.DAYS.between(
                dueDate, returnDate);

        double dailyFine;

        if (member instanceof Student) {
            dailyFine = 5.0;
        } else if (member instanceof Faculty) {
            dailyFine = 2.0;
        } else {
            dailyFine = 0.0;
        }

        return overdueDays * dailyFine;
    }
}