package lotto.manager;

import lotto.domain.Award;
import lotto.system.Constant;

import java.util.List;

public class YieldManager {

    public static float makeYield(List<Award> prizes){
        float beforeMoney = prizes.size() * Constant.MONEY_UNIT;
        float afterMoney = beforeMoney;
        for(Award award: prizes){
            afterMoney += award.getReward();
        }

        float yield = ((float)(afterMoney - beforeMoney) / beforeMoney) * 100;//백분율로 계산
        return Math.round(yield * 10)/ 10.0f;
    }
}
