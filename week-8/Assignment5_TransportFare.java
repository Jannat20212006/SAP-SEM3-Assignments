import java.util.Scanner;

abstract class Transport {

    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    String getType() {
        return "BUS";
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {

        double baseFare =
                1.50 + (0.20 * distance);

        return baseFare * peakHourFactor;
    }

    String getType() {
        return "METRO";
    }
}

public class Assignment5_TransportFare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Transport[] transports =
                new Transport[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance =
                    sc.nextDouble();

            if (type.equals("BUS")) {

                transports[i] =
                        new Bus(distance);
            }
            else if (type.equals("TRAIN")) {

                transports[i] =
                        new Train(distance);
            }
            else {

                double peakHourFactor =
                        sc.nextDouble();

                transports[i] =
                        new Metro(
                                distance,
                                peakHourFactor);
            }
        }

        double total = 0;

        for (Transport transport : transports) {

            double fare =
                    transport.calculateFare();

            System.out.printf(
                    "%s: %.2f%n",
                    transport.getType(),
                    fare);

            total += fare;
        }

        System.out.printf(
                "Total: %.2f%n", total);

        sc.close();
    }
}
