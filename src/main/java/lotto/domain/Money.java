package lotto.domain;

import static lotto.domain.LottoDetails.LOTTO_PRICE;
import static lotto.view.ErrorMessage.ERROR;

public class Money {

    private final int price;

    public Money(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public int getLottoCount() {
        return price / LOTTO_PRICE;
    }

    public String getPrice() {
        return String.valueOf(price);
    }
}
