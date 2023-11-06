package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult(LottoGame lottoGame) {
        lottoResult = new EnumMap<>(LottoRank.class);
        List<Integer> countResults = lottoGame.play();
    }
}
