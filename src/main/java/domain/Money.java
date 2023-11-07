package domain;

import exception.InvalidUnitOfMoneyException;
import exception.NoMoneyException;

public class Money {
    private static final int ZERO = 0;
    private static final int UNIT = 1_000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateUnit(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new NoMoneyException();
        }
    }

    private void validateUnit(int inputValue) {
        if (inputValue % UNIT != ZERO) {
            throw new InvalidUnitOfMoneyException();
        }
    }

    public int getNumberOfLottoTicket() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
