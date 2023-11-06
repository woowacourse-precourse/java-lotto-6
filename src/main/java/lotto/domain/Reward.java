package lotto.domain;

import java.util.function.IntPredicate;
import lotto.constant.GameConstant;

public enum Reward {

    FIRST_REWARD(luckyNumberCount -> luckyNumberCount == 6, bonusNumberCount -> bonusNumberCount == 0,1, GameConstant.FIRST_REWARD),
    SECOND_REWARD(luckyNumberCount -> luckyNumberCount == 5, bonusNumberCount -> bonusNumberCount == 1,2, GameConstant.SECOND_REWARD),
    THIRD_REWARD(luckyNumberCount -> luckyNumberCount == 5, bonusNumberCount -> bonusNumberCount == 0,3, GameConstant.THIRD_REWARD),
    FOURTH_REWARD(luckyNumberCount -> luckyNumberCount == 4, bonusNumberCount -> bonusNumberCount == 0,4, GameConstant.FOURTH_REWARD),
    FIFTH_REWARD(luckyNumberCount -> luckyNumberCount == 3, bonusNumberCount -> bonusNumberCount == 0,5, GameConstant.FIFTH_REWARD),
    NO_REWARD(luckyNumberCount -> luckyNumberCount < 3, bonusNumberCount -> bonusNumberCount >= 0 ,0, 0);
    private IntPredicate luckyNumberCount;
    private IntPredicate bonusNumberCount;
    private int rank;
    private int money;

    Reward(IntPredicate luckyNumberCount, IntPredicate bonusNumberCount, int rank, int money) {
        this.luckyNumberCount = luckyNumberCount;
        this.bonusNumberCount = bonusNumberCount;
        this.rank = rank;
        this.money = money;
    }

    public static Reward computer(int luckyNumberCount, int bonusNumberCount){
        for (Reward reward : values()){
            if (reward.luckyNumberCount.test(luckyNumberCount) && reward.bonusNumberCount.test(bonusNumberCount)){
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
