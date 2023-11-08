package lotto;

public class ErrorValidate {
    private static final int MINIMUM_PUCHASE_MONEY = 1000;
    private static final int MINIMUM_RANDOM_NUMBER = 1;
    private static final int MAXIMUM_RANDOM_NUMBER= 46;

    public static void inputNumberLimit(int number) {
        if (number < MINIMUM_RANDOM_NUMBER || number > MAXIMUM_RANDOM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void isNumberFormat(String input) {
        final String REGEX = "[0-9]+";
        if (!input.matches(REGEX)) {
            throw new NumberFormatException();
        }
    }

    public static void isMinimumInputMoney(int number) {
        if (number < MINIMUM_PUCHASE_MONEY) {
            throw new IllegalArgumentException();
        }
    }
}
