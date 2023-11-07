package lotto.domain;

import java.util.List;
import lotto.exception.NumberValidator;

public class WinningNumbers {

    private final List<Integer> numbers;
    private final int BONUS_NUMBER;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        NumberValidator.validate(numbers);
        NumberValidator.validate(bonusNumber);
        this.numbers = numbers;
        this.BONUS_NUMBER = bonusNumber;
    }

    public int calculateWinningNumber(Lotto lotto){
        return lotto.getCorrectNumberCount(numbers);
    }

    public int calculateBonusNumber(Lotto lotto){
        return lotto.getCorrectNumberCount(BONUS_NUMBER);
    }
}
