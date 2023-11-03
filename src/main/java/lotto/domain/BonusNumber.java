package lotto.domain;

import lotto.util.Convertor;
import lotto.validation.BonusNumberValidator;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        BonusNumberValidator.validateRange(number);
        this.number = number;
    }

    public static BonusNumber from(String input) {
        return new BonusNumber(Convertor.convertStringToInt(input));
    }

    public boolean isEqual(int otherNumber) {
        return number == otherNumber;
    }

    public boolean isExistAt(WinningNumber winningNumber) {
        if (winningNumber.isContains(number)) {
            return true;
        }
        return false;
    }
}
