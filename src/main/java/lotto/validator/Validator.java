package lotto.validator;

public class Validator {

    public static void validateCondition(boolean condition, String message) {
        if (condition) {
            throw new IllegalArgumentException(message);
        }
    }

}
