package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.LongStream;

public class LotteryReceipt {
    private final List<PurchasedLottery> lotteries;

    public static LotteryReceipt createLotteryReceipt(long quantity, LottoRandom random) {
        return new LotteryReceipt(createPurchasedLotteries(quantity, random));
    }

    public LotteryReceipt(List<PurchasedLottery> lotteries) {
        this.lotteries = lotteries;
    }

    private static List<PurchasedLottery> createPurchasedLotteries(long quantity, LottoRandom random) {
        return LongStream.range(0, quantity)
                .mapToObj(i -> PurchasedLottery.createLottery(random))
                .collect(toList());
    }

    public long size() {
        return lotteries.size();
    }

    public List<PurchasedLottery> getLotteries() {
        return List.copyOf(lotteries);
    }
}
