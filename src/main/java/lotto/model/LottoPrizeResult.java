package lotto.model;

public class LottoPrizeResult {
    private long totalPrize;

    public LottoPrizeResult() {
        this.totalPrize = 0;
    }

    public void addTotalPrize(long prize) {
        this.totalPrize += prize;
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}
