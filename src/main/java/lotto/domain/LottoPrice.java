package lotto.domain;

import lotto.utils.Message;

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
            throw new IllegalArgumentException(Message.INPUT_INTERGER_ERROR.getMessage());
        }
        return priceNumber;
    }

    private int validate(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(Message.NOT_ENOUGH_PRICE_ERROR.getMessage());
        } else if (price % 1000 != 0) {
            throw new IllegalArgumentException(Message.MULTIPLE_PRICE_ERROR.getMessage());
        }
        return price;
    }

    public int getPrice() {
        return price;
    }
}
