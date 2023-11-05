package lotto.constant;

public enum LottoRank {

    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    FIVE_BONUS(7);

    private final int winningCount;

    LottoRank(int winningCount) {
        this.winningCount = winningCount;
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
