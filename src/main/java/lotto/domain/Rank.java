package lotto.domain;

import lotto.view.OutputView;

public enum Rank {

    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THRID(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    NOTHING(0, 0, "");

    private static final int MIN_MATCH_COUNT = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";

    private int matchCount;
    private int winningMoney;
    private String message;

    public static Rank valueOf(int matchNum, boolean matchBonus) {
        if (matchNum < MIN_MATCH_COUNT) {
            return NOTHING;
        }

        if (SECOND.match(matchNum) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.match(matchNum)) {
                return rank;
            }
        }

        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    Rank(int matchCount, int winningMoney, String message) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private boolean match(int countOfMatch) {
        return matchCount == countOfMatch;
    }


    public void printMessage(int count) {
        if (this != NOTHING) {
            OutputView.printSuccessMessage(message, count);
        }
    }


}
