package lotto.domain;

public class TotalPrizeAmount {

    private long totalPrizeAmount;

    public TotalPrizeAmount() {
        this.totalPrizeAmount = 0;
    }

    public TotalPrizeAmount(long totalPrizeAmount) {
        this.totalPrizeAmount = totalPrizeAmount;
    }

    public void update(long prizeMoney) {
        totalPrizeAmount += prizeMoney;
    }

    public long getTotalPrizeAmount() {
        return totalPrizeAmount;
    }
}
