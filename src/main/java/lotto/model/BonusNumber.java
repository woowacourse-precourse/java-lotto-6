package lotto.model;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!isBonusNumbersValid(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBonusNumbersValid(int bonusNumber) {
        boolean duplicatesValid = isBonusNumberInWinningNumbers(bonusNumber);
        boolean boundsValid = checkInputBounds(bonusNumber);
        return duplicatesValid && boundsValid;
    }

    private boolean isBonusNumberInWinningNumbers(int bonusNumber) {
        for (int number : WinningNumbers.getWinningNumbers()) {
            if (number == bonusNumber) {
                return false;
            }
        }
        return true;
    }

    private boolean checkInputBounds(int bonusNumber) {
        return 1 <= bonusNumber && bonusNumber <= 45;
    }
}
