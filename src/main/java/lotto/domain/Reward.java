package lotto.domain;

import java.util.function.IntPredicate;
import lotto.constant.GameConstant;

public enum Reward {

    FIRST_REWARD(totalCount -> totalCount == 6, bonusNumberCount -> bonusNumberCount == 0,1,
            "6개 일치 (2,000,000,000원) - ", GameConstant.FIRST_REWARD),
    SECOND_REWARD(totalCount -> totalCount == 6, bonusNumberCount -> bonusNumberCount == 1,2,
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ", GameConstant.SECOND_REWARD),
    THIRD_REWARD(totalCount -> totalCount == 5, bonusNumberCount -> bonusNumberCount >= 0,3,
            "5개 일치 (1,500,000원) - ", GameConstant.THIRD_REWARD),
    FOURTH_REWARD(totalCount -> totalCount == 4, bonusNumberCount -> bonusNumberCount >= 0,4,
            "4개 일치 (50,000원) - ", GameConstant.FOURTH_REWARD),
    FIFTH_REWARD(totalCount -> totalCount == 3, bonusNumberCount -> bonusNumberCount >= 0,5,
            "3개 일치 (5,000원) - ", GameConstant.FIFTH_REWARD),
    NO_REWARD(totalCount -> totalCount < 3, bonusNumberCount -> bonusNumberCount >= 0,0,
            "", 0);
    private IntPredicate totalCount;
    private IntPredicate bonusNumberCount;
    private int rank;
    private String message;
    private int money;

    Reward(IntPredicate totalCount, IntPredicate bonusNumberCount, int rank, String message,
            int money) {
        this.totalCount = totalCount;
        this.bonusNumberCount = bonusNumberCount;
        this.rank = rank;
        this.message = message;
        this.money = money;
    }

    public static Reward computer(int totalCount, int bonusNumberCount){
        for (Reward reward : values()){
            if (reward.totalCount.test(totalCount) && reward.bonusNumberCount.test(bonusNumberCount)){
                return reward;
            }
        }
        throw new IllegalStateException();
    }

    public int getRank() {
        return rank;
    }

    public String getMessage() {
        return message;
    }

    public int getMoney() {
        return money;
    }
}
