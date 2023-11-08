package lotto.model;

import java.util.Set;

public class WinningNumbers {
    private Set<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers() {
    }

    public void addNumbers(Set<Integer> inputWinningNumbers) {
        this.numbers = inputWinningNumbers;
    }

    public void addBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
