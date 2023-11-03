package lotto.Domain.WinningLotto;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValueBetween1And45;
import static lotto.Util.Util.ConvertStringToInteger;

public class BonusNumber {

    Integer number;

    private BonusNumber(String number) {
        this.number = generateBonusNumber(number);
    }

    public Integer getNumber() {
        return number;
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
