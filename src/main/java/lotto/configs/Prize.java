package lotto.configs;

public enum Prize {
    FIRST(ComparisonScore.SIX, Constant.LOTTO_FIRST_PRIZE),
    SECOND(ComparisonScore.FIVE_BONUS, Constant.LOTTO_SECOND_PRIZE),
    THIRD(ComparisonScore.FIVE, Constant.LOTTO_THIRD_PRIZE),
    FOURTH(ComparisonScore.FOUR, Constant.LOTTO_FOURTH_PRIZE),
    FIFTH(ComparisonScore.THREE, Constant.LOTTO_FIFTH_PRIZE),
    NONE(ComparisonScore.ZERO, Constant.LOTTO_NONE_PRIZE);

    private final int prize;
    private final ComparisonScore countOfMatch;

    Prize(ComparisonScore countOfMatch, int prize) {
        this.prize = prize;
        this.countOfMatch = countOfMatch;
    }

    public static Prize valueOf(ComparisonScore countOfMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.countOfMatch == countOfMatch) {
                return prize;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
