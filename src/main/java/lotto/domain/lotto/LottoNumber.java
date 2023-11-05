package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final String UNKNOWN_NUMBER_MESSAGE = "알 수 없는 숫자로 로또 번호를 생성할 수 없습니다.";
    private static final String INVALID_NUMBER_RANGE_MESSAGE =
            "로또 번호는 " + MIN_NUMBER_RANGE + "부터 " + MAX_NUMBER_RANGE + " 사이의 숫자여야 합니다.";

    private final Integer number;

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber from(Integer number) {
        validate(number);

        return new LottoNumber(number);
    }

    private static void validate(Integer number) {
        checkNumberNonNull(number);
        checkNumberRange(number);
    }

    private static void checkNumberNonNull(Integer number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(UNKNOWN_NUMBER_MESSAGE);
        }
    }

    private static void checkNumberRange(Integer number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    private static boolean isOutOfRange(Integer number) {
        return isOutOfMinRange(number) || isOutOfMaxRange(number);
    }

    private static boolean isOutOfMinRange(Integer number) {
        return number < MIN_NUMBER_RANGE;
    }

    private static boolean isOutOfMaxRange(Integer number) {
        return number > MAX_NUMBER_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
