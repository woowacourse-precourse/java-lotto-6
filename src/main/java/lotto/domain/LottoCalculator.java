package lotto.domain;

public class LottoCalculator {

    public String getEarningsRate(Amount purchaseAmount, int winningAmount) {
        return roundOff(purchaseAmount.getAmount() / (double) winningAmount);
    }

    private String roundOff(double earningRate) {
        return String.format("%.2f", earningRate);
    }
}
