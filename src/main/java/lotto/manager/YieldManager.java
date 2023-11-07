package lotto.manager;

import java.util.List;
import lotto.domain.ResultLotto;
import lotto.system.Constants;
import lotto.util.Utils;

public class YieldManager {
    public static float makeYield(List<ResultLotto> prize) {
        float beforeMoney = prize.size() * Constants.MONEY_UNIT.getConstants(); // 8000
        float totalMoney = 0;
        for (ResultLotto result : prize) {
            totalMoney += result.getResult(); // 5000 + 8000
        }

        return Utils.calculateYield(totalMoney, beforeMoney);
    }
}
