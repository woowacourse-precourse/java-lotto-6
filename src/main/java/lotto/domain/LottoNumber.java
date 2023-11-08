package lotto.domain;

import java.util.Objects;
import lotto.utils.message.LottoExceptionMessage;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_RANGE.getError());
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MINIMUM || number > MAXIMUM;
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

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
