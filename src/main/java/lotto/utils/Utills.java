package lotto.utils;

public final class Utills {

    public static int stringToInteger(String input) {
        Validation.validateStringToInteger(input);
        return Integer.parseInt(input);
    }
}
