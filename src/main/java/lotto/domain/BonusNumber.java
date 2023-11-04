package lotto.domain;

import static lotto.constants.Condition.MAXIMUM_VALUE;
import static lotto.constants.Condition.MINIMUM_VALUE;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if(number <= MINIMUM_VALUE || number >= MAXIMUM_VALUE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }
}
