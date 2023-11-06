package lotto.model;

public enum LottoRankings {

    FIRST("6개 일치 (%s원) - %d개", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (%s원) - %d개", 30000000),
    THIRD("5개 일치 (%s원) - %d개", 1500000),
    FOURTH("4개 일치 (%s원) - %d개", 50000),
    FIFTH("3개 일치 (%s원) - %d개", 5000);

    private final String message;
    private final int winningAmount;

    LottoRankings(String message, int winningAmount) {
        this.message = message;
        this.winningAmount = winningAmount;
    }

    public String getMessage() {
        return message;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
