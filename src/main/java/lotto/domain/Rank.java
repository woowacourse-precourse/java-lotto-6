package lotto.domain;

import java.util.Arrays;

public enum Rank {

    BOOM(0, false, "꽝 (0원)"),
    FIFTH(3, false, "3개 일치 (5,000원)"),
    FOURTH(4, false, "4개 일치 (50,000원)"),
    THIRD(5, false, "5개 일치 (1,500,000원)"),
    SECOND(5, true, "5개 일치 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, "6개 일치 (2,000,000,000원)");

    private final int matchingCount;
    private final boolean hasBonusNumber;
    private final String price;

    Rank(final int matchingCount, final boolean hasBonusNumber, final String price) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
        this.price = price;
    }

    public Rank getRank(int sameCount, boolean sameBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchingRank(sameCount, sameBonus))
                .findAny()
                .orElse(BOOM);
    }

    private boolean isMatchingRank(final int sameCount, final boolean sameBonus) {
        return hasFiveCountAndBonus(sameCount, sameBonus) || hasMatchingCount(sameCount);
    }

    private boolean hasFiveCountAndBonus(final int sameCount, final boolean sameBonus) {
        return sameCount == 5 && this.hasBonusNumber == sameBonus;
    }

    private boolean hasMatchingCount(final int sameCount) {
        return this.matchingCount == sameCount;
    }
}
