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

    public static void validateLottoNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.START.getValue() + ErrorMessage.LOTTO_IS_NOT_NUMBER.getValue());
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.START.getValue() + ErrorMessage.BONUS_IS_NOT_NUMBER.getValue());
        }
    }
}
