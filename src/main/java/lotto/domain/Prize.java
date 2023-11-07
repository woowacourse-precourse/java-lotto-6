package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FAIL(0,0, false),
    FIFTH_GRADE(5_000,3, false),
    FOURTH_GRADE(50_000,4, false),
    THIRD_GRADE(1_500_000,5, false),
    SECOND_GRADE(30_000_000,5, true),
    FIRST_GRADE(2_000_000_000,6, false);


    private int reward;
    private int matchCount;
    private boolean isMatchBonus;

    Prize(int reward, int matchCount, boolean isMatchBonus) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public static Prize getPrize(int compareCount, boolean isMatchBonus){
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == compareCount && prize.getMatchBonus() == isMatchBonus)
                .findAny()
                .orElse(Prize.FAIL);
    }

    public boolean getMatchBonus(){
        return isMatchBonus;
    }

    public int getReward(){
        return reward;
    }

    public int getMatchCount(){
        return matchCount;
    }

}
