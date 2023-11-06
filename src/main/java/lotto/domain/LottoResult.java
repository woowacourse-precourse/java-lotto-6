package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
