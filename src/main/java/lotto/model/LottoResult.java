package lotto.model;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Rank, Integer> lottoResult;

    public LottoResult(EnumMap<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }
}
