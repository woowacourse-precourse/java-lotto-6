package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    private static final Integer DEFAULT_COUNT = 0;
    private static final Integer FIVE_COUNT = 5;
    private static final Integer COUNT = 1;

    private final Map<LottoRank, Integer> rank;

    private Statistic(final Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public static Statistic createStatistic(final List<Integer> matchedNumberCount,
                                            final List<Boolean> containBonusNumber) {
        return new Statistic(compileStatistic(matchedNumberCount, containBonusNumber));
    }

    private static Map<LottoRank, Integer> compileStatistic(final List<Integer> matchedNumberCount,
                                                            final List<Boolean> containBonusNumber) {
        Map<LottoRank, Integer> playerRank = new EnumMap<>(LottoRank.class);
        Integer lottoCount = matchedNumberCount.size();

        for (int index = 0; index < lottoCount; index++) {
            LottoRank rank = determineRank(matchedNumberCount.get(index), containBonusNumber.get(index));
            playerRank.put(rank, playerRank.getOrDefault(rank, DEFAULT_COUNT) + COUNT);
        }

        return Collections.unmodifiableMap(playerRank);
    }

    private static LottoRank determineRank(final Integer matchedCount, final Boolean includeBonus) {
        if (isSecondRank(matchedCount, includeBonus)) {
            return LottoRank.SECOND_RANK;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchedCount() == matchedCount && !rank.isContainBonusNumber())
                .findFirst()
                .orElse(LottoRank.NON_RANK);
    }

    private static boolean isSecondRank(final Integer matchedCount, final Boolean includeBonus) {
        return matchedCount == FIVE_COUNT && includeBonus;
    }

    public Map<LottoRank, Integer> getRank() {
        return Collections.unmodifiableMap(rank);
    }
}
