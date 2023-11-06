package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.domain.LottoConstants.MIN_LOTTO_BUY_AMOUNT;
import static lotto.view.ErrorConstants.INDIVISIBLE_BUY_AMOUNT_ERROR_MESSAGE;
import static lotto.view.ErrorConstants.MINIMUM_BUY_AMOUNT_ERROR_MESSAGE;

public class Order {
    private final int quantity;

    private Order(int buyAmount) {
        validate(buyAmount);
        this.quantity = buyAmount / LOTTO_PRICE.getValue();
    }

    public static Order create(int buyAmount) {
        return new Order(buyAmount);
    }

    private boolean isBuyAmountIndivisible(int amount) {
        return amount % LOTTO_PRICE.getValue() != 0;
    }

    private boolean isQuantityLessThanMinimum(int amount) {
        return amount / LOTTO_PRICE.getValue() < MIN_LOTTO_BUY_AMOUNT.getValue();
    }

    private void validate(int amount) {
        if (isBuyAmountIndivisible(amount)) {
            throw new IllegalArgumentException(
                    String.format(INDIVISIBLE_BUY_AMOUNT_ERROR_MESSAGE.getMessage(), LOTTO_PRICE.getValue()));
        }
        if (isQuantityLessThanMinimum(amount)) {
            throw new IllegalArgumentException(
                    String.format(MINIMUM_BUY_AMOUNT_ERROR_MESSAGE.getMessage(), MIN_LOTTO_BUY_AMOUNT.getValue()));
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
