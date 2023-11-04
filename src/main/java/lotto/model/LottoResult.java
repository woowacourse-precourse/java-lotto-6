package lotto.model;

import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoResult {
    private static LottoResult instance;

    private final Map<Integer, Integer> lottoResult;

    private LottoResult (Map<Integer, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static LottoResult of (Map<Integer, Integer> lottoResult) {
        if (instance == null) {
            instance = new LottoResult(lottoResult);
        }

        return instance;
    }

    public Integer getValue (Integer key) {
        return lottoResult.get(key);
    }
}
