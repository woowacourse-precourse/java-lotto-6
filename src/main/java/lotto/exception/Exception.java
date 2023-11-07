package lotto.exception;


public class Exception {

    public static void runException(String message) {
        try {
            throw new InvalidInputException("[Error] " + message);
        } catch (InvalidInputException ignore) {
        }
    }

}
