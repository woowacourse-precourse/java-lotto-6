package lotto.service;

public enum WinningPolicy {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NONE(0, 0);

    private final int matchCount;
    private final int amount;

    WinningPolicy(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public static WinningPolicy of(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        for (WinningPolicy winningPolicy : WinningPolicy.values()) {
            if (winningPolicy.matchCount == matchCount && winningPolicy != SECOND) {
                return winningPolicy;
            }
        }
        return NONE;
    }

}
