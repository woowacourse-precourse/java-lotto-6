package lotto.domain.lotto.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoResult, Integer> lottoResultsAndCount;

    public LottoResults(Map<LottoResult, Integer> lottoResultsAndCount) {
        this.lottoResultsAndCount = lottoResultsAndCount;
    }

    public Map<LottoResult, Integer> getCounts() {
        return Collections.unmodifiableMap(this.lottoResultsAndCount);
    }

    public Map<LottoResult, BigDecimal> getPrize() {
        EnumMap<LottoResult, BigDecimal> prizes = new EnumMap<>(LottoResult.class);
        for (LottoResult result : LottoResult.values()) {
            int count = lottoResultsAndCount.get(result);
            BigDecimal prize = result.getTotalPrize(count);
            prizes.put(result, prize);
        }

        return prizes;
    }
}
