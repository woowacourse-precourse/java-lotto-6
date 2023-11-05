package lotto.domain;

import java.text.NumberFormat;

public enum WinningRank {
    FIFTH(3, "3개 일치 (%s원) - %d", 5_000, 0),
    FOURTH(4, "4개 일치 (%s원) - %d", 50_000, 0),
    THIRD(5, "5개 일치 (%s원) - %d", 1_5000_000, 0),
    SECOND(5, "5개 일치, 보너스 볼 일치 (%s원) - %d", 30_000_000, 0),
    FIRST(6, "6개 일치 (%s원) - %d", 2_000_000_000, 0);

    private final int matchCount;
    private final String message;
    private final int prizeMoney;
    private int winCount;

    WinningRank(int matchCount, String message, int prizeMoney, int winCount) {
        this.matchCount = matchCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.winCount = winCount;
    }

    public void increaseWinCount() {
        this.winCount++;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedPrizeMoney = numberFormat.format(prizeMoney);
        return String.format(message, formattedPrizeMoney, winCount);
    }

}
