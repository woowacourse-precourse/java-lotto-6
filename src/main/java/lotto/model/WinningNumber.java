package lotto.model;

import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_BONUS_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.List;

public class WinningNumber extends Lotto {
    private final int bonus;

    public WinningNumber(List<Integer> numbers, int bonus) {
        super(numbers);
        validateBonusNumber(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonus) {
        bonusNumberWinningNumberDuplicateValidate(numbers, bonus);
        bonusNumberUnderOverValidate(bonus);
    }

    private void bonusNumberUnderOverValidate(int bonus) {
        if (bonus < 1 || bonus > 45) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void bonusNumberWinningNumberDuplicateValidate(List<Integer> numbers, int bonus) {
        if (numbers.stream().anyMatch(number -> number == bonus)) {
            exceptionCodeThrow(LOTTO_NUMBER_BONUS_DUPLICATE);
        }
    }
}
