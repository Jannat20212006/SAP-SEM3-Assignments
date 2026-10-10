import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double calculateCharge();

    double calculateTotal() {
        double insurance = 0;

        if (this instanceof Insurable)
            insurance = ((Insurable) this).calculateInsurance();

        return calculateCharge() + insurance;
    }

    double getInsurance() {
        if (this instanceof Insurable)
            return ((Insurable) this).calculateInsurance();

        return 0;
    }

    abstract String getType();
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return value * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return value * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class Assignment2_ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            if (type.equals("STANDARD"))
                parcels[i] = new Standard(weight, value);
            else if (type.equals("EXPRESS"))
                parcels[i] = new Express(weight, value);
            else if (type.equals("FRAGILE"))
                parcels[i] = new Fragile(weight, value);
        }

        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = p.getInsurance();
            double total = p.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                p.getType(), charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
