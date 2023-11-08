package lotto.domain;

import lotto.util.message.ExceptionMessage;

public class PurchasePrice {

    private static final Double PERCENT = 100.0;

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

    public Integer getPurchaseLottoAmount() {
        return Math.toIntExact(this.money / Lotto.PRICE);
    }

    public Double calcYieldBy(Long totalWinningPrize) {
        return totalWinningPrize * PERCENT / this.money;
    }
}
