package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MatchResult {
    public static final int INITIAL_MATCH_COUNT = 0;
    public static final int SINGLE_INCREMENT = 1;
    private final Map<LottoRank, Integer> matchResult;

    private MatchResult(Map<LottoRank, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public static MatchResult calculateMatchResults(Lottos lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> matchResult = new LinkedHashMap<>();
        initializeMatchResult(matchResult);

        for (Lotto lotto : lottos.getLottos()) {
            LottoRank rank = determineRank(winningNumbers, lotto);

            if (Objects.isNull(rank)) {
                continue;
            }
            matchResult.merge(rank, SINGLE_INCREMENT, Integer::sum);
        }

        return new MatchResult(matchResult);
    }

    private static void initializeMatchResult(Map<LottoRank, Integer> matchResult) {
        for (LottoRank rank : LottoRank.values()) {
            matchResult.put(rank, INITIAL_MATCH_COUNT);
        }
    }

    private static LottoRank determineRank(WinningNumbers winningNumbers, Lotto lotto) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers.getMainNumbers());
        boolean hasBonus = lotto.hasBonusNumber(winningNumbers.getBonusNumber());

        return LottoRank.valueOf(matchCount, hasBonus);
    }

    public Map<LottoRank, Integer> getMatchResult() {
        return matchResult;
    }
}
