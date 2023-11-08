package lotto.domain;

import java.util.List;
import lotto.exception.DuplicateNumberException;

public class WinningNumber {

    private final Lotto numbers;
    private final int bonusNumber;

    public WinningNumber(Lotto numbers, int bonusNumber) {
        bonusNumDuplicate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumDuplicate(Lotto numbers, int bonusNumber) {
        if (numbers.getNumbers().contains(bonusNumber)) {
            throw new DuplicateNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
