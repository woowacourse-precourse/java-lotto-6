package lotto.domain.lotto;

import static lotto.message.ErrorMessage.INVALID_LOTTO_MONEY;
import static lotto.message.ErrorMessage.AMOUNT_LESS_THAN_ZERO;

public class Cash {
    private final long cash;

    public Cash(long cash) {
        validatePositiveNumber(cash);
        this.cash = cash;
    }

    private void validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(AMOUNT_LESS_THAN_ZERO.getMessage());
        }
    }

    public boolean isPurchaseLottoPossible(int price) {
        return cash % price == 0;
    }

    public long countPurchasableItems(int price) {
        if (!isPurchaseLottoPossible(price)){
            throw new IllegalArgumentException(INVALID_LOTTO_MONEY.getMessage());
        }
        return cash / price;
    }

    public long getCash() {
        return cash;
    }
}
