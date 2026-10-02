import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {

    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class Assignment5_StreamingRenewal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        SubscriptionPlan[] plans =
                new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                    LocalDate.parse(date);

            if (type.equals("BASIC")) {

                plans[i] =
                        new BasicPlan(name, startDate);
            }
            else if (type.equals("STANDARD")) {

                plans[i] =
                        new StandardPlan(name, startDate);
            }
            else {

                plans[i] =
                        new PremiumPlan(name, startDate);
            }
        }

        for (SubscriptionPlan plan : plans) {

            LocalDate renewalDate =
                    plan.calculateRenewalDate();

            System.out.println(
                    plan.name + ": " + renewalDate);
        }

        sc.close();
    }
}
