
import java.util.Scanner;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double getBill();
}

class HOME extends Connection {
    HOME(double units) {
        super(units);
    }

    double getBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 500 + (units - 100) * 7;
    }
}

class SHOP extends Connection {
    SHOP(double units) {
        super(units);
    }

    double getBill() {
        return units * 8 + 100;
    }
}

class FACTORY extends Connection {
    FACTORY(double units) {
        super(units);
    }

    double getBill() {
        return Math.max(units * 6, 1000);
    }
}

public class PracticeProblem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        Connection[] list = new Connection[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            if (type.equals("HOME")) {
                list[i] = new HOME(units);
            } else if (type.equals("SHOP")) {
                list[i] = new SHOP(units);
            } else if (type.equals("FACTORY")) {
                list[i] = new FACTORY(units);
            }
        }

        for (Connection c : list) {
            double bill = c.getBill();
            System.out.printf("%s: %.2f%n",
                    c.getClass().getSimpleName(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

