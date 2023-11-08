package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    public Map<PrizeCategory, Integer> countNumberOfWinning(List<Lotto> lottoTickets, WinningNumber winningNumber) {
        Map<PrizeCategory, Integer> map = new HashMap<>();
        for (PrizeCategory prizeCategory : PrizeCategory.values()) {
            map.put(prizeCategory, 0);
        }

        for (Lotto lotto : lottoTickets) {
            int numberOfWinning = map.get(lotto.compareTo(winningNumber));
            numberOfWinning++;
            map.put(lotto.compareTo(winningNumber), numberOfWinning);
        }
        return map;
    }
}
