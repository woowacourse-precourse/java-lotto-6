package lotto.domain.winningNumber;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

class WinningNumberValidator {

    static void validateNumericInput(String content) {
        if (!content.matches("[0-9]+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.getMessage());
        }
    }

    static void validateValueInRange(String content) {
        int result = Integer.parseInt(content);
        if (result < LottoRule.LOTTO_MIN_NUMBER.getNumber()
                || LottoRule.LOTTO_MAX_NUMBER.getNumber() < result) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE.getMessage());
        }
    }
}
