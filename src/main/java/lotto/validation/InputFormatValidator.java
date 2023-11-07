package lotto.validation;

import lotto.utility.TypeConverter;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;
import static lotto.message.ErrorMessage.ERROR_MESSAGE_HEAD;
import static lotto.message.ErrorMessage.INVALID_MONEY_INPUT_EXCEPTION;

public class InputFormatValidator {
    public static void validateMoneyFormat(String input) {
        if (input.matches("[1-9][0-9]*")) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }

    public static void validateMoneyIsMultipleOfLottoPrice(String input) {
        if (TypeConverter.convertStringToInt(input) % LOTTO_PRICE == 0) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }
}
