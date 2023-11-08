package lotto.exception;

public class ExceptionHandler {

    public static void handleException(Exception e, String argument) {
        System.out.println("[ERROR] " + argument);
        if (e instanceof IllegalArgumentException) {
            throw new IllegalArgumentException();
        } else if (e instanceof IllegalStateException) {
            throw new IllegalStateException();
        }
    }
}
