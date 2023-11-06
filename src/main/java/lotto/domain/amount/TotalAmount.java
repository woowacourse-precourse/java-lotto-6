package lotto.domain.amount;

import lotto.domain.enums.LottoPrize;

public class TotalAmount extends Amount {

    protected TotalAmount(int amount) {
        super(amount);
    }

    public static TotalAmount initial() {
        return new TotalAmount(0);
    }

    public TotalAmount addLottoPrize(LottoPrize lottoPrize) {
        return new TotalAmount(this.amount + lottoPrize.getPrizeAmount());
    }
}
