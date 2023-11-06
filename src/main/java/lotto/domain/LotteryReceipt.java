package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.Iterator;
import java.util.List;
import java.util.stream.LongStream;

public class LotteryReceipt implements Iterable<PurchasedLottery> {
    private final List<PurchasedLottery> lotteries;

    public static LotteryReceipt createLotteryReceipt(LotteryOperator operator, long quantity, LottoRandom random) {
        return new LotteryReceipt(createPurchasedLotteries(operator, quantity, random));
    }

    public LotteryReceipt(List<PurchasedLottery> lotteries) {
        this.lotteries = lotteries;
    }

    private static List<PurchasedLottery> createPurchasedLotteries(LotteryOperator operator, long quantity,
                                                                   LottoRandom random) {
        return LongStream.range(0, quantity)
                .mapToObj(i -> PurchasedLottery.createLottery(operator, random))
                .collect(toList());
    }

    public long size() {
        return lotteries.size();
    }

    public List<PurchasedLottery> getLotteries() {
        return List.copyOf(lotteries);
    }

    public long getPurchasedAmount() {
        return LotteryOperator.LOTTO_PRICE * lotteries.size();
    }

    @Override
    public Iterator<PurchasedLottery> iterator() {
        return lotteries.listIterator();
    }
}
