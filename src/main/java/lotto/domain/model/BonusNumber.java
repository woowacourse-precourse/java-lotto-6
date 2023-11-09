package lotto.domain.model;

import static lotto.domain.LottoEnum.LOTTO_END_NUMBER;
import static lotto.domain.LottoEnum.LOTTO_START_NUMBER;

import lotto.exception.lottonumbersexception.NumbersErrorMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_START_NUMBER.getValue() || number > LOTTO_END_NUMBER.getValue()) {
            throw NumbersErrorMessage.OUT_OF_NUMBERS_RANGE.getException();
        }
    }

    public int getNumber() {
        return number;
    }
}
