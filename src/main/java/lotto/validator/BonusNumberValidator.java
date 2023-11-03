package lotto.validator;

import lotto.Lotto;
import lotto.message.ExceptionMessage;

public class BonusNumberValidator {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    public static void validate(Lotto winnerLotto, int bonusNumber) {
        validateNumberInRange(bonusNumber);
        validateNotInWinnerNumbers(winnerLotto, bonusNumber);
    }

    private static void validateNumberInRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    private static void validateNotInWinnerNumbers(Lotto winnerLotto, int bonusNumber) {
        if (winnerLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

}
