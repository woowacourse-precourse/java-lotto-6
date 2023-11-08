package lotto.model;

import lotto.utils.ErrorMessage;

import java.util.Objects;

public class LottoNumber {
    public static final Integer MIN_LOTTO_NUMBER_RANGE = 1;
    public static final Integer MAX_LOTTO_NUMBER_RANGE = 45;
    private static final String LOTTO_NUMBER_RANGE_ERROR = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final Integer number;

    public LottoNumber(Integer number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE) {
            throw new ErrorMessage(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public Integer getNumber() {
        return number;
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
}
