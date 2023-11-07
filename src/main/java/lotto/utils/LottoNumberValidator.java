package lotto.utils;

import lotto.constant.LottoConstant;

public class LottoNumberValidator {
    public static void validate(Integer number) {
        if (!isProperLottoNumber(number)) {
            throw new IllegalArgumentException("로또 숫자는 1~45의 범위를 만족해야합니다.");
        }
    }

    public static boolean isProperLottoNumber(Integer number) {
        return LottoConstant.MIN_NUMBER <= number && number <= LottoConstant.MAX_NUMBER;
    }
}
