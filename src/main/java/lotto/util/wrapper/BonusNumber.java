package lotto.util.wrapper;

import static lotto.util.validators.WinningBonusNumbersValidator.validateBonusNumber;

public class BonusNumber {
    private final Integer value;

    public  BonusNumber(String value) {
        validateBonusNumber(value);
        this.value = Integer.valueOf(value);
    }
}
