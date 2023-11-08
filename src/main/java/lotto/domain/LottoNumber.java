package lotto.domain;

import static lotto.constants.ErrorConstants.OUT_OF_RANGE_NUMBER_ERROR_MESSAGE;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_RANGE_END;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_RANGE_START;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber create(int number) {
        return new LottoNumber(number);
    }

    private boolean isOutOfRange(int number) {
        return number < LOTTO_NUMBER_RANGE_START.getValue() || number > LOTTO_NUMBER_RANGE_END.getValue();
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(
                    String.format(OUT_OF_RANGE_NUMBER_ERROR_MESSAGE.getMessage(),
                            LOTTO_NUMBER_RANGE_START.getValue(),
                            LOTTO_NUMBER_RANGE_END.getValue()));
        }
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
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
}
