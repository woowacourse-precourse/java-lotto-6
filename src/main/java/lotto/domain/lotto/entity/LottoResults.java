package lotto.domain.lotto.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResults {
    private final Map<LottoResult, Integer> lottoResultsAndCount;

    public LottoResults(Map<LottoResult, Integer> lottoResultsAndCount) {
        this.lottoResultsAndCount = lottoResultsAndCount;
    }

    public Map<LottoResult, Integer> getCounts() {
        return Collections.unmodifiableMap(this.lottoResultsAndCount);
    }


    public BigDecimal getTotalPrize() {
        BigDecimal result = BigDecimal.ZERO;
        List<BigDecimal> list = this.lottoResultsAndCount.entrySet().stream()
                .map(entry -> entry.getKey().getTotalPrize(entry.getValue()))
                .toList();
        for (BigDecimal decimal : list) {
            result = result.add(decimal);
        }
        return result;
    }
}
