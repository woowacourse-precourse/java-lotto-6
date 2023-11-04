package lotto.view;

import static java.text.MessageFormat.format;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";

    public void printErrorMessage(String errorMessage) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, errorMessage));
    }
}
