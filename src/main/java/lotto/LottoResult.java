package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result;
    private final int amountSpent;

    public LottoResult(int amountSpent) {
        this.result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        this.amountSpent = amountSpent;
    }

    public void addWinningRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return result.get(rank);
    }

    public double calculateEarningsRate() {
        long totalWinningAmount = result.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
            .sum();
        return (double) totalWinningAmount / amountSpent * 100;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            String bonusMatchString = "";
            if (rank == Rank.SECOND) {
                bonusMatchString = ", 보너스 볼 일치";
            }
            System.out.printf("%d개 일치%s (%s원) - %d개\n",
                rank.getCountOfMatch(),
                bonusMatchString,
                String.format("%,d", rank.getWinningMoney()),
                getCount(rank));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", calculateEarningsRate());
    }
    
}
