package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "2,000,000,000원"),
    SECOND(5, true, 30_000_000, "30,000,000원"),
    THIRD(5, false, 1_500_000, "1,500,000원"),
    FOURTH(4, false, 50_000, "50,000원"),
    FIFTH(3, false, 5_000, "5,000원"),
    NONE(0, false, 0, "0원");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;
    private final String prizeMoneyString;

    Rank(int matchCount, boolean matchBonus, int prizeMoney, String prizeMoneyString) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
        this.prizeMoneyString = prizeMoneyString;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND.matchCount && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.matchBonus || matchBonus)) {
                return rank;
            }
        }

        return NONE;
    }

    public int getPrize() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getPrizeMoneyString() {
        return prizeMoneyString;
    }
}
