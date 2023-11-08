package lotto.domain;

import java.util.EnumMap;
import lotto.enums.Reward;

public class Result {
    private static final int ADD_NUM = 1;

    private final int hitResult;
    private final int bonusResult;

    public Result(int hitResult, int bonusResult) {
        this.hitResult = hitResult;
        this.bonusResult = bonusResult;
    }

    public void compareResultToCriterion(EnumMap<Reward, Integer> totalResult, Reward reward) {
        if (reward.compareHitCnt(hitResult) && reward.compareBonusCnt(bonusResult)) {
            int preValue = totalResult.get(reward);
            totalResult.put(reward, preValue + ADD_NUM);
        }
    }
}
