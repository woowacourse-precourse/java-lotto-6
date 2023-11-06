package lotto.validator;

import static lotto.Option.ErrorMessage.ONE_TO_FORTY_FIVE;

import lotto.Option.GameOption;

public class BonusValidator {
    public static void range(int bonusNumber) {
        if (bonusNumber < GameOption.LOTTO_MIN_NUMBER.getNumber()
                || bonusNumber > GameOption.LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ONE_TO_FORTY_FIVE.getErrorMessage());
        }
    }
}
