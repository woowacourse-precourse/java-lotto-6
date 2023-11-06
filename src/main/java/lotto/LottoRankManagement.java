package lotto;

import static lotto.Application.getPurchasedPrice;

import java.util.HashMap;
import java.util.Map;

public class LottoRankManagement {

    private Map<LottoRank, Integer> rankCounts;

    public LottoRankManagement() {
        rankCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void add(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            int count = rankCounts.get(rank);
            if (rank != LottoRank.NONE && count > 0) {
                System.out.printf("%d개 일치 %s (%,d원) - %d개\n",
                        rank.getMatchCount(), rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "",
                        rank.getPrize(), count);
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", getRate());
    }

    private double getRate() {
        int totalPrize = getTotalPrize();
        double rate = ((double) totalPrize / (double) getPurchasedPrice()) * 100;
        return rate;
    }

    private int getTotalPrize() {
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += rank.getPrize() * rankCounts.get(rank);
        }
        return totalPrize;
    }
}
