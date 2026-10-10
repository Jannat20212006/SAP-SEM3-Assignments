import java.util.Scanner;

interface SaverMode {
    double reduceUnits(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }

    String getType() {
        return "AC";
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }

    String getType() {
        return "WASHER";
    }
}

public class Assignment5_ApplianceEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Appliance[] appliances = new Appliance[n];
        boolean[] saver = new boolean[n];
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver[i] = true;
            }

            if (type.equals("FRIDGE"))
                appliances[i] = new Fridge(hours);
            else if (type.equals("AC"))
                appliances[i] = new AC(hours);
            else if (type.equals("TV"))
                appliances[i] = new TV(hours);
            else if (type.equals("WASHER"))
                appliances[i] = new Washer(hours);
        }

        for (int i = 0; i < n; i++) {
            Appliance a = appliances[i];

            if (saver[i] && !(a instanceof SaverMode)) {
                System.out.println(a.getType() +
                        ": saver mode not supported");
                continue;
            }

            double units = a.calculateUnits();

            if (saver[i])
                units = ((SaverMode) a).reduceUnits(units);

            double cost = a.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                a.getType(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
