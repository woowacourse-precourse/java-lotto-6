package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private final int number;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 45보다 크거나 1보다 작을수 없습니다.");
        }
    }

    public static LottoNumber getInstance(int number) {
        if (CACHE.containsKey(number)) {
            return CACHE.get(number);
        }
        LottoNumber lottoNumber = new LottoNumber(number);
        CACHE.put(number, lottoNumber);
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
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
        return Integer.toString(number);
    }
}