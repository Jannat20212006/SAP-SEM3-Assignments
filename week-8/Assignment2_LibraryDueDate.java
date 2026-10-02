import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {

    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    abstract String getType();

    void printDueDate(LocalDate currentDate) {

        LocalDate dueDate =
                currentDate.plusDays(getBorrowingDays());

        System.out.println(title + ": " + dueDate);
    }
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 14;
    }

    String getType() {
        return "BOOK";
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 7;
    }

    String getType() {
        return "DVD";
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 3;
    }

    String getType() {
        return "MAGAZINE";
    }
}

public class Assignment2_LibraryDueDate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int firstSpace = line.indexOf(' ');

            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1);

            title = title.replace("\"", "");

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            }
            else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            }
            else {
                items[i] = new Magazine(title);
            }
        }

        LocalDate currentDate =
                LocalDate.of(2023, 10, 26);

        for (LibraryItem item : items) {
            item.printDueDate(currentDate);
        }

        sc.close();
    }
}
