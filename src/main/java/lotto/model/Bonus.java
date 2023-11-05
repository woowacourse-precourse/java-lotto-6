package lotto.model;

import lotto.validator.BonusValidator;

public class Bonus {
    private int number;

    public Bonus(Lotto lotto, String inputBonusNumber) {
        BonusValidator.validate(lotto, inputBonusNumber);
        this.number = stringToInteger(inputBonusNumber);
    }

    private int stringToInteger(String inputBonusNumber) {
        return Integer.parseInt(inputBonusNumber);
    }

    public int getBonusNumber() {
        return number;
    }

}
