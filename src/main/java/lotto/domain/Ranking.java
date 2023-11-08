package lotto.domain;

public enum Ranking {
    FIRST(6, 2,000,000,000),
    SECOND(5, 30,000,000),
    THIRD(5, 1,500,000),
    FOURTH(4, 50,000),
    FIFTH(3, 5,000),
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";

    private int countOfMatch;
    private int winningAmount;

    public static Ranking valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT){
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus){
            return SECOND;
        }

        for (Ranking rank : values()) {
            if (rank.matchCount(countOfMatch) && rank != SECOND){
                return rank;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    Ranking(int countOfMatch, int winningAmount) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
