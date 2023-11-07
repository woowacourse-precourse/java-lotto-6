package lotto.domain;

import lotto.message.LottoBonusErrorMessage;

public class Bonus {
    private int number;

    public Bonus(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LottoBonusErrorMessage.OUT_RANGE_ERROR.getMessage());
        }
    }
}
