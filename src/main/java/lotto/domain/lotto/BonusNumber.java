package lotto.domain.lotto;

import static lotto.domain.lotto.LottoRule.*;

import lotto.domain.message.ErrorMessage;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_MIN_NUMBER_INCLUSION.getValue()
                || number > LOTTO_MAX_NUMBER_INCLUSION.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBER_RANGE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    public boolean hasSameNumber(int number) {
        return this.number == number;
    }
}
