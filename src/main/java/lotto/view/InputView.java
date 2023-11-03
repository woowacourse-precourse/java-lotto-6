package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.PURCHASE_PRICE_NOT_INTEGER;

public final class InputView {
    private InputView() {
    }

    public static int readPurchasePrice() {
        try {
            final String input = Console.readLine();
            return convertStringToInt(input);
        } catch (LottoException exception) {
            return readPurchasePrice();
        }
    }

    private static Integer convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw LottoException.of(PURCHASE_PRICE_NOT_INTEGER, exception);
        }
    }
}
