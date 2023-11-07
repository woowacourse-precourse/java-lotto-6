package lotto.Domain.LottoResult;

public enum Prize {
    FIRST_PRIZE(0, 2000000000, 6),
    SECOND_PRIZE(0, 30000000, 5),
    THIRD_PRIZE(0, 1500000, 5),
    FOURTH_PRIZE(0, 50000, 4),
    FIFTH_PRIZE(0, 5000, 3);

    private int winningCount;
    private final int award;
    private final int numberCount;

    Prize(int winningCount, int award, int numberCount) {
        this.winningCount = winningCount;
        this.award = award;
        this.numberCount = numberCount;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getAward() {
        return award;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public void increaseWinningCount() {
        this.winningCount ++;
    }

}
