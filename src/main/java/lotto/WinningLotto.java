package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
        if (!isCorrectRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.INCORRECT_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
