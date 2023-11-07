package lotto.model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
