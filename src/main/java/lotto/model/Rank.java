package lotto.model;

import java.util.Arrays;

public enum Rank {

    BOOM(0, 0, "꽝 (0원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private static final int FIVE_COUNT = 5;

    private final int matchingCount;
    private final long price;
    private final String description;

    Rank(final int matchingCount, final long price, final String description) {
        this.matchingCount = matchingCount;
        this.price = price;
        this.description = description;
    }

    public static Rank of(final int count, final boolean hasBonus) {
        if (isFiveMatch(count)) {
            return getRankForFiveMatchesWithBonus(hasBonus);
        }
        return getRankByMatchingCount(count);
    }

    private static boolean isFiveMatch(final int count) {
        return count == FIVE_COUNT;
    }

    private static Rank getRankForFiveMatchesWithBonus(final boolean hasBonus) {
        if (hasBonus) {
            return SECOND;
        }
        return THIRD;
    }

    private static Rank getRankByMatchingCount(final int count) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchesCount(count))
                .findAny()
                .orElse(BOOM);
    }

    private boolean matchesCount(final int count) {
        return this.matchingCount == count;
    }

    public boolean isWinningRank() {
        return this != BOOM;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
