package lotto.validator;

public class Validator {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private Validator() {

    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
