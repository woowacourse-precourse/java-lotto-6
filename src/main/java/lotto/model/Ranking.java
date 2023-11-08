package lotto.model;

import lotto.view.OutputView;

import static lotto.constant.MessageConstants.*;
import static lotto.constant.NumberConstants.*;

public enum Ranking {
    FIRST_PLACE(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND_PLACE(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PLACE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH_PLACE(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH_PLACE(3, 5_000, "3개 일치 (5,000원) - "),
    NOTHING(0, 0, "");

    Ranking(int matchNumber, int winningRecord, String message) {
        this.matchNumber = matchNumber;
        this.winningRecord = winningRecord;
        this.message = message;
    }

    private int matchNumber;
    private int winningRecord;
    private String message;

    public static Ranking getRanking(int matchNumber, boolean matchBonus) {
        if (matchNumber < WINNING_NUMBER_MIN) {
            return NOTHING;
        }
        if (SECOND_PLACE.matchCount(matchNumber) && matchBonus) {
            return SECOND_PLACE;
        }
        for (Ranking rank : values()) {
            if (rank.matchCount(matchNumber) && rank != SECOND_PLACE) {
                return rank;
            }
        }
        throw new IllegalArgumentException(ERROR);
    }

    public int getWinningMinCount() {
        return winningRecord;
    }

    public boolean matchCount(int matchCount) {
        return this.matchNumber == matchCount;
    }

    public void printMessage(int count) {
        if (this != NOTHING) {
            OutputView.printWinning(message, count);
        }
    }

}
