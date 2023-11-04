package lotto.validator;

public class AmountValidator implements Validator {

    private final static String INTEGER_PATTERN = "^\\d+$";
    private final static int DIVISOR_FOR_THOUSAND = 1000;

    @Override
    public void validate(String input) {
        throwIfNotInteger(input);
        throwIfNotDividedBy1000(input);
    }

    private void throwIfNotDividedBy1000(String input) {
        int inputInteger = parseInt(input);
        if (inputInteger % DIVISOR_FOR_THOUSAND != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void throwIfNotInteger(String input) {
        if (!input.matches(INTEGER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
