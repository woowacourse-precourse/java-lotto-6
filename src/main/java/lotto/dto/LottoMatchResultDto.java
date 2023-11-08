package lotto.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.Rank;

public class LottoMatchResultDto {
    private final Map<Rank, Integer> lottoRankCount;
    private final double profitRate;

    public LottoMatchResultDto(Map<Rank, Integer> lottoRankCount, double profitRate) {
        this.lottoRankCount = Collections.unmodifiableMap(new HashMap<>(lottoRankCount));
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getLottoRankCount() {
        return lottoRankCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
