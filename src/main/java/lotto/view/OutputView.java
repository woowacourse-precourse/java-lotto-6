package lotto.view;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public static void errorMessage(IllegalArgumentException e) {
        System.out.printf(ERROR_MESSAGE_FORMAT+NEW_LINE,e.getMessage());
    }
}
