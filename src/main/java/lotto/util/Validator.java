package lotto.util;

public class Validator {

    public static int validateNumeric(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDivisibleBy(int money, int divisor) {
        if (money % divisor != 0) {
            throw new IllegalArgumentException();
        }
    }
}
