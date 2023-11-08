package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;

public class WinningService {

    public Map<LottoRank, Integer> calculateResults(List<Lotto> lottos,
            WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank rank = determineRank(lotto, winningNumbers);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }

    public LottoRank determineRank(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.matchCount(lotto);
        boolean matchBonusNumber = winningNumbers.matchBonusNumber(lotto);
        return LottoRank.valueOf(matchCount, matchBonusNumber);
    }

    public int calculateTotalPrize(Map<LottoRank, Integer> results) {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateYield(int purchaseAmount, int totalPrize) {
        return (double) totalPrize / purchaseAmount;
    }
}
