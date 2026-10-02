import java.util.Scanner;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();

    abstract String getType();
}

class Bike extends Vehicle {

    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10;
    }

    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {

    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        if (hours <= 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }

    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {

    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    String getType() {
        return "TRUCK";
    }
}

public class Assignment2_CampusParking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } 
            else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } 
            else if (type.equals("TRUCK")) {
                vehicles[i] = new Truck(hours);
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n",
                    vehicle.getType(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
