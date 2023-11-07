package lotto.model;

import static lotto.configurations.ErrorMessages.*;
import static lotto.configurations.SettingValues.*;

public class BonusNumber {
    WinningNumbers winningNumbers;
    Integer bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Boolean equals(Integer number) {
        return bonusNumber.equals(number);
    }

    private void validate(WinningNumbers winningNumbers, Integer bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicateNumber(WinningNumbers winningNumbers, Integer number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + ALREADY_DRAWN_MESSAGE.get());
        }
    }

    private void validateRange(Integer number) {
        if (number < MIN_OF_RANGE.get() || number > MAX_OF_RANGE.get()) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + OUT_OF_RANGE_NUMBER_MESSAGE.get());
        }
    }
}
