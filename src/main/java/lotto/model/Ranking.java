package lotto.model;

import static lotto.errorMessage.ExceptionErrorMessage.NOT_INCLUDE_RANKING;

import lotto.view.Output;

public enum Ranking {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    NOTHING(0, 0, "");

    private static final int MIN_MATCH = 3;
    private final int matchCount;

    private final int winningPrize;

    private final String matchMessage;

    Ranking(int matchCount, int winningPrize, String matchMessage) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
        this.matchMessage = matchMessage;
    }

    public static Ranking ranking(int matchCount, boolean matchBonus) {
        if (matchCount < MIN_MATCH) {
            return NOTHING;
        }

        if (SECOND.matchCount(matchCount) && matchBonus) {
            return SECOND;
        }
        for (Ranking rank : values()) {
            return rank;
        }
        throw new IllegalArgumentException(NOT_INCLUDE_RANKING);
    }

    private boolean matchCount(int count) { //count는 실제로 일치하는 개수
        return this.matchCount == count;
    }

    public void printMessage(int count) {
        if (this != NOTHING) {
            Output.result_match(matchMessage, count);
        }
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
