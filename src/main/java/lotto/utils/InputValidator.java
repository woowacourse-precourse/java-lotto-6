package lotto.utils;

public class InputValidator {
    public static void validateNumberInRange(int number, String code) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(code + Message.NUMBER_NOT_INRANGE.getMessage());
        }
    }
}
