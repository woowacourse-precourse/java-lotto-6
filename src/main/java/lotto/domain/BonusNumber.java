package lotto.domain;

import static lotto.utils.validator.LottoNumberValidator.validateOutOfRange;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateOutOfRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean hasBonus(Containable numbers) {
        return numbers.contains(bonusNumber);
    }
}
