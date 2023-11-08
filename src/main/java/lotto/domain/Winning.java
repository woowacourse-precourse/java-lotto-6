package lotto.domain;

import java.util.List;
import lotto.util.NumberValidator;

public class Winning {
    private final List<Integer> numbers;
    private Integer bonusNumber;

    public Winning(List<Integer> numbers) {
        NumberValidator.verifyWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        NumberValidator.verifyBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
