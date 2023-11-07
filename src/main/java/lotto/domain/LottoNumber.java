package lotto.domain;

import java.util.Objects;
import lotto.domain.constant.LottoConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class LottoNumber {
    protected int number;

    protected LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        validate(number);
        return new LottoNumber(number);
    }

    protected static void validate(final int number) {
        isInAppropriateRange(number);
    }

    protected static void isInAppropriateRange(final int number) {
        if (isNotInAppropriateRange(number)) {
            throw LottoInputException.of(LottoInputExceptionMessage.LOTTO_NUMBER_IS_NOT_IN_APPROPRIATE_RANGE);
        }
    }

    protected static boolean isNotInAppropriateRange(final int number) {
        return number < LottoConstant.LOTTO_MIN_NUM.getValue() || number > LottoConstant.LOTTO_MAX_NUM.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}