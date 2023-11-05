package lotto.model;

import static lotto.constants.Error.RANGE_INVALID;
import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber getInstance(int number) {
        return new LottoNumber(number);
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(RANGE_INVALID.getMessage());
        }
    }

    private static boolean isValidRange(int number) {
        return number >= MIN_LOTTO.getValue() && number <= MAX_LOTTO.getValue();
    }

    public int getLottNumber() {
        return number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return java.lang.Integer.compare(number, lottoNumber.getLottNumber());
    }
}
