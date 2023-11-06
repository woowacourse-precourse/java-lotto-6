package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.SortedRandomNumberGenerator;

public class WinningLotto {
    private final Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumber) {
        validateWinningNumber(winningNumber);
        this.winningNumber = new Lotto(winningNumber);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateWinningNumber(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            validateNumberRange(number);
        }
        validateDuplicate(winningNumber);
    }

    public void validateBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicate(bonusNumber);
    }

    private void validateNumberRange(int number) {
        if (number < SortedRandomNumberGenerator.START_RANGE || number > SortedRandomNumberGenerator.END_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
