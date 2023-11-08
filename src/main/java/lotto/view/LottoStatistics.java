package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.LottoRank;

public class LottoStatistics {
    private final List<LottoRank> ranks;

    public LottoStatistics(List<LottoRank> ranks) {
        this.ranks = ranks;
    }

    public void printStatistics() {
        Map<LottoRank, Integer> rankCounts = countRankOccurrences();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int count = rankCounts.getOrDefault(rank, 0);
                String description = rank.getDescription();
                int prizeMoney = rank.getPrizeMoney();
                String message = String.format("%s - %d개", description, count);
                System.out.println(message);
            }
        }
    }

    private Map<LottoRank, Integer> countRankOccurrences() {
        return ranks.stream()
                .collect(Collectors.toMap(rank -> rank, rank -> 1, Integer::sum));
    }
}
