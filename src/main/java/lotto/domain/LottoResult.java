package lotto.domain;

import lotto.constant.LottoRank;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new HashMap<>();

    public LottoResult() {
        Stream.of(LottoRank.values()).forEach(lottoRank -> result.put(lottoRank, 0));
    }

    public void increaseLottoRankCount(LottoRank lottoRank) {
        int currentCount = result.get(lottoRank);
        result.replace(lottoRank, currentCount + 1);
    }

    public Map<LottoRank, Integer> getResult() {
        result.remove(LottoRank.OUT_RANK);
        return Collections.unmodifiableMap(result);
    }
}
