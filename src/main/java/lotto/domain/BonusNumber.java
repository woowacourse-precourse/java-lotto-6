package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSetting.*;


public class BonusNumber {
    private final Integer value;

    public BonusNumber(WinningNumber winningNumber, String bonusNumberInput) {
        this.value = validateBonusNumber(winningNumber, bonusNumberInput);
    }

    private Integer validateBonusNumber(WinningNumber winningNumber, String bonusNumberInput) {
        Integer bonusNumber = validateNumeric(bonusNumberInput);
        validateRange(bonusNumber);
        winningNumber.checkDuplicateBonus(bonusNumber);
        return bonusNumber;
    }

    private void validateRange(Integer bonusNumber) {
        if (bonusNumber < MIN_RANDOM_NUMBER.getValue() || bonusNumber > MAX_RANDOM_NUMBER.getValue()) {
            throw new IllegalArgumentException(
                    format(NOT_RANGE.getMessage(), MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue())
            );
        }
    }

    private Integer validateNumeric(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkBonus(value);
    }
}
