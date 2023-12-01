package lotto.domain;

import lotto.exception.ExceptionCode;
import lotto.utils.vadliator.Validator;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number, Lotto winningLotto) {
        validate(number, winningLotto);
        this.number = number;
    }

    private void validate(int number, Lotto winningLotto) {
        ExceptionCode e = ExceptionCode.INVALID_BONUS_NUMBER;

        Validator.isValidRange(
                number,
                Lotto.END_NUMBER,
                Lotto.START_NUMBER,
                e
        );
        Validator.notContains(number, winningLotto.getNumbers(), e);
    }

    public int getNumber() {
        return number;
    }
}
