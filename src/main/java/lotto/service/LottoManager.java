package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningDetails;
import lotto.domain.winningLotto.WinningLotto;

public class LottoManager {

    private final LottoIssuer lottoIssuer;
    private final WinningDetails winningDetails;
    private final ProfitRateCalculator profitRateCalculator;

    public LottoManager(LottoIssuer lottoIssuer, WinningDetails winningDetails, ProfitRateCalculator profitRateCalculator) {
        this.lottoIssuer = lottoIssuer;
        this.winningDetails = winningDetails;
        this.profitRateCalculator = profitRateCalculator;
    }

    public List<Lotto> issueLotto(PurchaseAmount purchaseAmount) {
        return lottoIssuer.issue(purchaseAmount);
    }

    public void addRankToWinningDetails(List<Lotto> lottos, WinningLotto winningLotto) {
        lottos.stream()
                .map(winningLotto::determineRank)
                .forEach(winningDetails::addRank);
    }

    public String getWinningDetailsToString() {
        return winningDetails.toString();
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        return profitRateCalculator.calculate(purchaseAmount.amount(), calculateTotalReward());
    }

    private long calculateTotalReward() {
        return winningDetails.getTotalReward();
    }
}
