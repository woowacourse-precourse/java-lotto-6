package lotto.constant;

public enum LottoRank {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(0, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int winningCount, prize;

    LottoRank(int winningCount, int prize) {
        this.winningCount = winningCount;
        this.prize = prize;
    }

    public static LottoRank findRank(int winningCount, int bonus) {
        if (winningCount == 5 && bonus == 1) {
            return FIVE_BONUS;
        }
        for (LottoRank value : values()) {
            if(value.winningCount == winningCount) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }

}
