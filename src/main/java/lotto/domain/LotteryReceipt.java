package lotto.domain;

import java.util.List;

public class LotteryReceipt {
    private final List<PurchasedLottery> lotteries;

    public LotteryReceipt(List<PurchasedLottery> lotteries) {
        this.lotteries = lotteries;
    }
    public long size(){
        return lotteries.size();
    }
}
