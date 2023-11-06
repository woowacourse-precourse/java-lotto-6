package lotto.domain;

public class WinningYield {
    private Cash cash;
    private Profit profit;

    public WinningYield(Cash cash, Profit profit) {
        this.cash = cash;
        this.profit = profit;
    }

    public Double getYield() {
        Integer profitAmount = profit.getAmount();
        Integer cashAmount = cash.getAmount();

        double yield = (double) profitAmount / cashAmount * 100.0;

        return Double.parseDouble(String.format("%.1f", yield));
    }
}
