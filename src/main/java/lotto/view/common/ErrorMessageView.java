package lotto.view.common;

public class ErrorMessageView {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printError(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }
}
