package lotto.model;

public class RateOfReturn {
    private final double rateOfReturn;

    public RateOfReturn(Money money, WinningResult winningResult) {
        this.rateOfReturn = (double) calculateWinningMoney(winningResult) / money.getLottoCount() * 0.1;
    }

    private int calculateWinningMoney(WinningResult winningResult) {
        int result = 0;

        for (WinningStandard standard : WinningStandard.values()) {
            result += winningResult.getWinningResult().get(standard) * standard.getWinningAmount();
        }
        return result;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
