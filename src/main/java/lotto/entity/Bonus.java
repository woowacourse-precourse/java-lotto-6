package lotto.entity;

import static lotto.property.ValidationProperty.BONUS;
import static lotto.validation.ValidationForm.verifyFormatForInputValue;

public class Bonus {

    private final Integer bonusNumber;

    public Bonus(String inputBonusNumber) {
        this.bonusNumber = bonusNumberParsingForFieldValue(inputBonusNumber);
    }

    private Integer bonusNumberParsingForFieldValue(String inputBonusNumber) {
        validate(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private void validate(String bonusNumber) {
        verifyFormatForInputValue(BONUS, bonusNumber);
    }
}
