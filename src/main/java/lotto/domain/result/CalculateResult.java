package lotto.domain.result;

public class CalculateResult {
    private final int totalProfit;
    private final float profitMargin;

    public CalculateResult(int totalProfit, float profitMargin) {
        this.totalProfit = totalProfit;
        this.profitMargin = profitMargin;
    }
    
    public float getProfitMargin() {
        return profitMargin;
    }
}
