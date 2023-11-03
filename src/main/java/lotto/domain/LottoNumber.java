package lotto.domain;

import java.util.Objects;
import lotto.LottoExceptionMessage;

public class LottoNumber {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_NUMBER.getError());
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
}
