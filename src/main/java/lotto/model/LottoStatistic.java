package lotto.model;

import static java.util.stream.Collectors.toMap;

import java.util.EnumMap;

public class LottoStatistic {

    private static final int INITIAL_COUNT = 0;
    private static final int RATE = 100;

    private final EnumMap<LottoPrize, Integer> prizeCounts;
    private final PurchaseAmount purchaseAmount;
    private long winningAmount = 0;

    public LottoStatistic(final PurchaseAmount purchaseAmount) {
        prizeCounts = new EnumMap<>(LottoPrize.class);
        initializePrizeCounts();
        this.purchaseAmount = purchaseAmount;
    }

    private void initializePrizeCounts() {
        prizeCounts.putAll(
                LottoPrize.stream()
                        .collect(toMap(key -> key, value -> INITIAL_COUNT))
        );
    }

    public void match(final Lottos lottos, final WinningNumbers winningNumbers) {
        lottos.stream()
                .map(winningNumbers::match)
                .map(LottoPrize::from)
                .forEach(this::add);
    }

    private void add(final LottoPrize prize) {
        prizeCounts.computeIfPresent(prize, (key, count) -> ++count);
        winningAmount += prize.getAmount();
    }

    public int getCountOf(final LottoPrize prize) {
        return prizeCounts.get(prize);
    }

    public double getEarningRate() {
        return (double) winningAmount / purchaseAmount.toInt() * RATE;
    }
}
