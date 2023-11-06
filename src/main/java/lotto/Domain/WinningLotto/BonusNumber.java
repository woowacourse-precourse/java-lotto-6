package lotto.Domain.WinningLotto;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValidLottoNumber;
import static lotto.Util.Util.convertStringToInteger;

public class BonusNumber {

    private Integer number;

    private BonusNumber(String number) {
        this.number = generateBonusNumber(number);
    }

    public static BonusNumber from(String number) {
        return new BonusNumber(number);
    }

    public Integer getNumber() {
        return number;
    }

    private Integer generateBonusNumber(String inputBonusNumber) {
        hasBlank(inputBonusNumber);
        isInteger(inputBonusNumber);
        Integer bonusNumber = convertStringToInteger(inputBonusNumber);
        isValidLottoNumber(bonusNumber);
        return bonusNumber;
    }
}
