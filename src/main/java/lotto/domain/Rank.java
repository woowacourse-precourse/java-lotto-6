package lotto.domain;

import java.util.Arrays;

public enum Rank {

    BOOM(0, false, 0, "꽝 (0원)"),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchingCount;
    private final boolean hasBonusNumber;
    private final long price;
    private final String priceMessage;

    Rank(final int matchingCount, final boolean hasBonusNumber, final long price, final String priceMessage) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
        this.price = price;
        this.priceMessage = priceMessage;
    }

    public static Rank of(final int sameCount, final boolean sameBonus) {
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

    public long getPrice() {
        return price;
    }

    public String getPriceMessage() {
        return priceMessage;
    }

    public boolean isNotBoom() {
        return this != BOOM;
    }
}
