package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private int numberOfMatch;
    private int winnings;

    private Rank(int numberOfMatch, int winnings) {
        this.numberOfMatch = numberOfMatch;
        this.winnings = winnings;
    }

    public static Rank getRank(int numberOfMatch, boolean hasBonus) {
        if (hasBonus && SECOND.checkMatch(numberOfMatch)) {
            return SECOND;
        }

        return getOtherRank(numberOfMatch);
    }

    private static Rank getOtherRank(int numberOfMatch) {
        for (Rank rank : values()) {
            if (rank != SECOND && rank.checkMatch(numberOfMatch)) {
                return rank;
            }
        }

        return NOTHING;
    }

    private boolean checkMatch(int numberOfMatch) {
        return this.numberOfMatch == numberOfMatch;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public int getWinnings() {
        return winnings;
    }
}
