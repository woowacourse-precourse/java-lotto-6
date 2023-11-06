package lotto.model.input;

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
            throw new IllegalArgumentException();
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
