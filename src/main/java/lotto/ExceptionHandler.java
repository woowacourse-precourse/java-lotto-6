package lotto;

public class ExceptionHandler {

    private static final String PREFIX = "[ERROR] ";
    public static final boolean EXCEPTION_OCCURED = false;
    public static final boolean NO_EXCEPTION = true;

    public static void handleException(String errorMsg) {
        System.out.println(PREFIX + errorMsg);
    }
}
