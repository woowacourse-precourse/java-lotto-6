package lotto.model;

import java.util.List;

public class WinningNumbers extends Lotto {

    private final int bonusNumber;

    private WinningNumbers(final List<Integer> numbers, final int bonusNumber) {
        super(numbers);
        validateInRange(bonusNumber);
        validateNotDuplicated(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(final List<Integer> numbers, final int bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
    }

    private void validateInRange(final int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotDuplicated(final int bonusNumber) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
