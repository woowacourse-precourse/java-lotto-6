package lotto.util;

import static lotto.domain.exception.LottoException.INVALID_LOTTO_RANGE;
import static lotto.util.Constants.LOTTO_NUMBER_MAX_RANGE;
import static lotto.util.Constants.LOTTO_NUMBER_MIN_RANGE;

public class LottoUtil {
    public static void verifyRangeOfLottoNumber(Integer number) {
        if (number < LOTTO_NUMBER_MIN_RANGE || number > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
    }
}
