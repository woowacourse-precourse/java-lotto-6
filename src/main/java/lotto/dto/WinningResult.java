package lotto.dto;

import java.math.BigDecimal;
import java.util.Map.Entry;
import java.util.Set;
import lotto.domain.Rank;
import lotto.domain.RankResult;

public record WinningResult(RankResult rankResult, BigDecimal rateOfReturn) {
    public Set<Entry<Rank, Integer>> entrySet() {
        return rankResult.entrySet();
    }
}
