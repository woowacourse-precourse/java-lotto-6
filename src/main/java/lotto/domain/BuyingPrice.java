package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;

public class BuyingPrice {
    private static final int CORRECT_DIVISION = 0;
    private static final int LOTTO_PRICE = LottoConfig.PRICE.value();

    private final int price;

    public BuyingPrice(int buyingPrice) {
        validateRange(buyingPrice);
        validateDivision(buyingPrice);
        this.price = buyingPrice;
    }

    public int getTryCount() {
        return price / LOTTO_PRICE;
    }

    private void validateRange(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PRICE_RANGE.message());
        }
    }

    private void validateDivision(int price) {
        if (price % LOTTO_PRICE != CORRECT_DIVISION) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PRICE_DIVISION.message());
        }
    }
}
