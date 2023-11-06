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
        List<WinningStatistics> winningStatistics = new ArrayList<>(statistics.keySet());
        winningStatistics.remove(WinningStatistics.MISS);
        winningStatistics.sort(Collections.reverseOrder());
        Map<WinningStatistics, Integer> sortedStatistics = new LinkedHashMap<>();
        for (WinningStatistics statistic : winningStatistics) {
            sortedStatistics.put(statistic, statistics.get(statistic));
        }
        return sortedStatistics;
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
