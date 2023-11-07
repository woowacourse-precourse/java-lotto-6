package lotto.domain;

import java.util.Objects;

public class Bonus {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String RANGE_EXCEPTION = "보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.";

    private final int number;

    public Bonus(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(String.format(RANGE_EXCEPTION, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bonus bonus = (Bonus) o;
        return number == bonus.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
