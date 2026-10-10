
import java.util.Scanner;

abstract class Booking {
    static final double FEE = 50.0;
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double getFare();

    double getTotal() {
        return getFare() + FEE;
    }
}

class BUS extends Booking {
    BUS(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 2;
    }
}

class TRAIN extends Booking {
    TRAIN(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 1.5;
    }
}

class FLIGHT extends Booking {
    FLIGHT(double distance) {
        super(distance);
    }

    double getFare() {
        return 2500 + distance * 4;
    }
}

public class PracticeProblem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {
                bookings[i] = new BUS(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TRAIN(distance);
            } else if (mode.equals("FLIGHT")) {
                bookings[i] = new FLIGHT(distance);
            }
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n",
                    b.getClass().getSimpleName(), b.getTotal());
        }

        sc.close();
    }
}

