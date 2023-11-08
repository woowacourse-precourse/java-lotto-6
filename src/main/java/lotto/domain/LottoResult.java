package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> ranksCount;

    public LottoResult() {
        ranksCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            ranksCount.put(rank, 0);
        }
    }

}
