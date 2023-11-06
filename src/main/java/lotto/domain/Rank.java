package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0)
    ;

    private final int matchCount;
    private final boolean matchBonus;
    private final long winningMoney;

    Rank(int matchCount, boolean matchBonus, long winningMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        final String message = "%d개 일치 (%d원)";
        final String bonusMessage = "%d개 일치, 보너스 볼 일치 (%d원)";
        if (this == SECOND) {
            return String.format(bonusMessage, winningMoney);
        }
        return String.format(message, matchCount, winningMoney);
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MISS;
    }

}
