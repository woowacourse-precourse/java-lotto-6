package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;
import lotto.util.LottoConstants;

public class BonusNumber {
    private Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (isOutOfRangeNumber(number)) {
            throw new LottoGameException(ErrorMessage.OUT_OF_RANGE);
        }
    }

    private boolean isOutOfRangeNumber(Integer number) {
        return number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue();
    }

    public Integer getNumber() {
        return number;
    }
}
