package lotto.model;

import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void addBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
