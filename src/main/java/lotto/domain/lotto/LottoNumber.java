package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final HashMap<Integer, LottoNumber> cache;

    private final int number;

    static {
        cache = new HashMap<>();
    }

    private LottoNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        final LottoNumber lottoNumber = new LottoNumber(number);
        cache.put(number, lottoNumber);
        return lottoNumber;
    }

    private void validateNumber(final int number) {
        isBetweenMinimumAndMaximum(number);
    }

    private void isBetweenMinimumAndMaximum(final int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
