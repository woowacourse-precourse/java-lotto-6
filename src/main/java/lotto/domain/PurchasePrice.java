package lotto.domain;

import lotto.util.ExceptionMessage;

public class PurchasePrice {

    private final Integer money;

    public static PurchasePrice of(Integer amount) {
        return new PurchasePrice(amount);
    }

    public int getPurchaseLottoAmount() {
        return this.money / Lotto.PRICE;
    }

    private PurchasePrice(Integer money) {
        validateAmount(money);
        this.money = money;
    }

    private void validateAmount(Integer amount) {
        if (amount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_UNIT_PRICE.getMessage());
        }
    }
}
