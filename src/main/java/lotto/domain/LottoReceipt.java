package lotto.domain;

import java.util.List;

public class LottoReceipt {
    private final List<Lotto> drawnLotteries;
    private final int lotteryCount;

    public LottoReceipt(List<Lotto> drawnLotteries) {
        this.drawnLotteries = drawnLotteries;
        this.lotteryCount = drawnLotteries.size();
    }

    public int getLotteryCount() {
        return lotteryCount;
    }
}
