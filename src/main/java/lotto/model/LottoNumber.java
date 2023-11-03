package lotto.model;

import java.util.Objects;

public final class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final String OUT_OF_RANGE_EXCEPTION_FORMAT = "로또 번호는 %d부터 %d까지의 숫자만 가능합니다.";

    private final int number;

    private LottoNumber(int number) {
        validateInRange(number);
        this.number = number;
    }

    private void validateInRange(int number) {
        if (isOutOfRange(number)) {
            String formattedExceptionMessage = String.format(OUT_OF_RANGE_EXCEPTION_FORMAT, MIN_NUMBER, MAX_NUMBER);
            throw new IllegalArgumentException(formattedExceptionMessage);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
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
