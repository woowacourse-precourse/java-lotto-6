package lotto.view.output;

import lotto.view.constants.PrintMessage;

public sealed class OutputWriter permits PurchaseWriter, FinalResultWriter {

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
