package model;

import message.ErrorMessage;

public class LottoPrice {
    private final int price;

    public LottoPrice(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        validateZero(price);
        validateDivideMoney(price);
    }

    private void validateZero(int price) {
        if (price == 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PRICE_ZERO_ERROR);
        }
    }

    private void validateDivideMoney(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PRICE_DIVIDE_ERROR);
        }
    }

    public int lottoPaperCount() {
        return price / 1000;
    }

}