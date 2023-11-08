package lotto.util;

public class ErrorHandler {
    private final static String ERROR_TAG = "[ERROR] ";
    private ErrorHandler(){

    }
    public static void printErrorMessage(String message) {
        System.out.println(ERROR_TAG + message);
    }
}
