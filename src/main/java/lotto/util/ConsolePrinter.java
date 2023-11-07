package lotto.util;

import java.util.Objects;
import lotto.constants.DomainMessages;
import lotto.constants.ErrorMessages;
import lotto.domain.Lotto;

public class ConsolePrinter {
    private static void validateNull(Object target) {
        Objects.requireNonNull(target);
    }

    public static void showMessage(DomainMessages message) {
        validateNull(message);

        System.out.print(message.getMessage());
    }

    public static void showMessageWithNumber(DomainMessages message, Integer number) {
        validateNull(message);
        validateNull(number);

        String showMessage = String.format(message.getMessage(), number);
        System.out.print(showMessage);
    }

    public static void showLottoNumbers(Lotto lotto) {
        validateNull(lotto);

        DomainMessages messageTemplate = DomainMessages.LOTTO_NUMBERS;
        String showMessage = messageTemplate.getMessageWithLotto(lotto);
        System.out.print(showMessage);
    }

    public static void showTotalReturn(Double totalReturn) {
        validateNull(totalReturn);

        DomainMessages messageTemplate = DomainMessages.TOTAL_RETURN;
        String showMessage = messageTemplate.getMessageWithTotalReturn(totalReturn);
        System.out.print(showMessage);
    }

    public static void showException(ErrorMessages message) {
        validateNull(message);

        System.out.print(message.getMessage());
    }
}
