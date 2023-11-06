package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private final List<Lotto> lottos;
    private final List<Integer> winningLotteryNumbers;
    private final int bonusNumber;

    public LottoChecker(List<Lotto> lottos, List<Integer> winningLotteryNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningLotteryNumbers = winningLotteryNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoRank, Integer> compareLottoNumbers() {
        Map<LottoRank, Integer> results = initializeResults();

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningLotteryNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            LottoRank rank = LottoRank.getLottoRank(matchCount, bonusMatch);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return results;
    }

    private Map<LottoRank, Integer> initializeResults() {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
        return results;
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
