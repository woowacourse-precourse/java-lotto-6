package lotto.domain;

import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, false, 0, "상금 획득 실패")
    ;

    Rank(int countOfMatch, boolean bonus, int winningPrice, String message) {
        this.countOfMatch = countOfMatch;
        this.bonus = bonus;
        this.winningPrice = winningPrice;
        this.message = message;
    }

    private final int countOfMatch;
    private final boolean bonus;
    private final int winningPrice;
    private final String message;

    public static Rank value(int count, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.countOfMatch == count && rank.bonus == bonus) {
                return rank;
            }
        }
        return MISS;
    }

    public void responseMessage(int countOfMatch) {
        if (this != MISS) {
            OutputView.responseWinningResultDetails(message, countOfMatch);
        }
    }

    public int getWinningPrice() {
        return winningPrice;
    }

}
