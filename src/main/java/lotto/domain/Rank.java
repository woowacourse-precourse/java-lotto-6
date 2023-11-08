package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    BLANK(0, 0, (matchCount, matchBonusNumber) -> matchCount < 3),
    FIFTH(5000, 3, (matchCount, matchBonusNumber) -> matchCount == 3),
    FOURTH(50000, 4, (matchCount, matchBonusNumber) -> matchCount == 4),
    THIRD(1500000, 5, (matchCount, matchBonusNumber) -> matchCount == 5 && !matchBonusNumber),
    SECOND(30000000, 5, (matchCount, matchBonusNumber) -> matchCount == 5 && matchBonusNumber),
    FIRST(2000000000, 6, (matchCount, matchBonusNumber) -> matchCount == 6);

    private final int prize;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(int prize, int matchCount, BiPredicate<Integer, Boolean> isMatch) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isMatch = isMatch;
    }

    public static Rank from(int matchCount, boolean isMatchBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch.test(matchCount, isMatchBonusNumber))
                .findAny()
                .orElse(BLANK);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
