package lotto.model.domain.result;

import java.util.HashMap;
import java.util.Map;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.LottoAnswer;

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

    public LottoResult getResult(Lotto lotto, LottoAnswer lottoAnswer) {
        LottoCompareResult lottoCompareResult = lotto.compareLotto(lottoAnswer);
        return results.getOrDefault(lottoCompareResult, LottoResult.LOSE);
    }
}
