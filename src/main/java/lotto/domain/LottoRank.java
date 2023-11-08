package lotto.domain;

public enum LottoRank {
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(30_000_000),
    THIRD_PLACE(1_500_000),
    FOURTH_PLACE(50_000),
    FIFTH_PLACE(5_000),
    NO_PRIZE(0);

    private final Integer winningAmount;

    LottoRank(Integer winningAmount) {
        this.winningAmount = winningAmount;
    }

    public Integer getWinningAmount() {
        return winningAmount;
    }
}
