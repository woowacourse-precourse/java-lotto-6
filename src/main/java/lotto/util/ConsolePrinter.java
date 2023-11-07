package lotto.util;

import java.util.Objects;
import lotto.constants.PrintMessages;

public class ConsolePrinter {
    private static void nullCheck(Object target) {
        Objects.requireNonNull(target);
    }

    public static void showMessage(PrintMessages message) {
        nullCheck(message);

        System.out.print(message.getMessage());
    }

    }
}
