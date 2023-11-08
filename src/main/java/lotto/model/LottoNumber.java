package lotto.model;

import lotto.constant.response.Exception;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final Integer number;

    public LottoNumber(Integer number) {
        validRange(number);
        this.number = number;
    }

    private void validRange(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(Exception.ERROR_PREFIX.getMessage()
                    + Exception.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
