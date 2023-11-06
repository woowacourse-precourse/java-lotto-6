package lotto.domain;

import lotto.view.OutputView;

public enum Ranking {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    Ranking(int countOfmatch, int winningAmount, String message) {
        this.countOfmatch = countOfmatch;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    private int countOfmatch;
    private int winningAmount;
    private String message;

    private static final int WINNING_MIN_COUNT = 3;

    public static Ranking valueOf(int countOfmatch, boolean matchBonus) {
        if (countOfmatch < WINNING_MIN_COUNT) {
            return MISS;
        }
        if (SECOND.matchCount(countOfmatch) && matchBonus) {
            return SECOND;
        }
        for (Ranking rank : values()) {
            if (rank.matchCount(countOfmatch) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean matchCount(int countOfmatch) {
        return this.countOfmatch == countOfmatch;
    }

    public void printMessage(int count) {
        if (this != MISS) {
            OutputView.printWinning(message, count);
        }
    }

}
