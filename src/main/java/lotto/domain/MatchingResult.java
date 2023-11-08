package lotto.domain;

import java.util.function.UnaryOperator;
import lotto.enums.MatchingCount;

public class MatchingResult {

    private final MatchingCount matchingCount;
    private final BonusMatching bonusMatching;

    private MatchingResult(final Lotto lotto, final WinningLotto winningLotto) {
        final long count = winningLotto.countMatchingNumbers(lotto);
        boolean status = winningLotto.containsBonusNumber(lotto);
        this.matchingCount = MatchingCount.from(count);
        this.bonusMatching = BonusMatching.from(status);
    }

    public static MatchingResult of(final Lotto lotto, final WinningLotto winningLotto) {
        return new MatchingResult(lotto, winningLotto);
    }

    public boolean isBonusMatching(final UnaryOperator<Boolean> matchingBonus) {
        return bonusMatching.isBonusMatching(matchingBonus);
    }

    public boolean isSameMatchingCount(final MatchingCount count) {
        return matchingCount.equals(count);
    }
}
