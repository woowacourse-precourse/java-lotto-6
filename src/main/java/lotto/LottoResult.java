package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> matchResults;
    private final double profitRate;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        matchResults = new EnumMap<>(Rank.class);
        int totalPrize = 0;
        int purchaseAmount = lottos.size() * LottoMachine.getLottoPrice();

        for (Lotto lotto : lottos) {
            Rank rank = Rank.calculateRank(lotto, winningLotto, bonusNumber);
            matchResults.merge(rank, 1, Integer::sum);
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