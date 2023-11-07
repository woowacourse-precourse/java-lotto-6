package lotto;

import Exception.ContainDuplicatedNumberException;
import Exception.OutOfRangeNumberException;
import Exception.WinningNumberContainsBonusNumberException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private List<Integer> numbers;
    private int bonusNumber;

    public void setNumbers(List<Integer> numbers) {
        validateWinningNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumber(List<Integer> numbers) {
        validateDuplication(numbers);
        validateNumberRange(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        Set set = new HashSet(numbers);
        if (numbers.size() != set.size()) {
            throw new ContainDuplicatedNumberException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i < MIN_NUMBER || i > MAX_NUMBER) {
                throw new OutOfRangeNumberException();
            }
        }
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateExist(bonusNumber);
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new OutOfRangeNumberException();
        }
    }

    private void validateExist(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new WinningNumberContainsBonusNumberException();
        }
    }
}
