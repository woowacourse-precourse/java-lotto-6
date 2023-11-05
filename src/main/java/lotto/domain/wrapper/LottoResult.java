package lotto.domain.wrapper;

import lotto.handler.LottoHandler;

import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoHandler, Integer> lottoResult;

    private LottoResult(Map<LottoHandler, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static LottoResult create(Map<LottoHandler, Integer> lottoResult) {
        return new LottoResult(lottoResult);
    }

    public Map<LottoHandler, Integer> getLottoResult() {
        return lottoResult;
    }
}
