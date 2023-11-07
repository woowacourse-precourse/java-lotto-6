package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> numberOfRank;

    public LottoResult() {
        numberOfRank = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> {
                numberOfRank.put(rank, 0);
            }
        );
    }

    public void addRank(Rank rank) {
        numberOfRank.put(rank, numberOfRank.get(rank) + 1);
    }

    public Map<Rank, Integer> getNumberOfRankByMap() {
        return Collections.unmodifiableMap(numberOfRank);
    }
}