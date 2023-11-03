package lotto.view;

import lotto.view.constants.PrintMessage;

public final class OutputView{
    private OutputView() {
    }

    public static void print(final Object data) {
        System.out.print(data);
    }

    public static void println(final Object data) {
        System.out.println(data);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMessage(final PrintMessage message) {
        println(message.getMessage());
    }
}
