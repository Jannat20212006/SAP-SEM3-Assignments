import java.util.Scanner;

interface NightService {
    double applyNightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getType();

    double calculateFare() {
        return Math.max(km * getRate(), 100);
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double applyNightFare(double fare) {
        return fare * 1.2;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double applyNightFare(double fare) {
        return fare * 1.2;
    }

    String getType() {
        return "SUV";
    }
}

public class Assignment4_CityCab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        boolean[] night = new boolean[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            night[i] = time.equals("NIGHT");

            if (type.equals("MINI"))
                cabs[i] = new Mini(km);
            else if (type.equals("SEDAN"))
                cabs[i] = new Sedan(km);
            else if (type.equals("SUV"))
                cabs[i] = new SUV(km);
        }

        for (int i = 0; i < n; i++) {
            Cab c = cabs[i];

            if (night[i] && !(c instanceof NightService)) {
                System.out.println(c.getType() +
                        ": night service not available");
                continue;
            }

            double fare = c.calculateFare();

            if (night[i])
                fare = ((NightService) c).applyNightFare(fare);

            System.out.printf("%s: %.2f%n", c.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
