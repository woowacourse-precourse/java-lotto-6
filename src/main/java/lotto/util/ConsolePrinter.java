package lotto.util;

import java.util.Objects;
import lotto.constants.PrintMessages;

public class ConsolePrinter {
    public static void showMessage(PrintMessages message) {
        Objects.requireNonNull(message, "message is null");

        System.out.println(message.getMessageWithoutNewLine());
    }
}
