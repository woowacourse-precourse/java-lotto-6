package lotto.model;

import static lotto.model.LottoRank.NON_RANK;
import static lotto.model.LottoRank.SECOND_RANK;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    private static final Integer DEFAULT_COUNT = 0;
    private static final Integer FIVE_COUNT = 5;
    private static final Integer COUNT = 1;

    private final Map<LottoRank, Integer> result;

    private Statistic(final Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public static Statistic createStatistic(final List<Integer> matchedNumberCount,
                                            final List<Boolean> containBonusNumber) {
        return new Statistic(compileStatistic(matchedNumberCount, containBonusNumber));
    }

    private static Map<LottoRank, Integer> compileStatistic(final List<Integer> matchedNumberCount,
                                                            final List<Boolean> containBonusNumber) {
        Map<LottoRank, Integer> playerResult = new EnumMap<>(LottoRank.class);
        Integer lottoCount = matchedNumberCount.size();

        for (int index = 0; index < lottoCount; index++) {
            LottoRank rank = determineRank(matchedNumberCount.get(index), containBonusNumber.get(index));
            playerResult.put(rank, playerResult.getOrDefault(rank, DEFAULT_COUNT) + COUNT);
        }

        return Collections.unmodifiableMap(playerResult);
    }

    private static LottoRank determineRank(final Integer matchedCount, final Boolean includeBonus) {
        if (isSecondRank(matchedCount, includeBonus)) {
            return SECOND_RANK;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchedCount() == matchedCount && !rank.isRequireContainBonusNumber())
                .findFirst()
                .orElse(NON_RANK);
    }

    private static boolean isSecondRank(final Integer matchedCount, final Boolean includeBonus) {
        return matchedCount == FIVE_COUNT && includeBonus;
    }

    public Map<LottoRank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
