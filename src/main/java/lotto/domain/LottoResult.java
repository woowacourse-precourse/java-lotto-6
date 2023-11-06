package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final double PERCENTAGE_SCALE = 100.0;
    private static final int COST_PER_LOTTO = 1000;
    private static final double TO_DECIMAL = 1.0;

    private final Map<WinningStatistics, Integer> statistics;

    public LottoResult(Map<WinningStatistics, Integer> statistics) {
        this.statistics = statistics;
    }

    public Map<WinningStatistics, Integer> getSortedStatistics() {
        List<WinningStatistics> sortedStatistics = createSortedStatistics();
        return createSortedStatisticsMap(sortedStatistics);
    }

    private List<WinningStatistics> createSortedStatistics() {
        List<WinningStatistics> winningStatistics = new ArrayList<>(statistics.keySet());
        removeMiss(winningStatistics);
        winningStatistics.sort(Collections.reverseOrder());
        return winningStatistics;
    }

    private void removeMiss(List<WinningStatistics> winningStatistics) {
        winningStatistics.remove(WinningStatistics.MISS);
    }

    private Map<WinningStatistics, Integer> createSortedStatisticsMap(List<WinningStatistics> sortedStatistics) {
        Map<WinningStatistics, Integer> sortedStatisticsMap = new LinkedHashMap<>();
        for (WinningStatistics statistic : sortedStatistics) {
            sortedStatisticsMap.put(statistic, statistics.get(statistic));
        }
        return sortedStatisticsMap;
    }

    public double calculateProfitPercent() {
        int sum = 0;
        int totalPrice = 0;

        for (WinningStatistics statistic : statistics.keySet()) {
            int reward = statistic.getReward();
            int count = statistics.get(statistic);

            sum += reward * count;
            totalPrice += count * COST_PER_LOTTO;
        }

        return (sum * TO_DECIMAL / totalPrice) * PERCENTAGE_SCALE;
        // sum이 5000이고 totalPrice이 8000이면 그냥 나눗셈을 하면 0이 된다. 하지만 1.0을 곱해 소숫점 형태로 만들고 나누면 0.625가 나온다.
    }
}
