package lotto.domain;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    BLANK(0, 0, false);

    private final int price;
    private final int matchCount;
    private final boolean isMatchBonusNumber;

    Rank(int price, int matchCount, boolean isMatchBonusNumber) {
        this.price = price;
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }
}
