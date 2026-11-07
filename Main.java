import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = Library.loadData();

        int choice = -1;

        do {
            System.out.println("\n================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. Register Student");
            System.out.println("3. Register Faculty");
            System.out.println("4. Search Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Display Borrowing History");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");

String menuInput = sc.nextLine();

try {
    choice = Integer.parseInt(menuInput);
} catch (NumberFormatException e) {
    System.out.println("Invalid input! Please enter a number.");
    continue;
}

            switch (choice) {

                case 1: {
    System.out.print("Enter ISBN: ");
    String isbn = sc.nextLine().trim();

    System.out.print("Enter Book Title: ");
    String title = sc.nextLine().trim();

    System.out.print("Enter Author: ");
    String author = sc.nextLine().trim();

    if (isbn.isEmpty() || title.isEmpty() || author.isEmpty()) {
        System.out.println("All book details are required!");
        break;
    }

    Book book = new Book(isbn, title, author);
    library.addBook(book);
    break;
}
               case 2: {
    System.out.print("Enter Student ID: ");
    String studentId = sc.nextLine().trim();

    System.out.print("Enter Student Name: ");
    String studentName = sc.nextLine().trim();

    if (studentId.isEmpty() || studentName.isEmpty()) {
        System.out.println("Student details cannot be empty!");
        break;
    }

    Student student = new Student(studentId, studentName);
    library.registerMember(student);
    break;
}

               case 3: {
    System.out.print("Enter Faculty ID: ");
    String facultyId = sc.nextLine().trim();

    System.out.print("Enter Faculty Name: ");
    String facultyName = sc.nextLine().trim();

    if (facultyId.isEmpty() || facultyName.isEmpty()) {
        System.out.println("Faculty details cannot be empty!");
        break;
    }

    Faculty faculty = new Faculty(facultyId, facultyName);
    library.registerMember(faculty);
    break;
}

                case 4:
                    System.out.print("Enter ISBN to search: ");
                    String searchISBN = sc.nextLine();

                    library.searchBook(searchISBN);
                    break;

                case 5:
                    library.displayAllBooks();
                    break;

                case 6:
                    System.out.print("Enter Member ID: ");
                    String issueMember = sc.nextLine();

                    System.out.print("Enter Book ISBN: ");
                    String issueISBN = sc.nextLine();

                    library.issueBook(issueMember, issueISBN);
                    break;
case 7:
    System.out.print("Enter Member ID: ");
    String returnMember = sc.nextLine();

    System.out.print("Enter Book ISBN: ");
    String returnISBN = sc.nextLine();

    System.out.print("Enter Return Date (YYYY-MM-DD): ");
    String dateInput = sc.nextLine();

    try {
        java.time.LocalDate testDate =
                java.time.LocalDate.parse(dateInput);

        library.returnBook(returnMember, returnISBN, testDate);

    } catch (java.time.format.DateTimeParseException e) {
        System.out.println("Invalid date format!");
        System.out.println("Please use YYYY-MM-DD.");
    }
    break;

  case 8:
    library.displayHistory();
    break;

case 9:
    System.out.println(
        "Thank you for using Library Management System!");
    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        library.saveData();
    } while (choice != 9);
    library.saveData();
        sc.close();
    }
}