package lotto.model;

import lotto.utils.FormatUtils;
import lotto.validator.BonusValidator;

public class Bonus {
    private final int number;

    public Bonus(Lotto lotto, String inputBonusNumber) {
        BonusValidator.validate(lotto, inputBonusNumber);
        this.number = FormatUtils.stringToInteger(inputBonusNumber);
    }

    public int getBonusNumber() {
        return number;
    }

}
