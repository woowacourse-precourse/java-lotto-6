package lotto.model;

import static lotto.ErrorMessage.NOT_NUMBER_FORMAT;

import lotto.validator.LottoValidator;
import lotto.view.OutPutView;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber createBonusNumber(String bonusNumber) {
        if (isValid(bonusNumber)) {
            return new BonusNumber(Integer.parseInt(bonusNumber));
        }
        return null;
    }

    private static boolean isValid(String bonusNumber) {
        if (!bonusNumber.matches("\\d+")) {
            OutPutView.println(NOT_NUMBER_FORMAT.getMessage());
            return false;
        }
        return LottoValidator.isBonusInRange(Integer.parseInt(bonusNumber));
    }

    public int getNumber() {
        return bonusNumber;
    }
}
