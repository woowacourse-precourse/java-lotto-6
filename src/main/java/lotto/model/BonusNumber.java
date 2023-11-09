package lotto.model;

import lotto.validator.InputValidator;

public class BonusNumber {
    private int bonusNumber;

    BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber create(String inputBonusNumber) {
        validate(inputBonusNumber);
        return new BonusNumber(Integer.parseInt(inputBonusNumber));
    }

    private static void validate(String inputBonusNumber) {
        InputValidator.validateLottoNumberIsNotInRightRange(inputBonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
