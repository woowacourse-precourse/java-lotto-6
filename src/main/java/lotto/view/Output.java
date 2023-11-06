package lotto.view;

public class Output {

    private final static String NEW_LINE = "%n";
    private final static String ERROR_MESSAGE = "[ERROR] ";

    private Output() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String format, Object... objects) {
        System.out.printf((format) + NEW_LINE, objects);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + errorMessage);
    }

}
