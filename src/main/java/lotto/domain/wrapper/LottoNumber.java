package lotto.domain.wrapper;

import java.util.Objects;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstant;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER.getNumber()
                || number > LottoConstant.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getFormattedMessage(
                            LottoConstant.MIN_LOTTO_NUMBER.getNumber(), LottoConstant.MAX_LOTTO_NUMBER.getNumber()));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
