package lotto.model;

import static lotto.Utils.convertStringToInt;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String bonusNumberInput) {
        this.bonusNumber = convertStringToInt(bonusNumberInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
