package lotto.model;

import java.util.Map;

public class LottoResult {
    private final MatchResult matchResult;
    private final RateOfReturn rateOfReturn;

    private LottoResult(MatchResult matchResult, RateOfReturn rateOfReturn) {
        this.matchResult = matchResult;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoResult getResultFrom(
            Lottos lottos, WinningNumbers winningNumbers, PurchaseAmount purchaseAmount) {
        MatchResult matchResult = MatchResult.calculateMatchResults(lottos, winningNumbers);
        Reward reward = Reward.win(matchResult);
        RateOfReturn rateOfReturn = RateOfReturn.calculate(reward.amount(), purchaseAmount.getPurchaseAmount());

        return new LottoResult(matchResult, rateOfReturn);
    }

    public Map<LottoRank, Integer> getMatchResult() {
        return matchResult.getMatchResult();
    }

    public double getRateOfReturn() {
        return rateOfReturn.getRate();
    }

    private record Reward(int amount) {
        private static Reward win(MatchResult matchResult) {
            return new Reward(calculate(matchResult));
        }

        private static int calculate(MatchResult matchResult) {
            return matchResult.getMatchResult()
                    .entrySet()
                    .stream()
                    .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                    .sum();
        }
    }
}
