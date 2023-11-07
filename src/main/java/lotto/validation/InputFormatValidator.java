package lotto.validation;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;
import static lotto.message.ErrorMessage.*;

public class InputFormatValidator {
    public static void validateMoneyFormat(String input) {
        if (input.matches("[1-9][0-9]*")) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_MONEY_FORMAT_EXCEPTION);
    }

    public static void validateMoneyIsMultipleOfLottoPrice(int input) {
        if (input % LOTTO_PRICE == 0) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + MONEY_NOT_MULTIPLE_EXCEPTION);
    }
}
