package lotto.domain;

public class TotalPrizeAmount {

    private long totalPrizeAmount;

    public TotalPrizeAmount() {
        this.totalPrizeAmount = 0;
    }

    public void update(long prizeMoney) {
        totalPrizeAmount += prizeMoney;
    }
}
