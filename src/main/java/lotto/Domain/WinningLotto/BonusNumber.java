package lotto.Domain.WinningLotto;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValidLottoNumber;
import static lotto.Util.Util.convertStringToInteger;

public class BonusNumber {

    private final int number;

    private BonusNumber(String inputBonusNumber) {
        validate(inputBonusNumber);
        this.number = convertStringToInteger(inputBonusNumber);
    }

    public static BonusNumber from(String number) {
        return new BonusNumber(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String inputBonusNumber) {
        hasBlank(inputBonusNumber);
        isInteger(inputBonusNumber);
        Integer bonusNumber = convertStringToInteger(inputBonusNumber);
        isValidLottoNumber(bonusNumber);
    }
}
