package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;
import lotto.utils.Parser;

public class InputValidator {
    public static void validateBudget(String userInput) {
        validateInteger(userInput);
        validatePositiveInteger(userInput);
    }

    public static void validateLottoTicket(String userInput) {
        List<String> numbers = Parser.parseWithComma(userInput);
        numbers.forEach(InputValidator::validateInteger);
        numbers.forEach(InputValidator::validateNumberInRange);
    }

    private static void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
        }
    }

    private static void validatePositiveInteger(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INTEGER_MESSAGE.getMessage());
        }
    }

    private static void validateNumberInRange(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE_MESSAGE.getMessage());
        }
    }
}
