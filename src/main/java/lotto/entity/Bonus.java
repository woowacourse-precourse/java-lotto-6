package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

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

    public Integer getBonusNumber() {
        return (Integer) FiledMapper.getFieldValue(this, MethodProperty.BONUS_NUMBER);
    }
}
