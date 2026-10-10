import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    double getTotalFee() {
        double fee = calculateFee();

        if (this instanceof BusUser)
            fee += ((BusUser) this).getTransportFee();

        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000;
    }

    public double getTransportFee() {
        return 12000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000;
    }

    public double getTransportFee() {
        return 12000;
    }
}

public class Assignment3_CollegeFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR"))
                students[i] = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                students[i] = new Hosteller(name);
            else if (type.equals("SCHOLAR"))
                students[i] = new Scholar(name);
        }

        for (Student s : students) {
            double fee = s.getTotalFee();
            System.out.printf("%s: %.2f%n", s.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
