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

        LottoRank rank = determineRank(matchedNumberCount, includeBonusNumber);
        playerRank.put(rank, playerRank.getOrDefault(rank, 0) + 1);

        return playerRank;
    }

    private static LottoRank determineRank(final List<Integer> matchedCount, final List<Boolean> includeBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> matchedCount.get(rank.ordinal()) == rank.getMatchedCount() &&
                        includeBonus.get(rank.ordinal()) == rank.isIncludeBonus())
                .findFirst()
                .orElse(LottoRank.NON_RANK);
    }

    public Map<LottoRank, Integer> getRank() {
        return rank;
    }
}
