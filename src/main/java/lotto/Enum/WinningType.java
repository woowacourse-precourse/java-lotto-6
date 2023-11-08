package lotto.Enum;

import java.text.DecimalFormat;

public enum WinningType {
    FIRST_PLACE("6개 일치", 2000000000L),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 30000000L),
    THIRD_PLACE("5개 일치", 1500000L),
    FORTH_PLACE("4개 일치", 50000L),
    FIFTH_PLACE("3개 일치", 5000L),
    NONE("", 0L);


    private String matchDesc;
    private Long winningPrice;

    WinningType(String matchDesc, Long winningPrice) {
        this.matchDesc = matchDesc;
        this.winningPrice = winningPrice;
    }

    public Long getWinningPrice() {
        return winningPrice;
    }

    public String getMatchDesc() {
        return matchDesc;
    }

    public String getWinningTypePrintType() {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(getWinningPrice());
    }

    @Override
    public String toString() {
        return matchDesc + " (" + getWinningTypePrintType() + "원) ";
    }
}
