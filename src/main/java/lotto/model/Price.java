package lotto.model;

import lotto.constant.ValidateMessage;

public class Price {
    private final int price;
    private final int count;

    public Price(int price) {
        isDIVIDEDBy1000(price);
        this.price = price;
        this.count = price / 1000;
    }

    private void isDIVIDEDBy1000(int price) {
        if (price % 1000 != 0) {
            ValidateMessage.PRICE_IS_NOT_DIVIDED_1000.throwException();
        }
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
