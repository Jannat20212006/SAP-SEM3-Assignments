import java.util.Scanner;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    abstract String getType();
}

class Student extends Customer {

    Student(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount - (amount * 0.10);
    }

    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {

    Staff(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount - (amount * 0.05);
    }

    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {

    Guest(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class Assignment1_CanteenBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) {
                customers[i] = new Student(amount);
            }
            else if (type.equals("STAFF")) {
                customers[i] = new Staff(amount);
            }
            else {
                customers[i] = new Guest(amount);
            }
        }

        double total = 0;

        for (Customer customer : customers) {

            double finalAmount =
                    customer.calculateFinalAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}