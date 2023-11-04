package lotto.utils;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WN_UNITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;

import java.math.BigDecimal;

public class LottoUtil {
    public static void validateLottoNum(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
        if (num > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    public static void validateMultiplesOf(BigDecimal num, BigDecimal factor) {
        if (num.remainder(factor).compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_IN_THOUSAND_WN_UNITS.getMessage());
        }
    }
}
