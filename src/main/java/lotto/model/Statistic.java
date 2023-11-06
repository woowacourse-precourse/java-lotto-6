package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    private static final Integer DEFAULT_COUNT = 0;
    private static final Integer COUNT = 1;

    private Map<LottoRank, Integer> rank;

    private Statistic(Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public static Statistic from(final List<Integer> matchedNumberCount, final List<Boolean> containBonusNumber) {
        return new Statistic(makeResult(matchedNumberCount, containBonusNumber));
    }

    private static Map<LottoRank, Integer> makeResult(final List<Integer> matchedNumberCount,
                                                      final List<Boolean> includeBonusNumber) {
        Map<LottoRank, Integer> playerRank = new HashMap<>();

        int lottoSize = matchedNumberCount.size();
        for (int index = 0; index < lottoSize; index++) {
            LottoRank rank = determineRank(matchedNumberCount.get(index), includeBonusNumber.get(index));
            playerRank.put(rank, playerRank.getOrDefault(rank, DEFAULT_COUNT) + COUNT);
        }

        return playerRank;
    }

    private static LottoRank determineRank(Integer matchedCount, Boolean includeBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchedCount() == matchedCount && rank.isIncludeBonus() == includeBonus)
                .findFirst()
                .orElse(LottoRank.NON_RANK);
    }

    public Map<LottoRank, Integer> getRank() {
        return rank;
    }
}
