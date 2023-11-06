package lotto.view;

public class Output {

    private final static String ERROR_MESSAGE = "[ERROR] ";

    private Output() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String format, Object... objects) {

    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + errorMessage);
    }

}
