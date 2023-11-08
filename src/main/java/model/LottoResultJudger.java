/**
 * @Package_name : model
 * @Class_name : LottoResultJudger
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model;

import java.util.Map;
import model.enums.LottoWinPrize;
import model.enums.LottoWinResults;

public class LottoResultJudger {
    private double profit;
    private int paidMoney;

    public LottoResultJudger(Map<String, Integer> winResults, int paidMoney) {
        profit = 0.0;
        profit += winResults.get(LottoWinResults.LOTTO_3SAME.getMessage()) * LottoWinPrize.LOTTO_3SAME_PRIZE.getValue();
        profit += winResults.get(LottoWinResults.LOTTO_4SAME.getMessage()) * LottoWinPrize.LOTTO_4SAME_PRIZE.getValue();
        profit += winResults.get(LottoWinResults.LOTTO_5SAME.getMessage()) * LottoWinPrize.LOTTO_5SAME_PRIZE.getValue();
        profit += winResults.get(LottoWinResults.LOTTO_5SAME_BONUS.getMessage())
                * LottoWinPrize.LOTTO_5SAME_BONUS_PRIZE.getValue();
        profit += winResults.get(LottoWinResults.LOTTO_6SAME.getMessage()) * LottoWinPrize.LOTTO_6SAME_PRIZE.getValue();

        this.paidMoney = paidMoney;
    }

    /**
     * Description : 수익률 계산 (소수점 1개 )
     *
     * @Method : getProfit()
     * @return : double
     */
    public double getProfit() {
        double finalProfit = profit / paidMoney * 100;
        return Double.parseDouble(String.format("%.2f", finalProfit));
    }
}
