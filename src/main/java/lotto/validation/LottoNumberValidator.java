package lotto.validation;

public class LottoNumberValidator implements InputValidator {
    private final static int END_INCLUSIVE = 45;

    @Override
    public void validate(String input) {
        if (!isNumeric(input)) {
            Error error = Error.INTEGER_ERROR;
            throw new IllegalArgumentException(error.message());
        }

        int number = Integer.parseInt(input);
        if (!isPositive(number)) {
            Error error = Error.RANGE_ERROR;
            throw new IllegalArgumentException(error.message());
        }
        if (!isSmallerThan(number, END_INCLUSIVE + 1)) {
            Error error = Error.RANGE_ERROR;
            throw new IllegalArgumentException(error.message());
        }
    }

    public boolean isSmallerThan(int input, int n) {
        return input < n;
    }
}
