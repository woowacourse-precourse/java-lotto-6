package lotto.domain;

public enum LottoRank {

    FIFTH(3, 5_000, "%d개 일치 (%,d원) - %d"),
    FOURTH(4, 50_000, "%d개 일치 (%,d원) - %d"),
    THIRD(5, 1_500_000, "%d개 일치 (%,d원) - %d"),
    SECOND(5, 30_000_000, "%d개 일치, 보너스 볼 일치 (%,d원) - %d"),
    FIRST(6, 2_000_000_000, "%d개 일치 (%,d원) - %d");

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
