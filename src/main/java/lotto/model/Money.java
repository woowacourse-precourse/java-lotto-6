package lotto.model;

import static lotto.constants.LottoInformation.PRICE;

public class Money {

    private final int price;

    public Money(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price % PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfLotto() {
        return price / PRICE;
    }

    public int getPrice() {
        return price;
    }
}
