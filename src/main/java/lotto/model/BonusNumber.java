package lotto.model;

import static lotto.validator.Validation.*;

public class BonusNumber {
    private final int number;
    private final Lotto lotto;

    public BonusNumber(String number, Lotto lotto) {
        validate(number, lotto);
        this.number = Integer.parseInt(number);
        this.lotto = lotto;
    }

    private void validate(String number, Lotto lotto) {
        checkEnter(number);
        checkDigit(number);
        checkInRange(number);
        checkExistBonus(Integer.parseInt(number), lotto);
    }

    public int getNumber() {
        return number;
    }

}
