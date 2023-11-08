package lotto;

public enum Result {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");
    Result(int countMatch, int winningAmount, String message) {
        this.countMatch = countMatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    private static final int WINNING_MIN = 3;

    private int countMatch;
    private int winningAmount;
    private String message;

    public static Result valueOf(int countMatch, boolean matchBonus) {
        if (countMatch < WINNING_MIN) {
            return MISS;
        }

        if (SECOND.matchCount(countMatch) && matchBonus) {
            return SECOND;
        }

        for (Result rank : values()) {
            if (rank.matchCount(countMatch) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getCountOfMatch() {
        return countMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    private boolean matchCount(int countOfMatch) {
        return this.countMatch == countOfMatch;
    }
}
