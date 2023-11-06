package lotto.domain;

import lotto.exception.lottonumbersexception.OutOfNumbersRangeException;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new OutOfNumbersRangeException();
        }
    }

    public int getNumber() {
        return number;
    }
}
