package lotto;

import java.util.Objects;

class LottoNumber {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final String INVALID_NUMBER_RANGE_MESSAGE =
            "로또 번호는 " + MIN_NUMBER_RANGE + "부터 " + MAX_NUMBER_RANGE + " 사이의 숫자여야 합니다.";

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        checkNumberRange(number);

        return new LottoNumber(number);
    }

    private static void checkNumberRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
