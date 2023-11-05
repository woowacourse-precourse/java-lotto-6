package lotto.domain;

import static lotto.view.constants.ConsoleMessage.PURCHASE_AMOUNT_ERROR;

public class Purchase {

    private static final int LOTTO_PRICE_UNIT = 1_000;
    private static final int ZERO = 0;

    private final Integer amount;

    private Purchase(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Purchase of(Integer amount) {
        return new Purchase(amount);
    }

    public int receiveIssuedLottoCount() {
        return amount / LOTTO_PRICE_UNIT;
    }

    private void validate(Integer amount) {
        if (amount < LOTTO_PRICE_UNIT || amount % LOTTO_PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR.getMessage());
        }
    }
}
