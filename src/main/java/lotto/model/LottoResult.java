package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    // TODO : enum 으로 변경해서 중복 제거.
    // TODO : equals, hashcode 구현.
    private static final int MAX_MATCH_COUNT = 6;
    private Map<Integer, Integer> matchCounts = new HashMap<>();

    public LottoResult() {
        for (int i = 0; i <= MAX_MATCH_COUNT; i++) {
            matchCounts.put(i, 0);
        }
    }
}
