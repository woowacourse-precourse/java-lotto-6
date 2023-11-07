package lotto.model.input;

import static lotto.util.exception.ErrorMessage.INVALID_LOTTO_NUMBER;

import lotto.util.exception.LottoException;
import lotto.util.input.InputNumber;

public class InputBonusNumber extends InputNumber {
    InputBonusNumber(String input) {
        super(input);
    }

    public static InputBonusNumber getInstance(String input) {
        return new InputBonusNumber(input);
    }

    public void validate() {
        if (notLottoNumber()) {
            throw LottoException.of(INVALID_LOTTO_NUMBER);
        }
    }

    @Override
    public Integer sendInputData() {
        return this.number;
    }

    private boolean notLottoNumber() {
        return this.number < 1 || this.number > 45;
    }
}
