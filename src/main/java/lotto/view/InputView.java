package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.PAYMENT_NOT_INTEGER;

public class InputView {
    private InputView() {
    }

    public static int readPayment() {
        try {
            final String input = Console.readLine();
            return convertStringToInt(input);
        } catch (LottoException exception) {
            return readPayment();
        }
    }

    private static Integer convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw LottoException.of(PAYMENT_NOT_INTEGER, exception);
        }
    }
}
