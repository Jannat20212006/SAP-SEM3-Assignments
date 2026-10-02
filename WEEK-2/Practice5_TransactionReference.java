import java.util.Scanner;

public class Practice5_TransactionReference {

    static String normalizeReference(String raw) {
        raw = raw.trim();

        if (raw.length() != 14) {
            return null;
        }

        String bankCode = raw.substring(0, 3).toUpperCase();
        String date = raw.substring(3, 9);
        String sequence = raw.substring(9, 14);

        return bankCode + date + sequence;
    }

    static String validateAndFormat(String reference) {

        if (reference == null || reference.length() != 14) {
            return "Invalid Reference";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid Reference";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid Reference";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(date.substring(0, 2))
              .append("/")
              .append(date.substring(2, 4))
              .append("/")
              .append(date.substring(4, 6))
              .append(" | SEQ: ")
              .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));

        sc.close();
    }
}
