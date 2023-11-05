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
        Map<WinningStatistics, Integer> sortedStatistics = new LinkedHashMap<>();
        for (WinningStatistics statistic : winningStatistics) {
            sortedStatistics.put(statistic, statistics.get(statistic));
        }
        return sortedStatistics;
    }

    public double calculatePercent() {
        int sum = 0;
        int totalPrice = 0;
        for (WinningStatistics statistic : statistics.keySet()) {
            sum += statistic.getReward() * statistics.get(statistic);
            totalPrice += statistics.get(statistic) * 1000;
        }
        return (sum * 1.0 / totalPrice) * 100;
    }
}
