package lotto.domain;

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
