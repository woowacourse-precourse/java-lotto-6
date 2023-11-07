package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.Iterator;
import java.util.List;
import java.util.stream.LongStream;

public class LotteryReceipt implements Iterable<PurchasedLottery> {
    private final List<PurchasedLottery> lotteries;
    private final LotteryOperator operator;

    public static LotteryReceipt createLotteryReceipt(LotteryOperator operator, long quantity, LottoRandom random) {
        return new LotteryReceipt(createPurchasedLotteries(operator, quantity, random), operator);
    }

    public LotteryReceipt(List<PurchasedLottery> lotteries, LotteryOperator operator) {
        this.lotteries = lotteries;
        this.operator = operator;
    }

    private static List<PurchasedLottery> createPurchasedLotteries(LotteryOperator operator, long quantity,
                                                                   LottoRandom random) {
        return LongStream.range(0, quantity)
                .mapToObj(i -> PurchasedLottery.createLottery(operator.currentRound(), random))
                .collect(toList());
    }

    public long size() {
        return lotteries.size();
    }

    public List<PurchasedLottery> getLotteries() {
        return List.copyOf(lotteries);
    }

    public long getPurchasedAmount() {
        return operator.getLotteryPrice() * lotteries.size();
    }

    @Override
    public Iterator<PurchasedLottery> iterator() {
        return lotteries.listIterator();
    }
}
