package lotto;

import static lotto.constant.Constants.BONUS_BALL;
import static lotto.enumerate.LottoPrize.MATCH_3;
import static lotto.enumerate.LottoPrize.MATCH_4;
import static lotto.enumerate.LottoPrize.MATCH_5;
import static lotto.enumerate.LottoPrize.MATCH_5_PLUS_BONUS;
import static lotto.enumerate.LottoPrize.MATCH_6;

import java.util.Map;

public class ProfitCalculator {

    public double calculateProfit(int moneyInput, Map<Integer, Integer> winners) {
        int prize = 0;
        for (Map.Entry<Integer, Integer> entry : winners.entrySet()) {
            int match = entry.getKey();
            int count = entry.getValue();
            if (match == 3) {
                prize += MATCH_3.getPrize() * count;
            }
            if (match == 4) {
                prize += MATCH_4.getPrize() * count;
            }
            if (match == 5) {
                prize += MATCH_5.getPrize() * count;
            }
            if (match == 5 + BONUS_BALL) {
                prize += MATCH_5_PLUS_BONUS.getPrize() * count;
            }
            if (match == 6) {
                prize += MATCH_6.getPrize() * count;
            }
        }
        double profit = (double) prize / (double) moneyInput * 100;
        return profit;
    }
}
