package lotto.domain;

import static lotto.view.ErrorMessage.printMoneyFormatError;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    public int calculateCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if(value % LOTTO_PRICE != 0) {
            printMoneyFormatError();
            throw new IllegalArgumentException();
        }
    }
}
