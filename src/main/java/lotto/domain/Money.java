package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import lotto.constant.message.ErrorMessage;

public class Money {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        validateMoneyMinimum(amount);
        validateMoneyUnit(amount);
    }

    private void validateMoneyMinimum(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MINIMUM_ERROR);
        }
    }

    private void validateMoneyUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR);
        }
    }
}
