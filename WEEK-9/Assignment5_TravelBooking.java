import java.util.Scanner;

abstract class Travel {
    double distance;
    static final double BOOKING_FEE = 50;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }
}

public class Assignment5_TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Travel[] bookings = new Travel[n];
        String[] modes = new String[n];

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            double distance = sc.nextDouble();

            if (modes[i].equals("BUS"))
                bookings[i] = new Bus(distance);
            else if (modes[i].equals("TRAIN"))
                bookings[i] = new Train(distance);
            else if (modes[i].equals("FLIGHT"))
                bookings[i] = new Flight(distance);
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f%n",
                    modes[i], bookings[i].calculateTotal());
        }

        sc.close();
    }
}
