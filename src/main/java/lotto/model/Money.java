package lotto.model;

import lotto.view.ErrorMessage;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    public int getCount() {
        return value / LOTTO_PRICE;
    }

    private void validate(int value) {
        if(value % LOTTO_PRICE != 0) {
            ErrorMessage.printMoneyFormatError();
            throw new IllegalArgumentException();
        }
    }
}
