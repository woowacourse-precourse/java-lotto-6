package lotto.domain;

import lotto.constant.LottoRank;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new HashMap<>();

    public LottoResult() {
        LottoRank[] values = LottoRank.values();
        for (LottoRank value : values) {
            result.put(value, 0);
        }
    }

    public void increaseLottoRankCount(LottoRank lottoRank) {
    }

    public Map<LottoRank, Integer> getResult() {
        return new HashMap<>();
    }
}
