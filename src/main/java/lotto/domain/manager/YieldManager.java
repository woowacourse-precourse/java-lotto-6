package lotto.domain.manager;

import lotto.domain.Award;
import lotto.system.Constant;
import lotto.util.Util;

import java.util.List;

public class YieldManager {

    public static float makeYield(List<Award> prizes) {
        float beforeMoney = prizes.size() * Constant.MONEY_UNIT;
        float totalMoney = beforeMoney;
        for (Award award : prizes) {
            totalMoney += award.getReward();
        }
        return Util.calculateYield(beforeMoney, totalMoney);
    }
}
