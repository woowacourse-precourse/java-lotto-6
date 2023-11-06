package lotto.domain;

import lotto.domain.constant.LottoConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class LottoNumber {
    private long number;

    protected LottoNumber(final long number) {
        this.number = number;
    }

    public static LottoNumber of(final long number) {
        validate(number);
        return new LottoNumber(number);
    }

    private static void validate(final long number) {
        isInAppropriateRange(number);
    }

    private static void isInAppropriateRange(final long number) {
        if (isNotInAppropriateRange(number)) {
            throw LottoInputException.of(LottoInputExceptionMessage.LOTTO_NUMBER_IS_NOT_IN_APPROPRIATE_RANGE);
        }
    }

    private static boolean isNotInAppropriateRange(final long number) {
        return number < LottoConstant.LOTTO_MIN_NUM.getValue() || number > LottoConstant.LOTTO_MAX_NUM.getValue();
    }
}