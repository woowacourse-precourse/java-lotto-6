package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Score {
    private final Map<LottoRank, Integer> lottoResult;

    public Score(final Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = new HashMap<>(lottoResult);
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(this.lottoResult);
    }
}
