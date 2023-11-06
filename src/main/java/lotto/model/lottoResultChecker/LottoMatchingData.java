package lotto.model.lottoResultChecker;

import lotto.model.lottoGenerator.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatchingData {
    private final Map<LottoRank, Integer> resultCounts = new HashMap<>();

    public void addResult(int matchCount, boolean bonusMatch) {
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
        resultCounts.put(rank, resultCounts.getOrDefault(rank, 0) + 1);
    }

    public int getCountForRank(LottoRank rank) {
        return resultCounts.getOrDefault(rank, 0);
    }
    public void matchLottoToWinningNumbers(List<Lotto> lotto, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto singleLotto : lotto) {
            int matchCount = (int) singleLotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = singleLotto.getNumbers().contains(bonusNumber);
            addResult(matchCount, bonusMatch);
        }
    }
}