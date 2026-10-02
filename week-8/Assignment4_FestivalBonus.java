import java.util.Scanner;

abstract class Employee {

    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class Assignment4_FestivalBonus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME")) {

                employees[i] =
                        new FullTimeEmployee(name, salary);
            }
            else if (type.equals("PARTTIME")) {

                employees[i] =
                        new PartTimeEmployee(name, salary);
            }
            else {

                employees[i] =
                        new InternEmployee(name, salary);
            }
        }

        double totalBonus = 0;

        for (Employee employee : employees) {

            double bonus =
                    employee.calculateBonus();

            System.out.printf("%s: %.2f%n",
                    employee.name, bonus);

            totalBonus += bonus;
        }

        System.out.printf(
                "Total Bonus: %.2f%n",
                totalBonus);

        sc.close();
    }
}s
