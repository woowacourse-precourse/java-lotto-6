package lotto.view;

import lotto.message.MessageProvider;

public class OutputView {
    private OutputView() {
    }

    public static void printMessage(MessageProvider message) {
        System.out.println(message.getMessage());
    }
}
