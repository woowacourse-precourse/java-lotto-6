package model;

import exception.NonPositiveMoneyException;
import exception.WrongMoneyUnitException;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateNonPositiveMoney(money);
        validateMoneyUnit(money);
    }

    private void validateNonPositiveMoney(int money) {
        if (money <= 0) {
            throw new NonPositiveMoneyException();
        }
    }

    private void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new WrongMoneyUnitException();
        }
    }

    public int getLottoTicketCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
