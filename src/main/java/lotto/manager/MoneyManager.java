package lotto.manager;

import java.util.Map;
import java.util.TreeMap;
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
        calculateTotalPrize(statistic);
        return prizeMoney.getProfitRateInfo(userBudget.getBudget());
    }

    private void calculateTotalPrize(Map<LottoWinningConstant, Integer> result) {
        int totalPrize = 0;
        for (LottoWinningConstant lottoWinningConstant : LottoWinningConstant.values()) {
            totalPrize += lottoWinningConstant.getWinningMoney() * result.get(lottoWinningConstant);
        }
        prizeMoney.addMoney(totalPrize);
        // prizeMoney.totalPrizeMoney.addMoney(totalPrize);
    }
}
