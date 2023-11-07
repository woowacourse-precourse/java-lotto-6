package lotto.vo;

import lotto.constant.LottoConstants;
import lotto.exception.LottoException;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {
    private final Integer value;

    public LottoNumber(final Integer value) throws LottoException {
        validate(value);
        this.value = value;
    }

    private void validate(final Integer value) throws LottoException {
        if (value < LottoConstants.LOTTO_MIN_NUMBER.getValue()) {
            throw new LottoException(LottoException.ErrorMessage.RANGE_LOTTO_NUMBER.getMessage());
        }

        if (value > LottoConstants.LOTTO_MAX_NUMBER.getValue()) {
            throw new LottoException(LottoException.ErrorMessage.RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    @Override
    public int compareTo(LottoNumber other) {
        return value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        LottoNumber other = (LottoNumber) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
