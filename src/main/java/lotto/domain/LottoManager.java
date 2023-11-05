package lotto.domain;

import java.util.List;

public class LottoManager {

    private final WinningDetails winningDetails;
    private final ProfitRateCalculator profitRateCalculator;

    public LottoManager(WinningDetails winningDetails, ProfitRateCalculator profitRateCalculator) {
        this.winningDetails = winningDetails;
        this.profitRateCalculator = profitRateCalculator;
    }

    public void addRankToWinningDetails(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            winningDetails.addRank(winningNumbers.determineRank(lotto));
        }
    }

    public String getWinningDetailsToString() {
        return winningDetails.toString();
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        return profitRateCalculator.calculate(purchaseAmount.getAmount(), calculateTotalReward());
    }

    private long calculateTotalReward() {
        return winningDetails.getTotalReward();
    }
}
