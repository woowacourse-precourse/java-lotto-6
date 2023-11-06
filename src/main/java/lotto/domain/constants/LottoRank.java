package lotto.domain.constants;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    LOSE(2, false, 0),
    ;

    private final int count;
    private final boolean bonus;
    private final int winningAmount;

    LottoRank(int count, boolean bonus, int winningAmount) {
        this.count = count;
        this.bonus = bonus;
        this.winningAmount = winningAmount;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
