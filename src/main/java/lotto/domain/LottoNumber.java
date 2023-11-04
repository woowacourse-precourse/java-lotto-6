package lotto.domain;

import static lotto.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> CACHE;

    static {
        CACHE = Map.copyOf(
                IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                        .boxed()
                        .collect(Collectors.toMap(number -> number, LottoNumber::new)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        if (CACHE.containsKey(number)) {
            return CACHE.get(number);
        }

        throw new IllegalArgumentException(
                String.format(LOTTO_NUMBER_RANGE_ERROR.getMessage(), MIN_NUMBER, MAX_NUMBER));
    }
}
