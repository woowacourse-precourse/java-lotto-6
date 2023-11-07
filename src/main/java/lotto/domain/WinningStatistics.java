package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private Map<LottoPrize, Integer> result;

    public WinningStatistics() {
        this.result = new HashMap<>();
    }

    public void recordMatching(int matchedNumbers, boolean bonusNumberMatch) {
        LottoPrize prize = LottoPrize.determinePrize(matchedNumbers, bonusNumberMatch);
        result.put(prize, result.getOrDefault(prize, 0) + 1);
    }

    public void aggregateResult(LottoStore lottoStore, LottoAnswer lottoAnswer) {
        for (Lotto lotto : lottoStore.getLottoTickets()) {
            int matchedNumbers = LottoChecker.countMatchingNumbers(lotto, lottoAnswer);
            boolean bonusNumberMatch = LottoChecker.isBonusNumberMatch(lotto,lottoAnswer.getBonusNumber());
            recordMatching(matchedNumbers , bonusNumberMatch);
        }
    }

    public Map<LottoPrize, Integer> getResult() {
        return result;
    }
}
