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

        double yield = calculateYield(profitAmount, cashAmount);

        return formatYield(yield);
    }

    private double calculateYield(Integer profitAmount, Integer cashAmount) {
        return (double) profitAmount / cashAmount * 100.0;
    }

    private Double formatYield(double yield) {
        return Double.parseDouble(String.format("%.1f", yield));
    }
}
