package lotto;

public enum WinningStatus {
    NONE(0, 0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_PLUS_BONUS(5, 30000000),
    SIX_MATCHES(6, 2000000000);

    private final int matches;
    private final int prize;

    WinningStatus(int matches, int prize) {
        this.matches = matches;
        this.prize = prize;
    }

    public int getMatches() {
        return matches;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningStatus valueOf(int matches, boolean bonus) {
        if (matches == FIVE_MATCHES.matches && bonus) {
            return FIVE_PLUS_BONUS;
        }
        for (WinningStatus status : values()) {
            if (status.matches == matches) {
                return status;
            }
        }
        return NONE;
    }
}