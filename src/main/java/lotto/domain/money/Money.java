package lotto.domain.money;

import lotto.exception.NotEnoughMoneyException;
import lotto.exception.NotMultipleOfLottoPriceException;

public class Money {
    private final int LOTTO_PRICE = 1_000;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new NotEnoughMoneyException();
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new NotMultipleOfLottoPriceException();
        }
    }

    public int ticketCount() {
        return amount / LOTTO_PRICE;
    }
}
