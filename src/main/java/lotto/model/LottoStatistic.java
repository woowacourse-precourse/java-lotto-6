package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;

public class LottoStatistic {

    private static final int INITIAL_COUNT = 0;

    private final EnumMap<LottoPrize, Integer> prizeCounts;
    private long winningAmount = 0;

    private LottoStatistic() {
        prizeCounts = new EnumMap<>(LottoPrize.class);
        Arrays.stream(LottoPrize.values()).forEach(prize -> prizeCounts.put(prize, INITIAL_COUNT));
    }

    public static LottoStatistic create() {
        return new LottoStatistic();
    }

    public void add(final LottoPrize prize) {
        prizeCounts.compute(prize, (key, count) -> ++count);
        winningAmount += prize.getAmount();
    }

    public int getCountOf(final LottoPrize prize) {
        return prizeCounts.get(prize);
    }

    public double getEarningRate(final PurchaseAmount amount) {
        return (double) winningAmount / amount.toInt();
    }
}
