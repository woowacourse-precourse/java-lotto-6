package lotto;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public void printErrorMessage(String message) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, message));
    }
}
