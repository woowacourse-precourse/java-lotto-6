package lotto.domain;

import java.text.DecimalFormat;

public enum CheckTickets {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS( 5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    CheckTickets(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        String stringOfPrize = formatter.format(prize);
        if (this == BONUS) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + stringOfPrize + "원) ";
        }
        return matchCount + "개 일치 (" + stringOfPrize + "원) ";
    }
}