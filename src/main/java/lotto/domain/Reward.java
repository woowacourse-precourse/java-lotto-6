package lotto.domain;

import java.util.function.IntPredicate;
import lotto.constant.GameConstant;

public enum Reward {

    FIRST_REWARD(matchCount -> matchCount == 6, bonusCount -> bonusCount == 0,
            1, GameConstant.FIRST_REWARD),
    SECOND_REWARD(matchCount -> matchCount == 5, bonusCount -> bonusCount == 1,
            2, GameConstant.SECOND_REWARD),
    THIRD_REWARD(matchCount -> matchCount == 5, bonusCount -> bonusCount == 0,
            3, GameConstant.THIRD_REWARD),
    FOURTH_REWARD(matchCount -> matchCount == 4, bonusCount -> bonusCount >= 0,
            4, GameConstant.FOURTH_REWARD),
    FIFTH_REWARD(matchCount -> matchCount == 3, bonusCount -> bonusCount >= 0,
            5, GameConstant.FIFTH_REWARD),
    NO_REWARD(matchCount -> matchCount < 3, bonusCount -> bonusCount >= 0 ,
            0, 0);
    private IntPredicate matchCount;
    private IntPredicate bonusCount;
    private int rank;
    private int money;

    Reward(IntPredicate matchCount, IntPredicate bonusCount, int rank, int money) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.rank = rank;
        this.money = money;
    }

    public static Reward computer(int matchCount, int bonusCount){
        for (Reward reward : values()){
            if (reward.matchCount.test(matchCount) && reward.bonusCount.test(bonusCount)){
                return reward;
            }
        }
        return NO_REWARD;
    }

    public int getRank() {
        return rank;
    }
    public int getMoney() {
        return money;
    }
}
