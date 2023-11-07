package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoRank;

public class LottoMatchResultDto {
    private final Map<LottoRank, Integer> lottoRankCount;
    private final double profitRate;

    public LottoMatchResultDto(Map<LottoRank, Integer> lottoRankCount, double profitRate) {
        this.lottoRankCount = Collections.unmodifiableMap(new HashMap<>(lottoRankCount));
        this.profitRate = profitRate;
    }

    public Map<LottoRank, Integer> getLottoRankCount() {
        return lottoRankCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

