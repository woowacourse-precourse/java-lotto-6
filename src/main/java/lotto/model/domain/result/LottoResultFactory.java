package lotto.model.domain.result;

import java.util.HashMap;
import java.util.Map;
import lotto.model.domain.result.compare.LottoAnswerCompareResult;

public class LottoResultFactory {
    private final Map<LottoAnswerCompareResult, LottoResult> results;

    public LottoResultFactory() {
        results = new HashMap<>();
        results.put(new LottoAnswerCompareResult(3, false), LottoResult.FIFTH);
        results.put(new LottoAnswerCompareResult(4, false), LottoResult.FOURTH);
        results.put(new LottoAnswerCompareResult(5, false), LottoResult.THIRD);
        results.put(new LottoAnswerCompareResult(5, true), LottoResult.SECOND);
        results.put(new LottoAnswerCompareResult(6, false), LottoResult.FIRST);
    }

    public LottoResult getLottoResult(LottoAnswerCompareResult lottoCompareResult) {
        return results.getOrDefault(lottoCompareResult, LottoResult.LOSE);
    }
}
