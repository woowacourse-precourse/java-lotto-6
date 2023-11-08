package lotto.model;

import lotto.validator.LottoValidator;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber createBonusNumber(int bonusNumber) {
        if (isValid(bonusNumber)) {
            return new BonusNumber(bonusNumber);
        }
        return null;
    }

    private static boolean isValid(int bonusNumber) {
        return LottoValidator.isBonusInRange(bonusNumber);
    }

    public int getNumber() {
        return bonusNumber;
    }
}
