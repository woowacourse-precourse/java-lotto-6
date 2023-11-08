package lotto.domain;

import lotto.domain.constant.LottoConstant;
import lotto.exception.lotto.LottoRangeException;

public class BonusNumber {
    private final int number;

    private BonusNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber of(final int number) {
        return new BonusNumber(number);
    }

    private void validate(final int number) {
        if (number < LottoConstant.MIN_NUMBER.getValue() || number > LottoConstant.MAX_NUMBER.getValue()) {
            throw new LottoRangeException();
        }
    }

    public int value() {
        return this.number;
    }
}
