package lotto.domain;

import java.util.function.UnaryOperator;
import lotto.domain.constants.MatchingCount;

public class LottoMatchingResult {

    private final MatchingCount matchingCount;
    private final boolean bonusMatching;

    private LottoMatchingResult(Lotto lotto, WinningLotto winningLotto) {
        long count = winningLotto.countMatchingNumbers(lotto);
        this.matchingCount = MatchingCount.from(count);
        this.bonusMatching = winningLotto.containsBonusNumber(lotto);
    }

    public static LottoMatchingResult of(Lotto lotto, WinningLotto winningLotto) {
        return new LottoMatchingResult(lotto, winningLotto);
    }

    public boolean isBonusMatching(UnaryOperator<Boolean> matchingBonus) {
        return matchingBonus.apply(bonusMatching);
    }

    public boolean isSameMatchingCount(MatchingCount matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
