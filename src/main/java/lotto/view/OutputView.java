package lotto.view;

import lotto.view.constants.ConstantMessage;

public class OutputView {
    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
