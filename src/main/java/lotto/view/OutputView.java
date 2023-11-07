package lotto.view;

import lotto.message.ConsoleMessage;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.println(ConsoleMessage.ERROR_STRING.getMessage() + message);
    }
}
