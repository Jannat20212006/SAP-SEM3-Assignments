public class Problem4_ISBNValidator {

    static String normalizeCode(String raw) {

        raw = raw.trim();

        String publisher = raw.substring(0, 3).toUpperCase();
        String remaining = raw.substring(3);

        return publisher + remaining;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(code.substring(0, 3));
        result.append("] YEAR: ");
        result.append(code.substring(3, 7));
        result.append(" | CATALOG: ");
        result.append(code.substring(7));

        return result.toString();
    }

    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));
    }
}