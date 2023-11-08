package lotto.manager;

import java.util.Map;
import lotto.model.money.PrizeMoney;
import lotto.model.money.UserBudget;
import lotto.utils.constant.LottoWinningConstant;

public class MoneyManager {

    private UserBudget userBudget;
    private PrizeMoney prizeMoney;

    public MoneyManager(UserBudget userBudget, PrizeMoney prizeMoney) {
        this.userBudget = userBudget;
        this.prizeMoney = prizeMoney;
    }

    public float getProfitRate(Map<LottoWinningConstant, Integer> statistic) {
        calculate(statistic);
        return prizeMoney.getProfitRateInfo(userBudget.getBudget());
    }

    private void calculate(Map<LottoWinningConstant, Integer> statistic) {
        prizeMoney.totalPrizeMoney.calculateTotalPrize(statistic);
    }
}
