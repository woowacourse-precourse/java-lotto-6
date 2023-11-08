package lotto.vo;

import lotto.constant.LottoConstants;
import lotto.exception.LottoException;

public record LottoNumber(Integer value) implements Comparable<LottoNumber> {
    /**
     * @throws LottoException
     * 
     * 생성자에 들어온 Integer 범위가 [1, 45] 아닌 경우 예외를 던진다.
     */
    public LottoNumber {
        validate(value);
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
}
