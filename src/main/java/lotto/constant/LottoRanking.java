package lotto.constant;

public enum LottoRanking {

    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    NONE("꽝", 0);

    private final String winningCondition;
    private final int prizeMoney;

    LottoRanking(String winningCondition, int prizeMoney) {
        this.winningCondition = winningCondition;
        this.prizeMoney = prizeMoney;
    }

    public String getWinningCondition() {
        return winningCondition;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
