package lotto.utils;

import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class WinningStatisticsFormatter implements Formatter<WinningStatistics> {
    @Override
    public String format(WinningStatistics winningStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = winningStatistics.getRankCount().getOrDefault(rank, 0);
            stringBuilder.append(String.format("%d개 일치 (%s)원 - %d개%n",
                    rank.getMatchCount(),
                    rank.getPrizeMoney(),
                    count));
        }

        stringBuilder.append(String.format("총 수익률은 %.1f%%입니다.", winningStatistics.getProfitRate()));

        return stringBuilder.toString();
    }
}
