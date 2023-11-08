package lotto.validator;

public class Validator {
    private static final String REGEX = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    protected static void isLottoNumberRange(String number) {
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}
