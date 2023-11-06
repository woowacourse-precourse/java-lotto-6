package lotto.view.validation;

import lotto.message.ErrorMessage;
import lotto.util.constans.RegularExpression;

public class InputValidator {

    public static void validateBlank(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.START.getValue() + ErrorMessage.BLANk.getValue());
        }
    }

    public static void validateNumber(String inputNumber) {
        if (!inputNumber.matches(RegularExpression.NUMBER_REGEX_INCLUDE_NEGATIVE.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.START.getValue() + ErrorMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getValue());
        }
    }
}
