package lotto.model.lotto;

import java.util.Arrays;

public enum LottoInfo {
    FIRST_WINNER(4,"6개 일치 (2,000,000,000원)", 2000000000),
    SECOND_WINNER(3, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD_WINNER(2, "5개 일치 (1,500,000원)", 1500000),
    FOURTH_WINNER(1, "4개 일치 (50,000원)", 50000),
    FIFTH_WINNER(0,"3개 일치 (5,000원)", 5000);

    private final int index;
    private final String info;
    private final int winningAmount;
    LottoInfo(int index, String info, int winningAmount) {
        this.index = index;
        this.info = info;
        this.winningAmount = winningAmount;
    }

    public String getInfo() {
        return info;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getIndex() {
        return index;
    }

}
