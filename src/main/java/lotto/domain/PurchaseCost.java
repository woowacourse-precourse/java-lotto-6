package lotto.domain;

import lotto.util.message.ExceptionMessage;

public class PurchaseCost {

    private static final Double PERCENT = 100.0;

    private final Long money;

    public static PurchaseCost of(Long amount) {
        return new PurchaseCost(amount);
    }

    private PurchaseCost(Long money) {
        validateCostMultiple(money);
        validatePositiveNaturalNumber(money);
        this.money = money;
    }

    private void validateCostMultiple(Long value) {
        if (value % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_UNIT_PRICE.getMessage());
        }
    }

    private void validatePositiveNaturalNumber(Long value) {
        if (value < Lotto.PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_POSITIVE_NATURAL_NUMBER.getMessage());
        }
    }

    public Integer getPurchaseLottoAmount() {
        return Math.toIntExact(this.money / Lotto.PRICE);
    }

    public Double calcYieldBy(Long totalWinningPrize) {
        return totalWinningPrize * PERCENT / this.money;
    }
}
