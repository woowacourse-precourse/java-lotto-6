package lotto.domain;

import static lotto.message.ErrorMessage.INVALID_DIVIDE_MONEY;
import static lotto.message.ErrorMessage.LOTTO_PRICE_UNABLE_ZERO;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new IllegalArgumentException(LOTTO_PRICE_UNABLE_ZERO.getMessage());
        }
    }

    private void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new IllegalArgumentException(INVALID_DIVIDE_MONEY.getMessage());
        }
    }

    public int getTicket() {
        return money / 1000;
    }
}
