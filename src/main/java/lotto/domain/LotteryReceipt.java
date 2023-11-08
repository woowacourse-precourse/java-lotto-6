package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.LongStream;

public class LotteryReceipt implements Iterable<PurchasedLottery> {
    private static final int MIN_SIZE = 1;
    private final List<PurchasedLottery> lotteries;
    private final LotteryOperator operator;

    public LotteryReceipt(List<PurchasedLottery> lotteries, LotteryOperator operator) {
        this.lotteries = lotteries;
        this.operator = Objects.requireNonNull(operator);
    }

    public static LotteryReceipt createLotteryReceipt(LotteryOperator operator, long quantity, LottoRandom random) {
        if (quantity < MIN_SIZE) {
            throw new IllegalArgumentException();
        }
        return new LotteryReceipt(createPurchasedLotteries(operator, quantity, random), operator);
    }

    private static List<PurchasedLottery> createPurchasedLotteries(LotteryOperator operator, long quantity,
                                                                   LottoRandom random) {
        return LongStream.range(0, quantity)
                .mapToObj(i -> PurchasedLottery.createLottery(operator.currentRound(), random))
                .collect(toList());
    }

    public List<PurchasedLottery> getLotteries() {
        return List.copyOf(lotteries);
    }

    public long getPurchasedAmount() {
        return operator.getLotteryPrice() * lotteries.size();
    }

    public long size() {
        return lotteries.size();
    }

    @Override
    public Iterator<PurchasedLottery> iterator() {
        return lotteries.listIterator();
    }
}
