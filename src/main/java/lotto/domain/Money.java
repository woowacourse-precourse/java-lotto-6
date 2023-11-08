package lotto.domain;

import lotto.error.InvalidPurchaseException;
import lotto.view.ErrorMessage;

public class Money {
    public static final Integer UNIT = 1000;

    private final Integer amount;

    public Money(Integer amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(Integer amount) {
        isNegative(amount);
        isValidUnit(amount);
    }

    private void isNegative(Integer amount) {
        if (amount < 0) {
            throw new InvalidPurchaseException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }

    private void isValidUnit(Integer amount) {
        if (amount % UNIT != 0) {
            throw new InvalidPurchaseException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }
    public Boolean isBiggerThan(Money money) {
        return this.amount >= money.amount;
    }

    public Integer divide(Money dividendMoney) {
        if(amount < dividendMoney.amount) {
            throw new IllegalArgumentException();
        }
        return dividendMoney.amount / this.amount;
    }
}