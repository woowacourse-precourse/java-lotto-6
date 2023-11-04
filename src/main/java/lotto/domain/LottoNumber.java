package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LIMIT = 1;
    private static final int MAX_LIMIT = 45;

    private int number;

    private static Map<Integer, LottoNumber> lottoNumberStore = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_LIMIT, MAX_LIMIT)
                .forEach(number -> lottoNumberStore.put(number, new LottoNumber(number)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return lottoNumberStore.get(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
