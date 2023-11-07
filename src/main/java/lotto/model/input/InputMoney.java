package lotto.model.input;

import static lotto.util.exception.ErrorMessage.NEGATIVE_NUMBER;
import static lotto.util.exception.ErrorMessage.NOT_DIVISIBLE_BY_UNIT;

import lotto.util.exception.LottoException;
import lotto.util.input.InputNumber;

public class InputMoney extends InputNumber {
    InputMoney(String input) {
        super(input);
    }

    public static InputMoney getInstance(String input) {
        return new InputMoney(input);
    }

    @Override
    public Integer sendInputData() {
        return this.number;
    }

    public void validate() {
        if (isNegative()) {
            throw LottoException.of(NEGATIVE_NUMBER);
        }

        if (notDivisibleByUnit()) {
            throw LottoException.of(NOT_DIVISIBLE_BY_UNIT);
        }
    }

    private boolean isNegative() {
        return this.number < 0;
    }

    private boolean notDivisibleByUnit() {
        return number % 1000 != 0;
    }
}
