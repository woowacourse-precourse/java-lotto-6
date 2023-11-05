package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false),
    LOSING_TICKET(0, 0, false);

    private final int matchingCount;
    private final int prizeMoney;
    private final boolean hasBonusNumber;

    Rank(int matchingCount, int prizeMoney, boolean hasBonusNumber) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank of(int matchingCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchingCount(matchingCount))
                .filter(rank -> rank.isSameHasBonusNumber(hasBonusNumber))
                .findAny()
                .orElse(LOSING_TICKET);
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public boolean isHasBonusNumber() {
        return this.hasBonusNumber;
    }

    public long multiplePrizeAndCount(int winningCount) {
        return (long) this.getPrizeMoney() * winningCount;
    }

    private boolean isSameHasBonusNumber(boolean hasBonusNumber) {
        return this.hasBonusNumber == hasBonusNumber;
    }

    private boolean isSameMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }
}