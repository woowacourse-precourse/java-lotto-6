package lotto.domain.wrapper;

import java.util.Objects;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstantValue;

public class LottoNumber implements Comparable<LottoNumber>{
    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LottoConstantValue.MIN_LOTTO_NUMBER.get()
                || number > LottoConstantValue.MAX_LOTTO_NUMBER.get()) {
            throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getFormattedMessage(
                            LottoConstantValue.MIN_LOTTO_NUMBER.get(), LottoConstantValue.MAX_LOTTO_NUMBER.get()));
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber otherLottoNumber) {
        return Integer.compare(number, otherLottoNumber.number);
    }
}
