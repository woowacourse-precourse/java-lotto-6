package lotto.type;

public enum WinningResultType {
    WINNING_RESULT_NOTHING("당첨 안됨", 0),
    WINNING_RESULT_3_MATCH("3개 일치", 5000),
    WINNING_RESULT_4_MATCH("4개 일치", 50000),
    WINNING_RESULT_5_MATCH("5개 일치", 1500000),
    WINNING_RESULT_6_MATCH("6개 일치", 2000000000),
    WINNING_RESULT_5_MATCH_AND_BONUS_MATCH("5개 일치, 보너스 볼 일", 30000000),
    ;

    private String winningResult;
    private int winningPrice;

    WinningResultType(String winningResult, int winningPrice) {
        this.winningResult = winningResult;
        this.winningPrice = winningPrice;
    }

    public String getWinningResult() {
        return winningResult;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
