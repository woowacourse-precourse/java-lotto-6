package lotto.model;

import lotto.util.ExceptionUtils;

import static lotto.model.Constant.*;
public class LottoPrice {
    private final int price;

    public LottoPrice(int price) {
        validateUnitPrice(price);
        validateMinPrice(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validateMinPrice(int price) {
        if (price < LOTTO_MIN_PRICE) {
            throw new IllegalArgumentException(ExceptionUtils.LOTTO_MIN_PRICE_ERROR.getErrorMessage());
        }
    }

    private void validateUnitPrice(int price) {
        if (price % LOTTO_MIN_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionUtils.LOTTO_UNIT_ERROR.getErrorMessage());
        }
    }
}
