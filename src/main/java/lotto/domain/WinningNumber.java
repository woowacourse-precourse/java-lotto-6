package lotto.domain;

import java.util.List;

public class WinningNumber {

    private Lotto numbers;
    private int bonusNumber;

    public WinningNumber(Lotto numbers) {
        this.numbers = numbers;
        this.bonusNumber = 0;
    }

    public void addBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNormalNumbers() {
        return numbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
