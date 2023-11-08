package lotto.domain;


import lotto.exception.money.InputMoneyFormatException;
import lotto.exception.money.InputMoneyFormatZeroException;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int moneyInput;

    public Money(int moneyInput) {
        validate(moneyInput);
        this.moneyInput = moneyInput;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new InputMoneyFormatZeroException();
        }
    }

    private void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new InputMoneyFormatException();
        }
    }

    public int getLottosNumber() {
        return moneyInput / 1000;
    }
}
