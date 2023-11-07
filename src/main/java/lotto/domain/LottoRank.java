package lotto.domain;

import static lotto.domain.LottoConstant.*;

public enum LottoRank {

    FIFTH(FIRST_WINNER_HIT_COUNT, FIRST_WINNER_AMOUNT, "%d개 일치 (%,d원) - %d"),
    FOURTH(SECOND_WINNER_HIT_COUNT, SECOND_WINNER_AMOUNT, "%d개 일치 (%,d원) - %d"),
    THIRD(THIRD_WINNER_HIT_COUNT, THIRD_WINNER_AMOUNT, "%d개 일치 (%,d원) - %d"),
    SECOND(FORTH_WINNER_HIT_COUNT, FORTH_WINNER_AMOUNT, "%d개 일치, 보너스 볼 일치 (%,d원) - %d"),
    FIRST(FIFTH_WINNER_HIT_COUNT, FIFTH_WINNER_AMOUNT, "%d개 일치 (%,d원) - %d");

    private int matchCount;
    private int winningAmount;
    private String message;

    LottoRank(int matchCount, int winningAmount, String message) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getMessage() {
        return message;
    }
}
