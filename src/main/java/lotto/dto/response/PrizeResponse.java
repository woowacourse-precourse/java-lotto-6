package lotto.dto.response;

import lotto.config.Prize;

public class PrizeResponse {

    private Prize prize;
    private int winningCount;

    public PrizeResponse(Prize prize, int winningCount) {
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public static PrizeResponse of(Prize prize, int winningCount) {
        return new PrizeResponse(prize, winningCount);
    }

    public Prize getPrize() {
        return prize;
    }

    public int getMatchingNumberCount() {
        return prize.getMatchingNumberCount();
    }

    public int getPrizeMoney() {
        return prize.getPrizeMoney();
    }

    public int getWinningCount() {
        return winningCount;
    }
}
