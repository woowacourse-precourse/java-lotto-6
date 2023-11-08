package lotto.model.input;

import static lotto.util.constants.Numbers.LOTTO_PRICE;
import static lotto.util.exception.ErrorMessage.NONNEGATIVE_NUMBER;
import static lotto.util.exception.ErrorMessage.NOT_DIVISIBLE_BY_UNIT;

import lotto.util.exception.LottoException;
import lotto.util.input.InputNumber;

public class InputMoney extends InputNumber {
    InputMoney(final String input) {
        super(input);
    }

    public static InputMoney getInstance(final String input) {
        return new InputMoney(input);
    }

    @Override
    public Integer sendInputData() {
        return this.number;
    }

    @Override
    public void validate() {
        if (isNonNegative()) {
            throw LottoException.of(NONNEGATIVE_NUMBER);
        }

        if (notDivisibleByUnit()) {
            throw LottoException.of(NOT_DIVISIBLE_BY_UNIT);
        }
    }

    private boolean isNonNegative() {
        return this.number <= 0;
    }

    private boolean notDivisibleByUnit() {
        return number % LOTTO_PRICE.getNumber() != 0;
    }
}
