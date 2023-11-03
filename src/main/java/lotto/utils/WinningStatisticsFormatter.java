package lotto.utils;

import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.Arrays;
import java.util.Comparator;

public class WinningStatisticsFormatter implements Formatter<WinningStatistics> {
    @Override
    public String format(WinningStatistics winningStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("당첨 통계\n---\n");
        Rank[] ranks = Rank.values();
        Arrays.sort(ranks, Comparator.comparingInt(Rank::getMatchCount));

        for (Rank rank : ranks) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = winningStatistics.getRankCount().getOrDefault(rank, 0);
            String prizeMoney = String.format("%,d", rank.getPrizeMoney());
            String bonusMatch = " ";
            if (rank.isBonusMatch()) {
                bonusMatch = ", 보너스 볼 일치 ";
            }
            stringBuilder.append(String.format("%d개 일치%s(%s)원 - %d개%n",
                    rank.getMatchCount(),
                    bonusMatch,
                    prizeMoney,
                    count));
        }

        stringBuilder.append(String.format("총 수익률은 %.1f%%입니다.", winningStatistics.getProfitRate()));

        return stringBuilder.toString();
    }
}
