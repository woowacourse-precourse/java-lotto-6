package lotto.model;

import lotto.LottoResult;

public class ProfitStats {
    private int profit;
    private double rate;

    public ProfitStats(int profit, double rate) {
        this.profit = profit;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
