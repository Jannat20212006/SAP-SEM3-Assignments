
import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double getArea();
    abstract String getShape();
}

class CIRCLE extends Plot {
    double radius;

    CIRCLE(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class RECTANGLE extends Plot {
    double length, width;

    RECTANGLE(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double getArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class TRIANGLE extends Plot {
    double base, height;

    TRIANGLE(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double getArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class PracticeProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            if (type.equals("CIRCLE")) {
                plots[i] = new CIRCLE(owner, sc.nextDouble());
            } else if (type.equals("RECTANGLE")) {
                plots[i] = new RECTANGLE(owner,
                        sc.nextDouble(), sc.nextDouble());
            } else if (type.equals("TRIANGLE")) {
                plots[i] = new TRIANGLE(owner,
                        sc.nextDouble(), sc.nextDouble());
            }
        }

        for (Plot p : plots) {
            double area = p.getArea();
            System.out.printf("%s (%s): %.2f%n",
                    p.owner, p.getShape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}

