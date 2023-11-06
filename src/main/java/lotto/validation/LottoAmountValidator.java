package lotto.validation;

public class LottoAmountValidator implements InputValidator {
    private final static int UNIT = 1000;

    public void validate(String input) {
        if (!isNumeric(input)) {
            Error error = Error.INTEGER_ERROR;
            throw new IllegalArgumentException(error.message());
        }

        int number = Integer.parseInt(input);
        if (!isPositive(number)) {
            Error error = Error.POSITIVE_ERROR;
            throw new IllegalArgumentException(error.message());
        }
        if (!isDivisibleBy1000(number)) {
            Error error = Error.DIVISIBLE_ERROR;
            throw new IllegalArgumentException(error.message());
        }
    }

    public boolean isDivisibleBy1000(int input) {
        return input % UNIT == 0;
    }
}
