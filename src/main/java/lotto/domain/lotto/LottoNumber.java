package lotto.domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    static {
        IntStream.rangeClosed(1, 45).forEach(integer -> CACHE.put(integer, new LottoNumber(integer)));
    }

    public static LottoNumber of(int rawValue) {
        validate(rawValue);
        return CACHE.get(rawValue);
    }


    public static List<LottoNumber> getLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validate(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1이상 45이하여야 합니다");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (object == null || object.getClass() != getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) object;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

}
