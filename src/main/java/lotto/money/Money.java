package lotto.money;

import static lotto.message.ErrorMessage.ERROR_INPUT_MONEY;

public class Money {

    private int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if ((value % 1000) != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY);
        }
    }

    public int getAmount() {
        return value;
    }

    public int divideBy(int value) {
        return this.value / value;
    }

}
