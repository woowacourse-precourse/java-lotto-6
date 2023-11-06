package lotto.domain.wrapper;

import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstantValue;

public class PurchaseAmount {
    private static final int NO_MONEY = 0;
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        validateMoreThanZero(purchaseAmount);
        validateChangeNoRemaining(purchaseAmount);
    }

    private void validateMoreThanZero(int purchaseAmount) {
        if (purchaseAmount <= NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.NO_MONEY.getWithPrefix());
        }
    }

    private void validateChangeNoRemaining(int purchaseAmount) {
        if (purchaseAmount % LottoConstantValue.LOTTO_PRICE.get() != NO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.CHANGE_REMAINED.getWithPrefix());
        }
    }

    public int getAvailableLottoCount() {
        return purchaseAmount / LottoConstantValue.LOTTO_PRICE.get();
    }

    public double calculateProfitRate(long allPrizeProfit) {
        return (allPrizeProfit / (double) purchaseAmount) * PERCENTAGE_MULTIPLIER;
    }
}
