package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<WinningStatistics, Integer> ranks;

    public LottoResult(Map<WinningStatistics, Integer> ranks) {
        this.ranks = ranks;
    }

    public Map<WinningStatistics, Integer> getSortedRanks() {
        List<WinningStatistics> rankList = new ArrayList<>(ranks.keySet());
        rankList.remove(WinningStatistics.MISS);
        rankList.sort(Collections.reverseOrder());
        Map<WinningStatistics, Integer> sortedStatistics = new LinkedHashMap<>();
        for (WinningStatistics statistics : rankList) {
            sortedStatistics.put(statistics, ranks.get(statistics));
        }
        return sortedStatistics;
    }
}
