package lotto.domain;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistic {
    private final Map<Rank, Integer> statistic;

    public WinningStatistic() {
        this.statistic = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistic.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        statistic.put(rank, statistic.get(rank) + 1);
    }

    public int getCountByRank(Rank rank) {
        return statistic.getOrDefault(rank, 0);
    }

    public double calculateYield(int totalAmount) {
        int totalPrize = statistic.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return (totalPrize / (double) totalAmount) * 100;
    }

    public void printStatistic() {
        NumberFormat formatter = NumberFormat.getInstance();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : statistic.keySet().stream().sorted(Rank.PRIZE_ASCENDING_ORDER).toList()) {
            if (rank != Rank.MISS) {
                printRankStatistic(rank, formatter);
            }
        }
    }

    private void printRankStatistic(Rank rank, NumberFormat formatter) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getCountOfMatch()).append("개 일치");
        if (rank.isMatchBonus()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(formatter.format(rank.getPrize())).append("원) - ").append(statistic.get(rank)).append("개");

        System.out.println(sb.toString());
    }
}
