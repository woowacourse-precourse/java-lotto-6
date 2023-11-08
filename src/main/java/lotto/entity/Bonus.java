package lotto.entity;

import lotto.property.ErrorProperty;

import static lotto.property.ValidationProperty.BONUS;
import static lotto.validation.ValidationForm.verifyFormatForInputValue;

public class Bonus {

    private final Integer bonusNumber;

    public Bonus(String inputBonusNumber, Winning winning) {
        this.bonusNumber = bonusNumberParsingForFieldValue(inputBonusNumber, winning);
    }

    private Integer bonusNumberParsingForFieldValue(String inputBonusNumber, Winning winning) {
        validate(inputBonusNumber, winning);
        return Integer.parseInt(inputBonusNumber);
    }

    private void validate(String bonusNumber, Winning winning) {
        verifyFormatForInputValue(BONUS, bonusNumber);
        if (winning.getWinningNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorProperty.BONUS_NUMBER_IS_DUPLICATE.toString());
        }
    }

/*
    public Integer getBonusNumber() {
        return (Integer) FiledMapper.getFieldValue(this, MethodProperty.BONUS_NUMBER);
    }
*/

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
