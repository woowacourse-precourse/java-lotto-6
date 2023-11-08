package lotto.domain;

import static lotto.constants.DomainConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.DomainConstants.MIN_LOTTO_NUMBER;
import static lotto.exception.LottoException.BELOW_RANGE_LOTTO_NUMBER;
import static lotto.exception.LottoException.OVER_RANGE_LOTTO_NUMBER;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (isBelowRangeNumber()) {
            BELOW_RANGE_LOTTO_NUMBER.create();
        }
        if (isOverRangeNumber()) {
            OVER_RANGE_LOTTO_NUMBER.create();
        }
    }

    private boolean isBelowRangeNumber() {
        return this.number < MIN_LOTTO_NUMBER.getValue();
    }

    private boolean isOverRangeNumber() {
        return this.number > MAX_LOTTO_NUMBER.getValue();
    }

    public static BonusNumber create(final int number) {
        return new BonusNumber(number);
    }

    public int getNumber() {
        return this.number;
    }
}
