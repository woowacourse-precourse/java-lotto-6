package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningStatistics {
    Map<Statistics, Integer> winningStatistics;

    public WinningStatistics(ResultDTO resultDTO, int quantity) {
        initialize();
        produceStatisticBased(resultDTO, quantity);
        deleteNoMatch();
    }

    private void initialize() {
        winningStatistics = new LinkedHashMap<>();

        for (Statistics statistics : Statistics.values()) {
            winningStatistics.put(statistics, 0);
        }
    }

    private void produceStatisticBased(ResultDTO resultDTO, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Statistics statistics = Statistics.of(resultDTO.winningNumberResult().get(i), resultDTO.bonusResult().get(i));
            winningStatistics.put(statistics, winningStatistics.getOrDefault(statistics, 0) + 1);
        }
    }

    private void deleteNoMatch() {
        winningStatistics.remove(Statistics.NO_MATCH);
    }

    public void outputAllStatisticsInfo() {
        System.out.println(LottoMessage.WINNING_STATISTICS.getMessage());
        for (Map.Entry<Statistics, Integer> entry : winningStatistics.entrySet()) {
            System.out.printf(entry.getKey().getMessage(), entry.getValue());
        }
    }

    public long calculatePrizeMoney() {
        long prizeMoney = 0;

        for (Map.Entry<Statistics, Integer> entry : winningStatistics.entrySet()) {
            prizeMoney = prizeMoney + ((long) entry.getKey().getMoney() * entry.getValue());
        }

        return prizeMoney;
    }
}
