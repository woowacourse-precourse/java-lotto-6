package lotto.validation;

import lotto.utility.FormatConverter;
import lotto.utility.TypeConverter;

import java.util.List;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;
import static lotto.message.ErrorMessage.*;

public class InputFormatValidator {
    public static void validateMoneyFormat(String purchaseAmountInput) {
        if (purchaseAmountInput.matches("[1-9][0-9]*")) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }

    public static void validateMoneyIsMultipleOfLottoPrice(String purchaseAmountInput) {
        if (TypeConverter.convertStringToInt(purchaseAmountInput) % LOTTO_PRICE == 0) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }

    public static void validateWinningNumbers(String winningNumbersInput) {
        String[] winningNumbers = winningNumbersInput.split(",");

        validateNumberFormat(winningNumbers);
        validateCountOfNumbers(winningNumbers);

        List<Integer> convertedWinningNumbers
                = FormatConverter.toIntegerListFromStringWithComma(winningNumbersInput);

        LottoNumberValidator.validateDuplicateNumbers(convertedWinningNumbers);
        LottoNumberValidator.validateNumberRange(convertedWinningNumbers);
        LottoNumberValidator.validateNumbersOrder(convertedWinningNumbers);
    }

    private static void validateCountOfNumbers(String[] winningNumbers) {
        if (winningNumbers.length == COUNT) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_WINNING_NUMBER_INPUT_EXCEPTION);
    }

    private static void validateNumberFormat(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (!winningNumber.matches("[1-9][0-9]*")) {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_WINNING_NUMBER_INPUT_EXCEPTION);
            }
        }
    }
}
