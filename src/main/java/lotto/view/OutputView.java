package lotto.view;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_FORMAT + errorMessage);
    }
}
