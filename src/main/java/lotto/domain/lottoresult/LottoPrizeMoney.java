package lotto.domain.lottoresult;

import lotto.domain.player.Profit;

public class LottoPrizeMoney {
    private final static int HUNDRED_FOR_CALCULATE_PERCENTAGE = 100;
    private final double lottoPrizeMoney;

    private LottoPrizeMoney(double lottoPrizeMoney) {
        this.lottoPrizeMoney = lottoPrizeMoney;
    }

    public static LottoPrizeMoney makeZeroLottoPrizeMoney() {
        return new LottoPrizeMoney(0);
    }

    LottoPrizeMoney updateLottoPrizeMoney(LottoResult lottoResult) {
        return new LottoPrizeMoney(lottoPrizeMoney + lottoResult.getPrizeMoney());
    }

    public Profit calculateProfit(int usedMoney) {
        return new Profit(((lottoPrizeMoney / usedMoney) * HUNDRED_FOR_CALCULATE_PERCENTAGE));
    }
}
