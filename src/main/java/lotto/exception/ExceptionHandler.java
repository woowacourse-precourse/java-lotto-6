package lotto.exception;

public class ExceptionHandler {

    public static void handleException(Exception e, String argument) throws Exception {
        System.out.println("[ERROR] " + argument);
        throw e;
    }
}
