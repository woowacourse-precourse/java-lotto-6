package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    private Map<LottoRank, Integer> rank;

    private Statistic(Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public static Statistic from(final List<Integer> matchedNumberCount, final List<Boolean> includeBonusNumber) {
        return new Statistic(getResult(matchedNumberCount, includeBonusNumber));
    }

    private static Map<LottoRank, Integer> getResult(final List<Integer> matchedNumberCount,
                                                     final List<Boolean> includeBonusNumber) {
        Map<LottoRank, Integer> playerRank = new HashMap<>();

        for (int index = 0; index < matchedNumberCount.size(); index++) {
            LottoRank rank = determineRank(matchedNumberCount.get(index), includeBonusNumber.get(index));
            playerRank.put(rank, playerRank.getOrDefault(rank, 0) + 1);
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
