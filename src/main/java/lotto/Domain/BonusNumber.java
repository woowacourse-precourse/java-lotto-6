package lotto.Domain;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValueBetween1And45;
import static lotto.Util.Util.ConvertStringToInteger;

public class BonusNumber {

    Integer bonusNumber;

    private BonusNumber(String bonusNumber) {
        this.bonusNumber = generateBonusNumber(bonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public static BonusNumber of(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private Integer generateBonusNumber(String inputBonusNumber) {
        hasBlank(inputBonusNumber);
        isInteger(inputBonusNumber);
        Integer bonusNumber = ConvertStringToInteger(inputBonusNumber);
        isValueBetween1And45(bonusNumber);
        return bonusNumber;
    }
}
