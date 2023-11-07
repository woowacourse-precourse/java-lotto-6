package lotto.util;

import java.util.Objects;
import lotto.constants.PrintMessages;
import lotto.domain.Lotto;

public class ConsolePrinter {
    private static void validateNull(Object target) {
        Objects.requireNonNull(target);
    }

    public static void showMessage(PrintMessages message) {
        validateNull(message);

        System.out.print(message.getMessage());
    }

    public static void showMessageWithNumber(PrintMessages message, Integer number) {
        validateNull(message);
        validateNull(number);

        String showMessage = String.format(message.getMessage(), number);
        System.out.print(showMessage);
    }

    public static void showLottoNumbers(Lotto lotto) {
        validateNull(lotto);

        PrintMessages messageTemplate = PrintMessages.LOTTO_NUMBERS;
        String showMessage = messageTemplate.getMessageWithLotto(lotto);
        System.out.print(showMessage);
    }

    public static void showTotalReturn(Double totalReturn) {
        validateNull(totalReturn);

        PrintMessages messageTemplate = PrintMessages.TOTAL_RETURN;
        String showMessage = messageTemplate.getMessageWithTotalReturn(totalReturn);
        System.out.print(showMessage);
    }
}
