package lotto;

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
    }
}
