package lotto.domain;

import static lotto.view.constants.ConsoleMessage.PURCHASE_AMOUNT_ERROR;

public class Price {

    private static final int LOTTO_PRICE_UNIT = 1_000;
    private static final int ZERO = 0;

    private final Integer amount;

    private Price(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Price of(Integer amount) {
        return new Price(amount);
    }

    public int receiveIssuedLottoCount() {
        return amount / LOTTO_PRICE_UNIT;
    }

    private void validate(Integer price) {
        if (price <= ZERO || price % LOTTO_PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR.getMessage());
        }
    }
}
