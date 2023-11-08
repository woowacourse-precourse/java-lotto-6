package lotto.model;

import lotto.constant.ErrorMessage;

public class BonusNumber {
    private final int number;

    private BonusNumber() {
        this.number = 0;
    }

    private BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber of(int number) {
        return new BonusNumber(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < Lotto.LOTTO_NUMBER_MIN || bonusNumber > Lotto.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
