package lotto.domain;

public enum LottoRanking {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningAmount;

    LottoRanking(int countOfMatch, int winningAmount) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static LottoRanking valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.getCountOfMatch() == countOfMatch && matchBonus) {
            return SECOND;
        }

        if (SECOND.getCountOfMatch() == countOfMatch && !matchBonus) {
            return THIRD;
        }

        for (LottoRanking rank : values()) {
            if (rank.getCountOfMatch() == countOfMatch) {
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 접근입니다.");
    }

}
