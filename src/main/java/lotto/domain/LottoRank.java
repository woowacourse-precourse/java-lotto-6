package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoRank {
    FIFTH(3, false, 5_000L, (sameNumberCount, bonusMatch) -> sameNumberCount == 3),
    FOURTH(4, false, 50_000L, (sameNumberCount, bonusMatch) -> sameNumberCount == 4),
    THIRD(5, false, 1_500_000L, (sameNumberCount, bonusMatch) -> sameNumberCount == 5 && !bonusMatch),
    SECOND(5, true, 30_000_000L, (sameNumberCount, bonusMatch) -> sameNumberCount == 5 && bonusMatch),
    FIRST(6, false, 2_000_000_000L, (sameNumberCount, bonusMatch) -> sameNumberCount == 6),
    NONE(0, false, 0L, (sameNumberCount, bonusMatch) -> sameNumberCount <= 2);

    private final int matchingCount;
    private final boolean bonusMustMatch;
    private final long prize;
    private final BiFunction<Integer, Boolean, Boolean> winCondition;

    LottoRank(int matchingCount, boolean bonusMustMatch, long prize,
              BiFunction<Integer, Boolean, Boolean> winCondition) {
        this.matchingCount = matchingCount;
        this.bonusMustMatch = bonusMustMatch;
        this.prize = prize;
        this.winCondition = winCondition;
    }

    public static LottoRank of(int matchingCount, boolean bonusNumberMatch) {

        return Arrays.stream(values())
                .filter(rank -> rank.conditionMatch(matchingCount, bonusNumberMatch))
                .findFirst()
                .orElse(NONE);
    }

    private boolean conditionMatch(int matchingCount, boolean bonusMatch) {
        return winCondition.apply(matchingCount, bonusMatch);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonusMustMatch() {
        return bonusMustMatch;
    }

    public long getPrize() {
        return prize;
    }
}
