package lotto.model.domain.result;

import java.util.HashMap;
import java.util.Map;

public class LottoResultFactory {
    private final Map<LottoCompareResult, LottoResult> results;

    public LottoResultFactory() {
        results = new HashMap<>();
        results.put(new LottoCompareResult(3, false), LottoResult.FIFTH);
        results.put(new LottoCompareResult(4, false), LottoResult.FOURTH);
        results.put(new LottoCompareResult(5, false), LottoResult.THIRD);
        results.put(new LottoCompareResult(5, true), LottoResult.SECOND);
        results.put(new LottoCompareResult(6, false), LottoResult.FIRST);
    }

    public LottoResult getLottoResult(LottoCompareResult lottoCompareResult) {
        return results.getOrDefault(lottoCompareResult, LottoResult.LOSE);
    }
}
