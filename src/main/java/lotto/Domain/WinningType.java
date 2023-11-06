package lotto.Domain;

import java.text.DecimalFormat;

public enum WinningType {
    FIRST_PLACE(6, 2000000000L),
    SECOND_PLACE(5, 30000000L),
    THIRD_PLACE(5, 1500000L),
    FORTH_PLACE(4, 50000L),
    FIFTH_PLACE(3, 5000L);


    private int matchCnt;
    private Long winningPrice;

    WinningType(int matchCnt, Long winningPrice) {
        this.matchCnt = matchCnt;
        this.winningPrice = winningPrice;
    }

    public Long getWinningPrice() {
        return winningPrice;
    }

    public int getMatchCnt() {
        return matchCnt;
    }
    public String getWinningPricePrintType() {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(getWinningPrice());
    }

}
