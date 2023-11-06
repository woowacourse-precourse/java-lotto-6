package lotto.view;

import lotto.view.constants.ViewMessage;

public class OutputView {
    public static void printMessage(final String message) {
        System.out.println(message);
    }

    public static void printMessage(final ViewMessage viewMessage) {
        System.out.println(viewMessage.getMessage());
    }
}
