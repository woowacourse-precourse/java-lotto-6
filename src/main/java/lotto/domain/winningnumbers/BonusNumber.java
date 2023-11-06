package lotto.domain.winningnumbers;

import static lotto.domain.winningnumbers.WinningNumbersConfig.MAXIMUM_RANGE;
import static lotto.domain.winningnumbers.WinningNumbersConfig.MINIMUM_RANGE;
import static lotto.domain.winningnumbers.WinningNumbersErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.domain.winningnumbers.WinningNumbersErrorMessage.BONUS_NUMBER_INVALID_RANGE;

import java.util.List;

public class BonusNumber {

    private final int number;

    public BonusNumber(List<Integer> winningNumbers, int number) {
        validate(winningNumbers,number);
        this.number = number;
    }

    public boolean isBonusNumber(int number) {
        return this.number == number;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if(validateBonusNumberInNumbers(winningNumbers,bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
        if(validateBonusNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_INVALID_RANGE.getMessage());
        }
    }

    private boolean validateBonusNumberInNumbers(List<Integer> winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    private boolean validateBonusNumberRange(int bonusNumber) {
        return (bonusNumber < MINIMUM_RANGE.getValue() || bonusNumber > MAXIMUM_RANGE.getValue());
    }
}
