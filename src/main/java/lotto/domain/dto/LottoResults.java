package lotto.domain.dto;

import java.util.Map;
import java.util.EnumMap;
import lotto.domain.LottoRank;

public record LottoResults(Map<LottoRank, Integer> rankCounts) {

    public LottoResults(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = new EnumMap<>(rankCounts);
    }

    public long calculateTotalEarnings() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}