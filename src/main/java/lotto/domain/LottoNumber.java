package lotto.domain;

import static lotto.enums.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER;
import static lotto.enums.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConfig.MIN_LOTTO_NUMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())
                .forEach(i -> LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i)));
    }

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        validateNumberRange(number);
        return LOTTO_NUMBER_CACHE.get(number);
    }

    private static void validateNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMassage());
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LottoNumber lottoNumber) {
            return this.number == lottoNumber.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public int compareTo(final LottoNumber lottoNumber) {
        return Integer.compare(this.number, lottoNumber.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
