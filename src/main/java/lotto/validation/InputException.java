package lotto.validation;

public class InputException {
    public static void blank(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Blank Input");
        }
    }

    public static void notNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] Not a Number");
        }
    }

    public static void underThousand(final String input) {
        if (Integer.parseInt(input) < 1000) {
            throw new IllegalArgumentException("[ERROR] Under Thousand");
        }
    }

    public static void notMultipleOfThousand(final String input) {
        if ((Integer.parseInt(input) % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] Not a Multiple of Thousand");
        }
    }
}
