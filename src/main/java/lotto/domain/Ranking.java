package lotto.domain;

public enum Ranking {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTY(3, 5_000, "3개 일치 (5,000원) - "),
    NOTHING(0, 0, "");

    private static final int MIN_WINNING_COUNT = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";

    private int matchNumber;
    private int winningMoney;
    private String message;

    Ranking(int matchNumber, int winningMoney, String message) {
        this.matchNumber = matchNumber;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Ranking getRanking(int matchNumber, boolean matchBonus) {
        if (matchNumber < MIN_WINNING_COUNT) {
            return NOTHING;
        }

        if (SECOND.matchCount(matchNumber) && matchBonus) {
            return SECOND;
        }

        for (Ranking rank : values()) {
            if (rank.matchCount(matchNumber) && rank != SECOND) {
                return rank;
            }
        }

        for (Ranking rank : values()) {
            if (rank.matchCount(matchNumber) && rank != SECOND) {
                return rank;
            }
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private boolean matchCount(int matchNumber) {
        return this.matchNumber == matchNumber;
    }

    public int getMoney() {
        return winningMoney;
    }

    public int getMatchLottoNumber() {
        return matchNumber;
    }
}
