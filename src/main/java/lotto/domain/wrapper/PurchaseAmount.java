package lotto.domain.wrapper;

import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstantValue;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        validateMoreThanZero(purchaseAmount);
        validateChangeNoRemaining(purchaseAmount);
        validateNotTooMuchPurchaseAmount(purchaseAmount);
    }

    private void validateMoreThanZero(int purchaseAmount) {
        if (purchaseAmount <= LottoConstantValue.NO_PURCHASE_AMOUNT.get()) {
            throw new IllegalArgumentException(ErrorMessage.NO_PURCHASE_AMOUNT.getWithPrefix());
        }
    }

    private void validateChangeNoRemaining(int purchaseAmount) {
        if ((purchaseAmount % LottoConstantValue.LOTTO_PRICE.get()) != LottoConstantValue.NO_REMAINING_CHANGE.get()) {
            throw new IllegalArgumentException(ErrorMessage.CHANGE_REMAINING.getWithPrefix());
        }
    }

    private void validateNotTooMuchPurchaseAmount(int purchaseAmount) {
        if ((purchaseAmount / LottoConstantValue.LOTTO_PRICE.get()) > LottoConstantValue.MAX_NUMBER_OF_LOTTOS.get()) {
            throw new IllegalArgumentException(ErrorMessage.TOO_MUCH_PURCHASE_AMOUNT.getWithFormatAndPrefix(
                    LottoConstantValue.MAX_NUMBER_OF_LOTTOS.get())
            );
        }
    }

    public int getAvailableLottoCount() {
        return purchaseAmount / LottoConstantValue.LOTTO_PRICE.get();
    }

    public double calculateProfitRate(long allPrizeProfit) {
        return (allPrizeProfit / (double) purchaseAmount) * LottoConstantValue.PERCENTAGE_MULTIPLIER.get();
    }
}
