package lotto.view;

import lotto.exception.ErrorMessage;
import lotto.view.constants.PrintMessage;

public class OutputView {
    public static void printMessage(final PrintMessage message) {
        println(message.getMessage());
    }

    public static void printError(final ErrorMessage message) {
        println(message.getMessage());
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
}
