package lotto.util;

public class Validator {

    public static void validatePositiveInteger(Integer number) {
        if (number < 1) {
            throw new IllegalStateException();
        }
    }
}
