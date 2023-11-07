package lotto.config;

import java.util.Arrays;
import lotto.Lotto;
import lotto.domain.WinningLotto;

public enum Rank {

    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    NO_RANK(0, false, 0);

    public final int matchedCount;
    public final boolean matchesBonusNumber;
    public final int prize;

    Rank(int matchedCount, boolean matchesBonusNumber, int prize) {
        this.matchedCount = matchedCount;
        this.matchesBonusNumber = matchesBonusNumber;
        this.prize = prize;
    }

    public static Rank of(WinningLotto winningLotto, Lotto lotto) {
        return Rank.of(
                winningLotto.countMatchingNumbers(lotto),
                winningLotto.matchesBonusNumber(lotto)
        );
    }

    private static Rank of(int matchedCount, boolean matchesBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank ->
                        rank.matchedCount == matchedCount
                                && rank.matchesBonusNumber == matchesBonusNumber)
                .findAny()
                .orElse(NO_RANK);
    }
}
