package lotto.domain;

import java.util.function.UnaryOperator;
import lotto.domain.constants.MatchingCount;

public class MatchingResult {

    private final MatchingCount matchingCount;
    private final boolean bonusMatching;

    private MatchingResult(Lotto lotto, WinningLotto winningLotto) {
        long count = winningLotto.countMatchingNumbers(lotto);
        this.matchingCount = MatchingCount.from(count);
        this.bonusMatching = winningLotto.containsBonusNumber(lotto);
    }

    public static MatchingResult of(Lotto lotto, WinningLotto winningLotto) {
        return new MatchingResult(lotto, winningLotto);
    }

    public boolean isBonusMatching(UnaryOperator<Boolean> matchingBonus) {
        return matchingBonus.apply(bonusMatching);
    }

    public boolean isSameMatchingCount(MatchingCount matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
