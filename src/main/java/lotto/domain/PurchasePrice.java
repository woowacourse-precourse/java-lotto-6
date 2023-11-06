package lotto.domain;

import lotto.util.ExceptionMessage;

public class PurchasePrice {

    private final Long money;

    public static PurchasePrice of(Long amount) {
        return new PurchasePrice(amount);
    }

    private PurchasePrice(Long money) {
        validatePrice(money);
        this.money = money;
    }

    private void validatePrice(Long amount) {
        if (amount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_UNIT_PRICE.getMessage());
        }
    }

    public Long getPurchaseLottoAmount() {
        return this.money / Lotto.PRICE;
    }
}
