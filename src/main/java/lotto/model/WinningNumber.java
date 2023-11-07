package lotto.model;

import java.util.Set;

public class WinningNumber {
    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(Set<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
