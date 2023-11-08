package lotto.domain.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public enum LottoPrice {
    ONE(1_000);

    private final int price;

    LottoPrice(final int price) {
        validatePositivePrice(price);
        this.price = price;
    }

    private void validatePositivePrice(final int price) {
        if (price < 0) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_PRICE_NEGATIVE);
        }
    }

    public int getPrice() {
        return price;
    }
}
