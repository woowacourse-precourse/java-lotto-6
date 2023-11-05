package lotto.domain;

import lotto.util.LottoConstants;

public class BonusNumber {
    private Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (isOutOfRangeNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRangeNumber(Integer number) {
        return number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue();
    }

    public Integer getNumber() {
        return number;
    }
}
