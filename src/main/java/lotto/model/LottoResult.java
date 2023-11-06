package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    // TODO : enum 으로 변경해서 중복 제거.
    // TODO : equals, hashcode 구현.
    private static final int MAX_MATCH_COUNT = 6;
    private Map<Integer, Integer> matchCounts = new HashMap<>();
    private Map<Integer, Long> prizeMap = initializePrizeMap();

    public LottoResult() {
        for (int i = 0; i <= MAX_MATCH_COUNT; i++) {
            matchCounts.put(i, 0);
        }
    }

    private Map<Integer, Long> initializePrizeMap() {
        Map<Integer, Long> prizeMap = new HashMap<>();
        prizeMap.put(3, 5_000L);
        prizeMap.put(4, 50_000L);
        prizeMap.put(5, 1_500_000L);
        prizeMap.put(6, 2_000_000_000L);
        return prizeMap;
    }

    public void updateMatchCount(Lotto purchasedLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = purchasedLotto.matchCount(winningLotto);
        incrementMatchCount(matchCount);
        if (matchCount == 5 && purchasedLotto.containsNumber(bonusNumber)) {
            incrementMatchCount(MAX_MATCH_COUNT);
        }
    }

    private void incrementMatchCount(int matchCount) {
        matchCounts.put(matchCount, matchCounts.getOrDefault(matchCount, 0) + 1);
    }

    public void calculateResults(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        for (Lotto purchasedLotto : purchasedLottos) {
            updateMatchCount(purchasedLotto, winningLotto, bonusNumber);
        }
    }

}
