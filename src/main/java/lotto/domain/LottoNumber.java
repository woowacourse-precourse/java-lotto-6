package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final LottoNumber[] CACHE = new LottoNumber[UPPER_BOUND + 1];

    static {
        IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
                .forEach(number -> CACHE[number] = new LottoNumber(number));
    }

    private final int number;

    private LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        validateBound(number);
        return CACHE[number];
    }

    public static void validateBound(final int number) {
        if ((number < LOWER_BOUND) || (number > UPPER_BOUND)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    private void validate(final int number) {
        validateBound(number);
    }

    @Override
    public boolean equals(final Object o) {
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
