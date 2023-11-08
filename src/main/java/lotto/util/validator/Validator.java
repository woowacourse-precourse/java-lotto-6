package lotto.util.validator;

public class Validator {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static void validateNumeric(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}
