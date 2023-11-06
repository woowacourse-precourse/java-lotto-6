package lotto.domain;

import static lotto.constants.Condition.MAXIMUM_VALUE;
import static lotto.constants.Condition.MINIMUM_VALUE;
import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import lotto.utility.validation.LottoNumberChecker;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        LottoNumberChecker.validate(number);
    }

    public boolean contained(Lotto lotto) {
        return lotto.contains(number);
    }
}
