package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH_PLACE(3, 0, 5000L, "5,000"),
    FOURTH_PLACE(4, 0, 50000L, "50,000"),
    THIRD_PLACE(5, 0, 1500000L, "1,500,000"),
    SECOND_PLACE(5, 1, 30000000L, "30,000,000"),
    FIRST_PLACE(6, 0,2000000000L, "2,000,000,000");

    private final int rightCnt;
    private final int bonusCnt;
    private final long winningAmount;
    private final String amountStr;

    LottoRank(int rightCnt, int bonusCnt, long winningAmount, String amountStr) {
        this.rightCnt = rightCnt;
        this.bonusCnt = bonusCnt;
        this.winningAmount = winningAmount;
        this.amountStr = amountStr;
    }

    public static LottoRank findRank(int cnt, int bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.rightCnt == cnt && lottoRank.bonusCnt == bonus)
                .findAny()
                .orElseThrow();
    }

    public int getRightCnt() {
        return rightCnt;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public String getAmountStr() {
        return amountStr;
    }
}
