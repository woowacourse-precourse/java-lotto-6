package lotto.domain;

import java.util.List;

public class LotteryShop {
    private final LotteryPapers lotteryPapers;

    private LotteryShop(LotteryPapers lotteryPapers) {
        this.lotteryPapers = lotteryPapers;
    }


    public static LotteryShop buyLotteryFrom(Money money) {
        long lotteryCount = money.getLotteryCount();

        LotteryPapers lotteryPapers = LotteryPapers.createLotteryFrom(lotteryCount);

        return new LotteryShop(lotteryPapers);
    }

    public List<List<Integer>> getLotteryPapers() {
        return lotteryPapers.getLottoNumber();
    }
}
