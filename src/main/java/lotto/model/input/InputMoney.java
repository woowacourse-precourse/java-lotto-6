package lotto.model.input;

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
            throw new IllegalArgumentException();
        }

        if (notDivisibleByUnit()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNegative() {
        return this.number < 0;
    }

    private boolean notDivisibleByUnit() {
        return number % 1000 != 0;
    }
}
