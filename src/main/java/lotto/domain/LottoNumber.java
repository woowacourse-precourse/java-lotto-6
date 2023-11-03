package lotto.domain;

import static lotto.domain.LottoNumberRules.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumberRules.MIN_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.Objects;
import lotto.exception.LottoGameException;

public class LottoNumber {
    private final int number;

    LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isNumberOutOfRange(number)) {
            throw new LottoGameException(String.format(LOTTO_NUMBER_OUT_OF_RANGE.getMessage(), number));
        }
    }

    private static boolean isNumberOutOfRange(int number) {
        return number < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < number;
    }

    int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
