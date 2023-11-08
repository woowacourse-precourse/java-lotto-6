package lotto.element;

import java.text.DecimalFormat;

public enum WinningDetails {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS( 5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchingNumbers;
    private final int prize;

    WinningDetails(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        String prizeStr = formatter.format(prize);
        if (this == BONUS) {
            return matchingNumbers + "개 일치, 보너스 볼 일치 (" + prizeStr + "원) ";
        }
        return matchingNumbers + "개 일치 (" + prizeStr + "원) "
                ;
    }
}
