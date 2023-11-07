package lotto.domain.result;

public class CalculateResult {
    private int totalProfit;
    private float profitMargin;

    public CalculateResult(int totalProfit, float profitMargin) {
        this.totalProfit = totalProfit;
        this.profitMargin = profitMargin;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public float getProfitMargin() {
        return profitMargin;
    }
}
