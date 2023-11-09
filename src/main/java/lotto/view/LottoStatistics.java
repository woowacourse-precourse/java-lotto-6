package lotto.view;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.LottoRank;

public class LottoStatistics {
    private final List<LottoRank> lottoRanks;

    public LottoStatistics(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public void printStatistics() {
        EnumSet<LottoRank> allRanks = EnumSet.allOf(LottoRank.class);
        Map<LottoRank, Long> rankCounts = countRankOccurrences();

        System.out.println("당첨 통계");
        System.out.println("---");

        allRanks.stream()
                .filter(rank -> rank != LottoRank.NONE)
                .forEach(rank -> {
                    long count = rankCounts.getOrDefault(rank, 0L);
                    String description = rank.getDescription();
                    String message = String.format("%s - %d개", description, count);
                    System.out.println(message);
                });
    }

    private Map<LottoRank, Long> countRankOccurrences() {
        return lottoRanks.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }
}
