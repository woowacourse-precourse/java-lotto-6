package lotto.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;

public class LottoRanks {
    private static final int ONE = 1;

    private final List<LottoRank> elements;

    public LottoRanks(List<LottoRank> elements) {
        this.elements = elements;
    }

    private static Map<LottoRank, Integer> initRankCounts() {
        Map<LottoRank, Integer> rankCounts = new HashMap<>();
        List<LottoRank> lottoRanks = List.of(LottoRank.values());

        for (LottoRank lottoRank : lottoRanks) {
            rankCounts.put(lottoRank, 0);
        }

        return rankCounts;
    }

    public long getWinningSum() {
        return elements.stream()
                .map(LottoRank::getWinnings)
                .mapToLong(Long::valueOf)
                .sum();
    }

    public Map<LottoRank, Integer> getRankCounts() {
        Map<LottoRank, Integer> rankCounts = initRankCounts();

        elements.forEach((rank) -> rankCounts.put(rank, rankCounts.get(rank) + ONE));

        return rankCounts;
    }
}
