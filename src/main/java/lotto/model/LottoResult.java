package lotto.model;

import java.util.Map;

public class LottoResult {
    private final MatchResult matchResult;
    private final Reward reward;
    private final RateOfReturn rateOfReturn;

    private LottoResult(MatchResult matchResult, Reward reward, RateOfReturn rateOfReturn) {
        this.matchResult = matchResult;
        this.reward = reward;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoResult getResultFrom(
            Lottos lottos, WinningNumbers winningNumbers, PurchaseAmount purchaseAmount) {
        MatchResult matchResult = MatchResult.calculateMatchResults(lottos, winningNumbers);
        Reward reward = Reward.win(matchResult);
        RateOfReturn rateOfReturn = RateOfReturn.calculate(reward.getAmount(), purchaseAmount.getPurchaseAmount());

        return new LottoResult(matchResult, reward, rateOfReturn);
    }

    public Map<LottoRank, Integer> getMatchResult() {
        return matchResult.getMatchResult();
    }

    public double getRateOfReturn() {
        return rateOfReturn.getRate();
    }
}
