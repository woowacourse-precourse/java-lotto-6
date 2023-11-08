package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public record BonusNumber(int bonus) {
    public BonusNumber {
        validateRange(bonus);
    }

    public static BonusNumber create(String bonus) {
        return new BonusNumber(validateInteger(bonus));
    }

    private static int validateInteger(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
    }

    private static void validateRange(int number) {
        if (number < LottoConstant.LOTTO_NUMBER_MIN || number > LottoConstant.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_BONUS_NUMBER);
        }
    }
}
