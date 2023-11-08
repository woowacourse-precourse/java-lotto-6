package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    public Map<PrizeCategory, Integer> countNumberOfWinning(List<Lotto> lottoTickets, LottoNumbers lottoNumbers) {
        Map<PrizeCategory, Integer> map = new HashMap<>();
        for (PrizeCategory prizeCategory : PrizeCategory.values()) {
            map.put(prizeCategory, 0);
        }

        for (Lotto lotto : lottoTickets) {
            int numberOfWinning = map.get(lotto.compareTo(lottoNumbers));
            numberOfWinning++;
            map.put(lotto.compareTo(lottoNumbers), numberOfWinning);
        }
        return map;
    }

    public long getTotalPrizeMoney(Map<PrizeCategory, Integer> winningCounts) {
        long totalPrizeMoney = 0;
        for (PrizeCategory prize : PrizeCategory.values()) {
            long multipliedPrizeMoney = prize.getPrizeMoney() * winningCounts.get(prize);
            totalPrizeMoney += multipliedPrizeMoney;
        }
        return totalPrizeMoney;
    }

    public double getRateOfReturn(long purchaseAmount, long totalPrizeMoney) {
        double rateOfReturn = totalPrizeMoney * 1000.0 / purchaseAmount;
        return Math.round(rateOfReturn) / 10.0;
    }
}
