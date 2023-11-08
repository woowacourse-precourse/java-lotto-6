package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class WinStats {
    private static Map<Rank, Integer> WinStats;

    public WinStats(Map<Rank, Integer> WinStats) {
        this.WinStats = WinStats;
    }

    public static double calculateEarningsRate() {
        long totalPrizeMoney = getTotalPrizeMoney();
        double purchase = getPurchase();

        return totalPrizeMoney / purchase * 100;
    }

    private static long getTotalPrizeMoney() {
        long totalPrizeMoney = 0;
        for (Map.Entry<Rank, Integer> entry : WinStats.entrySet()) {
            totalPrizeMoney += entry.getKey().getWinningMoney() * entry.getValue();
        }
        return totalPrizeMoney;
    }

    private static double getPurchase() {
        double count = 0;
        for (int value : WinStats.values()) {
            count += value;
        }
        return count * 1000;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        List<Map.Entry<Rank, Integer>> sortedEntries = new ArrayList<>(WinStats.entrySet());

        sortedEntries.removeIf(entry -> entry.getKey().equals(Rank.LOSING_TICKET));
        sortedEntries.sort(Comparator.comparingLong(entry -> entry.getKey().getWinningMoney()));

        DecimalFormat df = new DecimalFormat("###,###");

        for (Map.Entry<Rank, Integer> entry : sortedEntries) {
            String money = df.format(entry.getKey().winningMoney);
            if (entry.getKey() == Rank.SECOND) {
                output.append(entry.getKey().countOfMatch).append("개 일치, 보너스 볼 일치 ")
                        .append("(" + money + "원"+")")
                        .append(" - ").append(entry.getValue()).append("개").append("\n");

            } else if (entry.getKey() != Rank.SECOND) {
                output.append(entry.getKey().countOfMatch).append("개 일치 ")
                        .append("(" + money + "원" + ")")
                        .append(" - ").append(entry.getValue()).append("개").append("\n");
            }
        }
        return output.toString();
    }
}
