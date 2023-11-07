package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static final int INIT_COUNT = 0;

    private final Map<LottoRank, Integer> result;

    private LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public static LottoResult create() {
        EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNotNothing)
                .forEach(lottoRank -> result.put(lottoRank, INIT_COUNT));

        return new LottoResult(result);
    }


}
