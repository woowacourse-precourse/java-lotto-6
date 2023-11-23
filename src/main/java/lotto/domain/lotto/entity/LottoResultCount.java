package lotto.domain.lotto.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResultCount {
    private final Map<LottoResult, Integer> lottoResultCount;

    public LottoResultCount(Map<LottoResult, Integer> lottoResultCount) {
        this.lottoResultCount = lottoResultCount;
    }

    public Map<LottoResult, Integer> getCounts() {
        return Collections.unmodifiableMap(this.lottoResultCount);
    }


    public BigDecimal getTotalPrize() {
        BigDecimal result = BigDecimal.ZERO;
        List<BigDecimal> list = this.lottoResultCount.entrySet().stream()
                .map(entry -> entry.getKey().getTotalPrize(entry.getValue()))
                .toList();
        for (BigDecimal decimal : list) {
            result = result.add(decimal);
        }
        return result;
    }
}
