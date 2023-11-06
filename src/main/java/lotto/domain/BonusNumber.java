package lotto.domain;

import lotto.util.Convertor;
import lotto.validation.BonusNumberValidator;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        BonusNumberValidator.validateRange(number);
        this.number = number;
    }

    public static BonusNumber ofNotDuplicatedWithWinningNumber(String input, WinningNumber winningNumber) {
        int bonusNumber = Convertor.convertStringToInt(input);
        BonusNumberValidator.validateNotContainedInWinningNumber(bonusNumber, winningNumber);
        return new BonusNumber(bonusNumber);
    }

    public boolean isEqual(int otherNumber) {
        return number == otherNumber;
    }
}
