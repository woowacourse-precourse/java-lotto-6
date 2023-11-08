package lotto.domain.amount;

import lotto.domain.lotto.LottoPrize;

public class TotalAmount extends Amount {

    protected TotalAmount(int amount) {
        super(amount);
    }

    public static TotalAmount initial() {
        return new TotalAmount(0);
    }

    public static TotalAmount from(int amount) {
        return new TotalAmount(amount);
    }

    public TotalAmount addLottoPrize(LottoPrize lottoPrize) {
        return new TotalAmount(this.amount + lottoPrize.prizeAmount());
    }

    public double dividedBy(PurchaseAmount purchaseAmount) {
        return (double) this.amount / purchaseAmount.amount;
    }
}
