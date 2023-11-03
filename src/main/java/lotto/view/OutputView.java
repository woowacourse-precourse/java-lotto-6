package lotto.view;

import lotto.view.constant.ConstantMessage;

public class OutputView {
    public OutputView() {}

    public static void printConstantMessage(ConstantMessage message) {
        System.out.print(message);
    }

    public static void printNewLine() {
        System.out.println("");
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
