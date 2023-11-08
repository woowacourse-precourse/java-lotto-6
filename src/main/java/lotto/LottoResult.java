package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> matchResults;
    private final double profitRate;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        matchResults = new HashMap<>();
        int totalPrize = 0;
        int purchaseAmount = lottos.size() * LottoMachine.getLottoPrice();

        for (Lotto lotto : lottos) {
            Rank rank = Rank.findRank(lotto, winningLotto, bonusNumber);
            matchResults.put(rank, matchResults.getOrDefault(rank, 0) + 1);
            totalPrize += rank.getPrize();
        }

        this.profitRate = (double) totalPrize / purchaseAmount * 100;
    }

    public Map<Rank, Integer> getMatchResults() {
        return matchResults;
    }

    public double getProfitRate() {
        return profitRate;
    }
}