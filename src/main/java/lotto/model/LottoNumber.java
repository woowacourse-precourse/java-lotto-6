package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public final class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final String OUT_OF_RANGE_EXCEPTION_FORMAT = "로또 번호는 %d부터 %d까지의 숫자만 가능합니다.";
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .forEach(LottoNumber::storeInCache);
    }

    private final int number;

    private LottoNumber(int number) {
        validateInRange(number);
        this.number = number;
    }

    private void validateInRange(int number) {
        if (isOutOfRange(number)) {
            String exceptionMessage = String.format(OUT_OF_RANGE_EXCEPTION_FORMAT, MIN_NUMBER, MAX_NUMBER);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    private static void storeInCache(int number) {
        LOTTO_NUMBER_CACHE.put(number, new LottoNumber(number));
    }

    public static LottoNumber from(int number) {
        return LOTTO_NUMBER_CACHE.computeIfAbsent(number, LottoNumber::new);
    }

    public int getNumber() {
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
}
