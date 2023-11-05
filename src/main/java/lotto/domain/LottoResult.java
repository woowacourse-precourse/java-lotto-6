package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<WinningStatistics, Integer> statistics;

    public LottoResult(Map<WinningStatistics, Integer> statistics) {
        this.statistics = statistics;
    }

    public Map<WinningStatistics, Integer> getSortedStatistics() {
        List<WinningStatistics> winningStatistics = new ArrayList<>(statistics.keySet());
        winningStatistics.remove(WinningStatistics.MISS);
        winningStatistics.sort(Collections.reverseOrder());
        Map<WinningStatistics, Integer> sortedRanks = new LinkedHashMap<>();
        for (WinningStatistics statistic : winningStatistics) {
            sortedRanks.put(statistic, statistics.get(statistic));
        }
        return sortedRanks;
    }
}
