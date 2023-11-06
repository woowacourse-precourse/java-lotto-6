package lotto.domain;

import java.util.function.UnaryOperator;
import lotto.domain.enums.MatchingCount;

public class MatchingResult {

    private final MatchingCount matchingCount;
    private final boolean bonusMatching;

    private MatchingResult(final Lotto lotto, final WinningLotto winningLotto) {
        final long count = winningLotto.countMatchingNumbers(lotto);
        this.matchingCount = MatchingCount.from(count);
        this.bonusMatching = winningLotto.containsBonusNumber(lotto);
    }

    public static MatchingResult of(final Lotto lotto, final WinningLotto winningLotto) {
        return new MatchingResult(lotto, winningLotto);
    }

    public boolean isBonusMatching(final UnaryOperator<Boolean> matchingBonus) {
        return matchingBonus.apply(bonusMatching);
    }

    public boolean isSameMatchingCount(final MatchingCount matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
