package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<LottoPrize, Integer> result;
    private final LottoStore lottoStore;
    private final LottoAnswer lottoAnswer;
    private final Money money;

    public WinningStatistics(LottoStore lottoStore, LottoAnswer lottoAnswer, Money money) {
        this.result = new HashMap<>();
        this.lottoStore = lottoStore;
        this.lottoAnswer = lottoAnswer;
        this.money = money;
        aggregateResult();
    }

    private void recordMatching(int matchedNumbers, boolean bonusNumberMatch) {
        LottoPrize prize = LottoPrize.determinePrize(matchedNumbers, bonusNumberMatch);
        if (prize != null) {
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }
    }

    private void aggregateResult() {
        for (Lotto lotto : lottoStore.getLottoTickets()) {
            int matchedNumbers = LottoChecker.countMatchingNumbers(lotto, lottoAnswer);
            boolean bonusNumberMatch = LottoChecker.isBonusNumberMatch(lotto, lottoAnswer.getBonusNumber());
            recordMatching(matchedNumbers, bonusNumberMatch);
        }
    }

    public Map<LottoPrize, Integer> getMatchingResult() {
        return result;
    }

    public double getReturnRate() {
        long totalPrize = getTotalPrize();
        int moneyAmount = money.getAmount();

        double returnRate =  ((double) totalPrize / moneyAmount) * 100.0;
        return Math.round(returnRate * 10.0) / 10.0;
    }

    public long getTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<LottoPrize, Integer> entry : result.entrySet()) {
            LottoPrize prize = entry.getKey();
            int count = entry.getValue();
            totalPrize += prize.getPrize() * count;
        }
        return totalPrize;
    }

    public Money getMoney() {
        return money;
    }
}
