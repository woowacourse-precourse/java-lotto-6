package lotto.domain.wrapper;

import java.util.Objects;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstantValue;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < LottoConstantValue.MIN_LOTTO_NUMBER.get()
                || lottoNumber > LottoConstantValue.MAX_LOTTO_NUMBER.get()) {
            throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getWithFormatAndPrefix(
                            LottoConstantValue.MIN_LOTTO_NUMBER.get(),
                            LottoConstantValue.MAX_LOTTO_NUMBER.get()
                    )
            );
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
        LottoNumber otherLottoNumber = (LottoNumber) object;
        return lottoNumber == otherLottoNumber.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber otherLottoNumber) {
        return Integer.compare(lottoNumber, otherLottoNumber.lottoNumber);
    }
}
