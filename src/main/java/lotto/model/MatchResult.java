package lotto.model;

import static lotto.common.Constant.SINGLE_INCREMENT;

import java.util.HashMap;
import java.util.Objects;

public class MatchResult {
    private final HashMap<LottoRank, Integer> matchResult;

    private MatchResult(HashMap<LottoRank, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public static MatchResult calculateMatchResults(Lottos lottos, WinningNumbers winningNumbers) {
        HashMap<LottoRank, Integer> matchResult = new HashMap<>();

        for (Lotto lotto : lottos.getLottos()) {
            LottoRank rank = determineRank(winningNumbers, lotto);

            if (Objects.isNull(rank)) {
                continue;
            }
            matchResult.merge(rank, SINGLE_INCREMENT, Integer::sum);
        }

        return new MatchResult(matchResult);
    }

    private static LottoRank determineRank(WinningNumbers winningNumbers, Lotto lotto) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers.getMainNumbers());
        boolean hasBonus = lotto.hasBonusNumber(winningNumbers.getBonusNumber());

        return LottoRank.valueOf(matchCount, hasBonus);
    }

    public HashMap<LottoRank, Integer> getMatchResult() {
        return matchResult;
    }
}
