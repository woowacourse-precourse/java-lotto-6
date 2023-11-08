package lotto.domain;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistic {
    private final Map<Rank, Integer> statistic;

    public WinningStatistic() {
        this.statistic = new HashMap<>();
        for(Rank rank : Rank.values()){
            statistic.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        statistic.put(rank, statistic.get(rank) + 1);
    }

    public double calculateYield(int totalAmount) {
        int totalPrize = statistic.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return (totalPrize / (double) totalAmount) * 100;
    }

    public void printStatistic() {
        NumberFormat formatter = NumberFormat.getInstance();
        System.out.println("\n당첨 통계");
        System.out.println("---");
        statistic.forEach((rank, count) -> {
            if(rank != Rank.MISS) {
                System.out.println(rank.getCountOfMatch() + "개 일치" + (rank.isMatchBonus() ? ", 보너스 볼 일치" : "") + " (" + rank.getPrize() + "원) - " + count + "개");
            }
        });

    }
}
