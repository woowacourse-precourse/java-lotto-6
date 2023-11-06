package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultCount;
    private final WinningNumbers winningNumbers;


    public LottoResult(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        resultCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            resultCount.put(rank, 0);
        }
    }

    public void addResult(int matchCount, boolean hasBonusNumber) {
        Rank rank = Rank.valueOf(matchCount, hasBonusNumber);
        resultCount.put(rank, resultCount.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return resultCount.get(rank);
    }
}
