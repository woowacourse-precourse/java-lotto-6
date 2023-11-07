package lotto.domain;

public enum Winning {
    DEFAULT(0, 0),
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_BONUS(7, 30_000_000),
    SIXTH(6, 2_000_000_000);

    private final int matchCount;
    private final int winningAmount;

    Winning(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }
    public int getWinningAmount() {
        return winningAmount;
    }

    public Winning valueOf(int matchCount) {
        for(Winning winning : Winning.values()) {
            if(winning.matchCount == matchCount) {
                return winning;
            }
        }
        return DEFAULT;
    }
}
