package lotto.model;


public class ProfitCalculator {
    private static final double ROUNDING_SCALE = 10.0;
    private static final int PERCENTAGE = 100;

    public Double calculateProfit(Long properties, PurchaseAmount amount) {
        Integer purchaseAmount = exchangePurchaseAmount(amount);
        Double result = profitReport(properties, purchaseAmount);
        return roundedProfitRate(result);
    }

    private Double roundedProfitRate(Double result) {
        return Math.round(result * ROUNDING_SCALE) / ROUNDING_SCALE;
    }

    private Double profitReport(Long properties, int purchaseAmount) {
        return ((double) properties / purchaseAmount) * PERCENTAGE;
    }

    private Integer exchangePurchaseAmount(PurchaseAmount amount) {
        return amount.exchangePurchase();
    }
}
