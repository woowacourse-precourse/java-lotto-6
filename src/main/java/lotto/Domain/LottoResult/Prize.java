package lotto.Domain.LottoResult;

public enum Prize {
    FIRST_PRIZE(0, 2000000000, 6),
    SECOND_PRIZE(0, 30000000, 5),
    THIRD_PRIZE(0, 1500000, 5),
    FOURTH_PRIZE(0, 50000, 4),
    FIFTH_PRIZE(0, 5000, 3);

    private Integer winningCount;
    private final Integer award;
    private final Integer numberCount;

    Prize(Integer winningCount, Integer award, Integer numberCount) {
        this.winningCount = winningCount;
        this.award = award;
        this.numberCount = numberCount;
    }

    public Integer getWinningCount() {
        return winningCount;
    }

    public Integer getAward() {
        return award;
    }

    public Integer getNumberCount() {
        return numberCount;
    }

    public void IncreaseWinningCount() {
        this.winningCount +=1;
    }

}
