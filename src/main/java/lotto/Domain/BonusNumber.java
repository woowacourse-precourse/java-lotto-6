package lotto.Domain;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValueBetween1And45;
import static lotto.Util.Util.ConvertStringToInteger;

public class BonusNumber {

    String bonusNumber;

    private BonusNumber(String bonusNumber) {
        generateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public String getBonusNumber() {
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
