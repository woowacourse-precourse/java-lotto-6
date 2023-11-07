package lotto.model;

import java.util.List;

public class BonusNumber {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;

    private final int number;

    public BonusNumber(final int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(final int number) {
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1~45사이 숫자여야 합니다.");
        }
    }

    public boolean existIn(List<Integer> numbers) {
        return numbers.contains(number);
    }
}
