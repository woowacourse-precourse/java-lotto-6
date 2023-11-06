package lotto.domain.enums;

import java.util.Arrays;

public enum Score {

    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    MISS(0, false, 0L);

    private final int matchCount;
    private final boolean containBonusNumber;
    private final long prize;

    Score(int matchCount, boolean containBonusNumber, long prize) {
        this.matchCount = matchCount;
        this.containBonusNumber = containBonusNumber;
        this.prize = prize;
    }

    public static Score of(int matchCount, boolean containBonusNumber) {
        return Arrays.stream(values())
                .filter(score -> score.isMatch(matchCount, containBonusNumber))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isMatch(int matchCount, boolean containBonusNumber) {
        return this.matchCount == matchCount && this.containBonusNumber == containBonusNumber;
    }

}
