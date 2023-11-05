package lotto.domain;

import lotto.constant.ErrorMessage;

public class BonusNumber {
    private final Integer value;

    public BonusNumber(String bonusNumberInput) {
        this.value = validateBonusNumber(bonusNumberInput);
    }

    private Integer validateBonusNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }
}
