package lotto.domain;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, false, 2_000_000_000, (matchingCount, matchBonusNumber) -> matchingCount == 6),
    SECOND(5, true, 30_000_000, (matchingCount, matchBonusNumber) -> matchingCount == 5 && matchBonusNumber),
    THIRD(5, false, 1_500_000, (matchingCount, matchBonusNumber) -> matchingCount == 5 && !matchBonusNumber),
    FOURTH(4, false, 50_000, (matchingCount, matchBonusNumber) -> matchingCount == 4),
    FIFTH(3, false, 5_000, (matchingCount, matchBonusNumber) -> matchingCount == 3),
    NONE(0, false, 0, (matchingCount, matchBonusNumber) -> matchingCount <= 2);

    private final int matchingCount;
    private final boolean matchBonusNumber;
    private final long prizeMoney;
    public final BiFunction<Integer, Boolean, Boolean> rankSelection;

    Rank(int matchingCount, boolean matchBonusNumber, long prizeMoney,
         BiFunction<Integer, Boolean, Boolean> rankSelection) {
        this.matchingCount = matchingCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeMoney = prizeMoney;
        this.rankSelection = rankSelection;
    }

    public static Rank from(int matchingCount, boolean matchBonusNumber) {
        return switch (matchingCount) {
            case 6 -> Rank.FIRST;
            case 5 -> {
                yield matchBonusNumber ? Rank.SECOND : Rank.THIRD;
            }
            case 4 -> Rank.FOURTH;
            case 3 -> Rank.FIFTH;
            default -> Rank.NONE;
        };
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
