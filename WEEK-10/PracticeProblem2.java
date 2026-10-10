
import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double getPay();
}

class FULLTIME extends Staff {
    double salary;

    FULLTIME(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double getPay() {
        return salary;
    }
}

class HOURLY extends Staff {
    double hours, rate;

    HOURLY(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double getPay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class INTERN extends Staff {
    double stipend;

    INTERN(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double getPay() {
        return stipend;
    }
}

public class PracticeProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {
                staff[i] = new FULLTIME(name, sc.nextDouble());
            } else if (type.equals("HOURLY")) {
                staff[i] = new HOURLY(name,
                        sc.nextDouble(), sc.nextDouble());
            } else if (type.equals("INTERN")) {
                staff[i] = new INTERN(name, sc.nextDouble());
            }
        }

        for (Staff s : staff) {
            double pay = s.getPay();
            System.out.printf("%s: %.2f%n", s.name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}

