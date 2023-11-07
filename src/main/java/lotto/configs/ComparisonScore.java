package lotto.configs;

public enum ComparisonScore {
    ZERO(Constant.LOTTO_NONE_COUNT),
    THREE(Constant.LOTTO_FIFTH_COUNT),
    FOUR(Constant.LOTTO_FOURTH_COUNT),
    FIVE(Constant.LOTTO_THIRD_COUNT),
    SIX(Constant.LOTTO_FIRST_COUNT),
    FIVE_BONUS(Constant.LOTTO_SECOND_COUNT);

    private final int count;

    ComparisonScore(int count) {
        this.count = count;
    }

    public static ComparisonScore valueOf(int count, boolean matchBonus){
        if(count == Constant.LOTTO_SECOND_COUNT && matchBonus){
            return FIVE_BONUS;
        }
        for(ComparisonScore comparisonScore : ComparisonScore.values()){
            if(comparisonScore.count == count){
                return comparisonScore;
            }
        }
        return ZERO;
    }

    public int getCount() {
        return count;
    }
}
