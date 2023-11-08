package lotto.domain.enums;

import lotto.View.OutputView;

public enum Rank {
    MISS(0, 0, "0개 일치 - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ");

    private int matchCount;
    private int winningAmount;
    private String message;

    Rank(int matchCount, int winningAmount, String message) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }

        if(SECOND.matchCount(matchCount) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(matchCount) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    private boolean matchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public void printMessage(int count) {
        if (this != MISS) {
            OutputView.printSuccessMessage(message, count);
        }
    }
}
