package lotto.domain;

import static lotto.constants.Constants.Integers.INTEGER_ZERO;

public class TotalPrizeAmount {

    private long totalPrizeAmount;

    public TotalPrizeAmount() {
        this.totalPrizeAmount = INTEGER_ZERO.getValue();
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
