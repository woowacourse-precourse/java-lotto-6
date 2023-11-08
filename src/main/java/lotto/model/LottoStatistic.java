package lotto.model;

public class LottoStatistic {

    public static final int RATE = 100;

    private final LottoPrizeCount prizeCounts;
    private final double earningRate;

    private LottoStatistic(final LottoPrizeCount prizeCount, final double earningRate) {
        this.prizeCounts = prizeCount;
        this.earningRate = earningRate;
    }

    public static LottoStatistic of(final LottoPrizeCount prizeCount, final double earningRate) {
        return new LottoStatistic(prizeCount, earningRate);
    }

    public int getCountOf(final LottoPrize prize) {
        return prizeCounts.getCountOf(prize);
    }

    public double getEarningRate() {
        return earningRate;
    }
}
