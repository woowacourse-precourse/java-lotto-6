package lotto.validation;

import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

public class LottoNumberValidator {

    private static void validateRange(int number) {
        GameConfig minNumber = GameConfig.MIN_LOTTO_NUMBER;
        GameConfig maxNumber = GameConfig.MAX_LOTTO_NUMBER;

        if (number < minNumber.getValue() || number > maxNumber.getValue()) {
            ExceptionMessage message = ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }
}
