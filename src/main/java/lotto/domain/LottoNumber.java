package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoEnum;
import lotto.utils.StringUtil;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber valueOf(String stringNumber) {
        return LottoNumber.valueOf(StringUtil.stringToInt(stringNumber));
    }

    public static LottoNumber valueOf(int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number) {
        if (number < LottoEnum.MIN_LOTTO_NUMBER.getValue()
                || number > LottoEnum.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
