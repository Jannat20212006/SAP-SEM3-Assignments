
import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double getFine();
}

class BOOK extends LibraryItem {
    BOOK(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MAGAZINE extends LibraryItem {
    MAGAZINE(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate * 1.0;
    }
}

public class PracticeProblem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            if (type.equals("BOOK")) {
                items[i] = new BOOK(title, days);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title, days);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new MAGAZINE(title, days);
            }
        }

        for (LibraryItem item : items) {
            double fine = item.getFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}

