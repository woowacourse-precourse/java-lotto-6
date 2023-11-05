package lotto.config;

import java.util.Arrays;
import lotto.exception.LottoGameException;
import lotto.exception.RankException;

public enum Rank {

    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    public final int matchedCount;
    public final boolean matchesBonusNumber;
    public final int prize;

    Rank(int matchedCount, boolean matchesBonusNumber, int prize) {
        this.matchedCount = matchedCount;
        this.matchesBonusNumber = matchesBonusNumber;
        this.prize = prize;
    }

    public static Rank of(int matchedCount, boolean matchesBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank ->
                        rank.matchedCount == matchedCount
                                && rank.matchesBonusNumber == matchesBonusNumber)
                .findAny()
                .orElseThrow(() -> new LottoGameException(RankException.INVALID_CONDITION));
    }
}
