package lotto.dto;

import lotto.domain.Rank;
import java.util.Map;

public record LottoResultDto(double profitRate, Map<Rank, Integer> result) {
    public LottoResultDto(double profitRate, Map<Rank, Integer> result) {
        removeOutRankKeys(result);
        this.result = result;

        this.profitRate = profitRate;
    }

    private void removeOutRankKeys(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            if(rank.isOutRank()) {
                result.remove(rank);
            }
        }
    }
}