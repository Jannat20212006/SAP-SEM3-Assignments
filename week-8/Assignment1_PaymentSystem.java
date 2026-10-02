import java.util.Scanner;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
    
    abstract String getType();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + (amount * 0.02);
    }

    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {

    WalletPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + (amount * 0.01);
    }

    String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {

    BankTransferPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount;
    }

    String getType() {
        return "BANKTRANSFER";
    }
}

public class Assignment1_PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } 
            else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } 
            else {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double total = 0;

        for (Payment payment : payments) {

            double adjustedAmount = payment.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), adjustedAmount);

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}