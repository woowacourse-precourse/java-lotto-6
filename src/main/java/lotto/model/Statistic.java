package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    private static final Integer DEFAULT_COUNT = 0;
    private static final Integer FIVE_COUNT = 5;
    private static final Integer COUNT = 1;

    private Map<LottoRank, Integer> rank;

    private Statistic(Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public static Statistic createStatistic(final List<Integer> matchedNumberCount,
                                            final List<Boolean> containBonusNumber) {
        return new Statistic(compileStatistic(matchedNumberCount, containBonusNumber));
    }

    private static Map<LottoRank, Integer> compileStatistic(final List<Integer> matchedNumberCount,
                                                            final List<Boolean> includeBonusNumber) {
        int lottoCount = matchedNumberCount.size();

        Map<LottoRank, Integer> playerRank = new EnumMap<>(LottoRank.class);

        for (int count = 0; count < lottoCount; count++) {
            LottoRank rank = determineRank(matchedNumberCount.get(count), includeBonusNumber.get(count));
            playerRank.put(rank, playerRank.getOrDefault(rank, DEFAULT_COUNT) + COUNT);
        }

        return playerRank;
    }

    private static LottoRank determineRank(Integer matchedCount, Boolean includeBonus) {
        if (isSecondRank(matchedCount, includeBonus)) {
            return LottoRank.SECOND_RANK;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchedCount() == matchedCount && !rank.isIncludeBonus())
                .findFirst()
                .orElse(LottoRank.NON_RANK);
    }

    private static boolean isSecondRank(Integer matchedCount, Boolean includeBonus) {
        return matchedCount == FIVE_COUNT && includeBonus;
    }

    public Map<LottoRank, Integer> getRank() {
        return rank;
    }
}
