package lotto.util;

import lotto.common.Constant;

public class LottoNumberValidator {
    public static boolean validate(final Integer num) {
        return Constant.LOTTO_MIN_NUM <= num && num <= Constant.LOTTO_MAX_NUM;
    }
}
