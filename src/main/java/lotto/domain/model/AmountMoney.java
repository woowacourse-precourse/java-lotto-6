package lotto.domain;

import static lotto.utils.LottoEnum.LOTTO_PRICE;

import lotto.exception.lottoamountexception.BelowMinimumAmountException;
import lotto.exception.lottoamountexception.NotDivisibleByThousandException;

public class AmountMoney {
    private final int amount;

    public AmountMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE.getValue() != 0) {
            throw new NotDivisibleByThousandException();
        }
        if (amount <= 0) {
            throw new BelowMinimumAmountException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
