package lotto.domain.model;

import static lotto.domain.LottoEnum.LOTTO_PRICE;

import lotto.exception.lottoamountexception.AmountErrorMessage;

public class AmountMoney {
    private final int amount;

    public AmountMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw AmountErrorMessage.BELOW_MINIMUM_AMOUNT.getException();
        }
        if (amount % LOTTO_PRICE.getValue() != 0) {
            throw AmountErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.getException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
