package lotto.domain;

import static lotto.constants.ErrorConstants.INDIVISIBLE_BUY_AMOUNT_ERROR_MESSAGE;
import static lotto.constants.ErrorConstants.MINIMUM_BUY_AMOUNT_ERROR_MESSAGE;
import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.MIN_LOTTO_BUY_QUANTITY;

import lotto.domain.dto.OrderResultDto;

public class Order {
    private final int quantity;
    private final int buyAmount;

    private Order(int buyAmount) {
        validate(buyAmount);
        this.buyAmount = buyAmount;
        this.quantity = buyAmount / LOTTO_PRICE.getValue();
    }

    public static Order create(int buyAmount) {
        return new Order(buyAmount);
    }

    private boolean isBuyAmountIndivisible(int amount) {
        return amount % LOTTO_PRICE.getValue() != 0;
    }

    private boolean isQuantityLessThanMinimum(int amount) {
        return amount / LOTTO_PRICE.getValue() < MIN_LOTTO_BUY_QUANTITY.getValue();
    }

    private void validate(int amount) {
        if (isBuyAmountIndivisible(amount)) {
            throw new IllegalArgumentException(
                    String.format(INDIVISIBLE_BUY_AMOUNT_ERROR_MESSAGE.getMessage(), LOTTO_PRICE.getValue()));
        }
        if (isQuantityLessThanMinimum(amount)) {
            throw new IllegalArgumentException(
                    String.format(MINIMUM_BUY_AMOUNT_ERROR_MESSAGE.getMessage(), MIN_LOTTO_BUY_QUANTITY.getValue()));
        }
    }

    public OrderResultDto getOrderResultDto(Lottos lottos) {
        return new OrderResultDto(quantity, lottos.getLottos());
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBuyAmount() {
        return buyAmount;
    }
}
