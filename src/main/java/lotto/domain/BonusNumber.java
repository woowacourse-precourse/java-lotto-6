package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSetting.*;


public class BonusNumber {
    private final Integer value;

    public BonusNumber(String bonusNumberInput) {
        this.value = validateBonusNumber(bonusNumberInput);
    }

    private Integer validateBonusNumber(String bonusNumberInput) {
        Integer bonusNumber = validateNumeric(bonusNumberInput);
        validateRange(bonusNumber);
        return bonusNumber;
    }

    private void validateRange(Integer bonusNumber) {
        if (bonusNumber < MIN_RANDOM_NUMBER.getValue() || bonusNumber > MAX_RANDOM_NUMBER.getValue()) {
            throw new IllegalArgumentException(NOT_RANGE.getMessage());
        }
    }

    private Integer validateNumeric(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }
}
