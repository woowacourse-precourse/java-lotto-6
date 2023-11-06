package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_RANK(0, 0);

    private final int matchCount;
    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank findByMatchCountAndBonus(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return NO_RANK;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 5 && !matchBonus) {
            return THIRD;
        }
        if (matchCount == 5) {
            return SECOND;
        }
        return FIRST;
    }
}
