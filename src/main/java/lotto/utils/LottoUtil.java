package lotto.utils;

import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;

public class LottoUtil {
    public static void validateLottoNum(int num) {
        if (1 <= num && num <= 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }
}
