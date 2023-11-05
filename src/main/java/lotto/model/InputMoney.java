package lotto.model;

import lotto.util.InputNumber;

public class InputMoney extends InputNumber {
    InputMoney(String input) {
        super(input);
    }

    public static InputMoney getInstance(String input) {
        return new InputMoney(input);
    }

    @Override
    public Integer sendInputData() {
        return this.number % 1000;
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
