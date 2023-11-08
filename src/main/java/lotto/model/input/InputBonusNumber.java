package lotto.model.input;

import static lotto.util.constants.Numbers.MAXIMUM_LOTTO_NUMBER;
import static lotto.util.constants.Numbers.MINIMUM_LOTTO_NUMBER;
import static lotto.util.exception.ErrorMessage.INVALID_LOTTO_NUMBER;

import lotto.util.exception.LottoException;
import lotto.util.input.InputNumber;

public class InputBonusNumber extends InputNumber {
    InputBonusNumber(final String input) {
        super(input);
    }

    public static InputBonusNumber getInstance(final String input) {
        return new InputBonusNumber(input);
    }

    @Override
    public Integer sendInputData() {
        return this.number;
    }

    @Override
    public void validate() {
        if (notLottoNumber()) {
            throw LottoException.of(INVALID_LOTTO_NUMBER);
        }
    }

    private boolean notLottoNumber() {
        return this.number < MINIMUM_LOTTO_NUMBER.getNumber() || this.number > MAXIMUM_LOTTO_NUMBER.getNumber();
    }
}
