package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;

public class LottoPrice {
    private final int price;

    public LottoPrice(String price) {
        this.price = validate(validateIsIntPrice(price));
    }

    private int validateIsIntPrice(String price) {
        int priceNumber = 0;
        try {
            priceNumber = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.LOTTO_PRICE_MUST_BE_INTEGER);
        }
        return priceNumber;
    }

    private int validate(int price) {
        if (price < 1000) {
            throw new CustomException(ErrorMessage.LOTTO_PRICE_MUST_UP_1000);
        }
        if (price % 1000 != 0) {
            throw new CustomException(ErrorMessage.LOTTO_PRICE_MUST_MULTIPLY_1000);
        }
        return price;

    }

    public int getPrice() {
        return price;
    }
}
