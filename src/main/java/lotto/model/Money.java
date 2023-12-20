package lotto.model;

import static lotto.constants.LottoDetails.LOTTO_PRICE;

public class Money {

    private final int price;

    public Money(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getNumbersOfLotto() {
        return price / LOTTO_PRICE;
    }

    public String getPrice() {
        return String.valueOf(price);
    }
}
