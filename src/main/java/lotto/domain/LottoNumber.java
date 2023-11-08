package lotto.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MINIMUM_VALUE = 1;
    public static final int MAXIMUM_VALUE = 45;
    private static final String NUMBER_RANGE_ERROR_MESSAGE_FORMAT = "로또 번호는 %d에서 %d사이의 숫자여야 합니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE;
    private static final Map<Integer, LottoNumber> CACHED_LOTTO_NUMBERS;

    static {
        NUMBER_RANGE_ERROR_MESSAGE = String.format(NUMBER_RANGE_ERROR_MESSAGE_FORMAT, MINIMUM_VALUE, MAXIMUM_VALUE);
        CACHED_LOTTO_NUMBERS = cachedLottoNumbers();
    }

    private static Map<Integer, LottoNumber> cachedLottoNumbers() {
        return IntStream.rangeClosed(MINIMUM_VALUE, MAXIMUM_VALUE)
                .mapToObj(LottoNumber::new)
                .collect(toMap(LottoNumber::value, Function.identity()));
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber from(int value) {
        validateRange(value);

        return CACHED_LOTTO_NUMBERS.get(value);
    }

    private static void validateRange(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public int value() {
        return value;
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
